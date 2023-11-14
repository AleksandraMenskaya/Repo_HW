package pages;

import pages.components.CalendarComponent;

import com.codeborne.selenide.SelenideElement;
import pages.components.TableWithResultComponent;

import java.util.Date;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StepsForTestPage {
    TableWithResultComponent tableComponent = new TableWithResultComponent();
    CalendarComponent calendarComponent = new CalendarComponent();
    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#userEmail"),
            genderWrapper = $("#genterWrapper"),
            userNumberInput = $("#userNumber"),
            calendarInput = $("#dateOfBirthInput"),
            subjectsInput = $("#subjectsInput"),
            hobbiesWrapper = $("#hobbiesWrapper"),
            uploadPictureControl = $("#uploadPicture"),
            currentAddress = $("#currentAddress"),
            stateInput = $("#state"),
            cityInput = $("#city"),
            buttonSendForm = $("#submit"),
            invalidDate = $("#userNumber:invalid");

    public StepsForTestPage openPage() {
        open("/automation-practice-form");
        return this;
    }
    public StepsForTestPage removeBanners() {
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public StepsForTestPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public StepsForTestPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public StepsForTestPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public StepsForTestPage setGenderWrapper(String value) {
        genderWrapper.$(String.format("[value='%s']+label", value)).click();
        return this;
    }
    public StepsForTestPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public StepsForTestPage setDateOfBirth(Date date) {
        calendarInput.click();
        calendarComponent.setDate(date);
        return this;
    }
    public StepsForTestPage selectSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
        return this;
    }
    public StepsForTestPage selectHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public StepsForTestPage uploadPicture(String value) {
        uploadPictureControl.uploadFromClasspath(value);
        return this;
    }
    public StepsForTestPage setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public StepsForTestPage selectState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }
    public StepsForTestPage selectCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }
    public StepsForTestPage sendForm() {
        buttonSendForm.click();
        return this;
    }
    public StepsForTestPage checkResult(String key, String value) {
        tableComponent.checkRow(key, value);
        return this;
    }
    public StepsForTestPage checkResultNegative() {
        invalidDate.exists();
        return this;
    }
}