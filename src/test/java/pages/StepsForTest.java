package pages;

import pages.components.CalendarComponent;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class StepsForTest {
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
            buttonSendForm = $("#submit");

    public StepsForTest openPage() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        return this;
    }
    public StepsForTest setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }
    public StepsForTest setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }
    public StepsForTest setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    public StepsForTest setGenderWrapper(String value) {
        genderWrapper.$(String.format("[value='%s']+label", value)).click();
        return this;
    }
    public StepsForTest setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    public StepsForTest setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        CalendarComponent.setDate(day, month, year);
        return this;
    }
    public StepsForTest selectSubjects(String value) {
        subjectsInput.setValue(value);
        subjectsInput.pressEnter();
        return this;
    }
    public StepsForTest selectHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public StepsForTest uploadPicture(String value) {
        uploadPictureControl.uploadFromClasspath(value);
        return this;
    }
    public StepsForTest setCurrentAddress(String value) {
        currentAddress.setValue(value);
        return this;
    }
    public StepsForTest selectState(String value) {
        stateInput.click();
        stateInput.$(byText(value)).click();
        return this;
    }
    public StepsForTest selectCity(String value) {
        cityInput.click();
        cityInput.$(byText(value)).click();
        return this;
    }
    public StepsForTest sendForm() {
        buttonSendForm.click();
        return this;
    }
    public StepsForTest checkResult(String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}