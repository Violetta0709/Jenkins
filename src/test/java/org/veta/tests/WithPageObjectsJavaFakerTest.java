package org.veta.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.veta.pages.components.RegistrationFormPage;
import org.veta.pages.components.RegistrationFormPage;
import org.veta.testsData.Student;
import org.veta.testsData.Student;

public class WithPageObjectsJavaFakerTest extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @DisplayName("Test of registration form")
    @Story("Filling registration form")
    @Owner("Veta")
    @Severity(SeverityLevel.BLOCKER)
    @Link("https://demoqa.com")
    @Test
        void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(Student.firstName)
                .setLastName(Student.lastName)
                .setEmail(Student.email)
                .setGender(Student.gender)
                .setNumber(Student.phone)
                //.setBirthDate(Student.day, Student.month, Student.year)
                .setSubject(Student.subject)
                .setHobbies(Student.hobby)
                .uploadPic(Student.picturePath)
                .setAddress(Student.address, Student.state, Student.city)
                .clickSubmit();

        registrationFormPage.checkResultsTableVisible()
                .checkResult("Student Name", Student.firstName + " " + Student.lastName)
                .checkResult("Student Email", Student.email)
                .checkResult("Gender", Student.gender)
                .checkResult("Mobile", Student.phone)
                //.checkResult("Date of Birth", Student.birthDay)
                .checkResult("Subjects", Student.subject)
                .checkResult("Hobbies", Student.hobby)
                .checkResult("Picture", Student.picture)
                .checkResult("Address", Student.address)
                .checkResult("State and City", Student.state + " " + Student.city);
    }
}


