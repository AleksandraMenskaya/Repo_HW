package test;

import data.TestData;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.StepsForTestPage;

import java.text.SimpleDateFormat;
import java.util.Locale;


public class FillFormTestWithFaker extends TestBase {
    StepsForTestPage stepsForTestPage = new StepsForTestPage();
    TestData data = new TestData();
    private final SimpleDateFormat dateFormatter = new SimpleDateFormat("dd MMMMM,yyyy", Locale.US);
    @Test
    @Tag("formFill_Test")
        // Заполнение формы, все поля
    void successfulFillFormTest() {

        stepsForTestPage.openPage()
            .removeBanners()
            .setFirstName(data.firstName)
            .setLastName(data.lastName)
            .setUserEmail(data.eMail)
            .setGenderWrapper(data.gender)
            .setUserNumber(data.phoneNumber)
            .setDateOfBirth(data.dateOfBirth)
            .selectSubjects(data.subjects)
            .selectHobbies(data.hobby)
            .uploadPicture("imagesForTest.jfif")
            .setCurrentAddress(data.currentAddress)
            .selectState(data.state)
            .selectCity(data.city)
            .sendForm();

        stepsForTestPage.checkResult("Student Name", data.firstName + " " + data.lastName)
            .checkResult("Student Email", data.eMail)
            .checkResult("Gender", data.gender)
            .checkResult("Mobile", data.phoneNumber)
            .checkResult("Date of Birth", dateFormatter.format(data.dateOfBirth))
            .checkResult("Subjects", data.subjects)
            .checkResult("Hobbies", data.hobby)
            .checkResult("Picture", "imagesForTest.jfif")
            .checkResult("Address", data.currentAddress)
            .checkResult("State and City", data.state + " " + data.city);
    }

    @Test
    @Tag("formFill_Test")
        // Заполнение формы, обязательные поля
    void successfulMinimumDataFillFormTest() {

        stepsForTestPage.openPage()
            .removeBanners()
            .setFirstName(data.firstName)
            .setLastName(data.lastName)
            .setGenderWrapper(data.gender)
            .setUserNumber(data.phoneNumber)
            .sendForm();

        stepsForTestPage.checkResult("Student Name", data.firstName + " " + data.lastName)
            .checkResult("Gender", data.gender)
            .checkResult("Mobile", data.phoneNumber);
    }

    @Test
    @Tag("formFill_Test")
    // Заполнение формы, валидация поля Mobile Number (негативный)
    void MobileMistakeFillFormTest() {
        stepsForTestPage.openPage()
                .removeBanners()
                .setFirstName(data.firstName)
                .setLastName(data.lastName)
                .setGenderWrapper(data.gender)
                .setUserNumber(data.phoneNumberMistake)
                .sendForm()
                .checkResultNegative();
    }
}
