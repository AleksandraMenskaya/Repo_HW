package test;

import pages.StepsForTest;

import org.junit.jupiter.api.Test;
import static com.codeborne.selenide.Selenide.*;

public class FillFormTest extends TestBase {
    StepsForTest stepsForTest = new StepsForTest();
    private String FIRST_NAME = "Aleksandra",
            LAST_NAME = "Menskaia",
            EMAIL = "almenskaya@gmail.com",
            GENDER = "Female",
            MOBILE = "1234567890",
            MOBILE_MISTAKE = "123456789",
            DAY_BIRTH = "02",
            MONTH_BIRTH = "August",
            YEAR_BIRTH = "1988",
            SUBJECTS = "History",
            HOBBIES_1 = "Music",
            HOBBIES_2 = "Reading",
            IMAGE = "imagesForTest.jfif",
            CURRENT_ADDRESS = "street St,12",
            STATE = "NCR",
            CITY = "Gurgaon";

    @Test
        // Заполнение формы, все поля
    void successfulFillFormTest() {

        stepsForTest.openPage()
            .setFirstName(FIRST_NAME)
            .setLastName(LAST_NAME)
            .setUserEmail(EMAIL)
            .setGenderWrapper(GENDER)
            .setUserNumber(MOBILE)
            .setDateOfBirth(DAY_BIRTH, MONTH_BIRTH, YEAR_BIRTH)
            .selectSubjects(SUBJECTS)
            .selectHobbies(HOBBIES_1)
            .selectHobbies(HOBBIES_2)
            .uploadPicture(IMAGE)
            .setCurrentAddress(CURRENT_ADDRESS)
            .selectState(STATE)
            .selectCity(CITY)
            .sendForm();

        stepsForTest.checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
            .checkResult("Student Email", EMAIL)
            .checkResult("Gender", GENDER)
            .checkResult("Mobile", MOBILE)
            .checkResult("Date of Birth", DAY_BIRTH +" " + MONTH_BIRTH + "," + YEAR_BIRTH)
            .checkResult("Subjects", SUBJECTS)
            .checkResult("Hobbies", HOBBIES_1 + ", " + HOBBIES_2)
            .checkResult("Picture", IMAGE)
            .checkResult("Address", CURRENT_ADDRESS)
            .checkResult("State and City", STATE + " " + CITY);
    }

    @Test
        // Заполнение формы, обязательные поля
    void successfulMinimumDataFillFormTest() {

        stepsForTest.openPage()
            .setFirstName(FIRST_NAME)
            .setLastName(LAST_NAME)
            .setGenderWrapper(GENDER)
            .setUserNumber(MOBILE)
            .sendForm();

        stepsForTest.checkResult("Student Name", FIRST_NAME + " " + LAST_NAME)
            .checkResult("Gender", GENDER)
            .checkResult("Mobile", MOBILE);
    }

    @Test
    // Заполнение формы, недостаточная длина номера телефона (негативный)
    void MobileMistakeFillFormTest() {
        stepsForTest.openPage()
                .setFirstName(FIRST_NAME)
                .setLastName(LAST_NAME)
                .setGenderWrapper(GENDER)
                .setUserNumber(MOBILE_MISTAKE)
                .sendForm();

        $("#userNumber:invalid").exists();
    }
}
