package сom.demoqa.pages;

import com.codeborne.selenide.SelenideElement;
import сom.demoqa.pages.components.CalendarComponent;
import сom.demoqa.pages.components.ResultTableComponent;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class PracticeFormPage {
    CalendarComponent calendar = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();


    SelenideElement
            firstNameInput =  $("#firstName"),
            lastNameInput =  $("#lastName"),
            userEmailInput =  $("#userEmail"),
            genderWrapper = $(byText("Female")),
            userNumber = $("#userNumber"),
            birthDayInput = $("#dateOfBirthInput"),
            subjectsInput =  $("#subjectsInput"),

            subjectsMathInput = $("#react-select-2-option-0"),
            hobbiesWrapper = $("#hobbiesWrapper").$(byText("Reading")),
            picture = $("#uploadPicture"),
            currentAddressInput = $("#currentAddress"),
            stateCityWrapper = $("#stateCity-wrapper"),
            stateWrapper = $("#state"),
            cityWrapper = $("#city"),
            submitButton = $("#submit");

    public PracticeFormPage openPage () {
        open("/automation-practice-form");

        return this;
    }

    public PracticeFormPage footerRemove () {

        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        return this;
    }

    public PracticeFormPage setFirstName ( String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public PracticeFormPage setLastName (String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public PracticeFormPage setUserEmail (String value) {
        userEmailInput.setValue(value);

        return this;
    }

    public PracticeFormPage setGender () {
        genderWrapper.click();

        return this;
    }

    public PracticeFormPage setNumber (String value) {
        userNumber.setValue(value);

        return this;
    }
    public PracticeFormPage setDateOfBirth (String day, String month, String year) {
            birthDayInput.click();
            calendar.setDateOfBirth(day, month, year);

        return this;
    }
    public PracticeFormPage setSubject (String value) {
        subjectsInput.setValue(value);
        subjectsMathInput.click();

        return this;
    }
    public PracticeFormPage setHobbie () {
        hobbiesWrapper.click();

        return this;
    }
    public PracticeFormPage setPicture (String value) {
        picture.uploadFromClasspath(value);

        return this;
    }
    public PracticeFormPage setAddress (String value) {
        currentAddressInput.setValue(value);

        return this;
    }

    public PracticeFormPage setState () {
        stateWrapper.click();
        stateCityWrapper.$(byText("NCR")).click();

        return this;
    }
    public PracticeFormPage setCity () {
        cityWrapper.click();
        stateCityWrapper.$(byText("Delhi")).click();

        return this;
    }
    public PracticeFormPage submit () {
        submitButton.click();

        return this;
    }

    public PracticeFormPage verifyModalDialogWindow() {
        resultTableComponent.verifyModalDialogAppeared();

        return this;
    }

    public PracticeFormPage verifyResult(String label, String value) {
        resultTableComponent.verifyTableContent(label, value);

        return this;
    }


}
