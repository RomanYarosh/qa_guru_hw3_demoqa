package tests;

import pages.RegistrationPage;
import org.junit.jupiter.api.Test;
import pages.components.CheckForm;

public class PracticeFormDemoqaPageObjects extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void fillFormTest() {
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName("Yar")
                .setEmail("roman@email.com")
                .setGender("Male")
                .setNumber("0123456789")
                .setDateOfBirth("01", "June", "1993")
                .setSubject("Comp")
                .setSubject("En")
                .setHobbies("Sports")
                .setHobbies("Music")
                .scrollToSubmitButton()
                .setPicture("image.jpg")
                .setAddress("My home")
                .setState("Haryana")
                .setCity("Panipat")
                .setSubmit();
        new CheckForm()
                .checkResult("Student Name", "Roman Yar")
                .checkResult("Student Email", "roman@email.com")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789")
                .checkResult("Date of Birth", "01 June,1993")
                .checkResult("Subjects", "Computer Science, English")
                .checkResult("Hobbies", "Sports, Music")
                .checkResult("Picture", "image.jpg")
                .checkResult("Address", "My home")
                .checkResult("State and City", "Haryana Panipat");
    }
    @Test
    void fillMinimalFormTest() {
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName("Yar")
                .setGender("Male")
                .setNumber("0123456789")
                .scrollToSubmitButton()
                .setSubmit();
        new CheckForm()
                .checkResult("Student Name", "Roman Yar")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789");
    }
    @Test
    void fillNegativeFormTest() {
        registrationPage.openPage()
                .setFirstName("Roman")
                .setLastName("Yar")
                .setGender("Male")
                .setNumber("0123456789")
                .scrollToSubmitButton()
                .setSubmit();
        new CheckForm()
                .checkResult("Student Name", "Roman Yar")
                .checkResult("Gender", "Male")
                .checkResult("Mobile", "0123456789");
    }
}
