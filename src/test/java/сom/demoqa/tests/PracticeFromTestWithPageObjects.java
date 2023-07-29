package сom.demoqa.tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import static сom.demoqa.utils.RandomUtils.*;
import сom.demoqa.pages.PracticeFormPage;

import java.util.Locale;

public class PracticeFromTestWithPageObjects extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();


        @Test
        void successTest(){

            Faker faker = new Faker(new Locale("en"));
            String
                    firstName = faker.name().firstName(),
                    lastName = faker.name().lastName(),
                    userEmail = faker.internet().emailAddress(),
                    gender = getRandomGender(),
                    number = faker.phoneNumber().subscriberNumber(10),
                    subject = getRandomSubject(),
                    pictureURL = "imageTest.png",
                    address = faker.address().fullAddress(),
                    day = String.format("%02d", faker.number().numberBetween(1, 28)),
                    month = getRandomMonth(),
                    year = String.valueOf(getRandomInt(1960, 2000)),
                    hobbies = getRandomHobby(),
                    state = getRandomState(),
                    city = getRandomCity();

            practiceFormPage
                    .openPage()
                    .footerRemove()
                    .setFirstName(firstName)
                    .setLastName(lastName)
                    .setUserEmail(userEmail)
                    .setGender()
                    .setNumber(number)
                    .setDateOfBirth(day, month, year)
                    .setSubject(subject)
                    .setHobbie()
                    .setPicture(pictureURL)
                    .setAddress(address)
                    .setState()
                    .setCity()
                    .submit();

}
            practiceFormPage
                    .verifyModalDialogWindow()
                    .verifyResult("Student Name",  firstName + " " + lastName)
                    .verifyResult("Student Email", userEmail)
                    .verifyResult("Gender", gender)
                    .verifyResult("Mobile", number)
                    .verifyResult("Date of Birth", day + " " + month + "," + year)
                    .verifyResult("Subjects", subject)
                    .verifyResult("Hobbies", hobbies)
                    .verifyResult("Picture", pictureURL)
                    .verifyResult("Address", address)
                    .verifyResult("State and City", state + " " + city);
        }


    }
