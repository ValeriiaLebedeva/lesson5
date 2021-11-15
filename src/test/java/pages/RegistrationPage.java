package pages;

import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.SubjectsComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    //selectors

    SelenideElement firstNameInput = $("[id=firstName]");
    SelenideElement secondNameInput = $("[id=lastName]");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement numberInput = $("[id=userNumber]");
    SelenideElement genderButtons = $("#genterWrapper");
    SelenideElement hobbiesButtons = $("#hobbiesWrapper");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement uploadPictureButton = $("#uploadPicture");
    SelenideElement submitButton = $("#submit");
    SelenideElement stateDropDownMenu = $("[id=state]");
    SelenideElement cityDropDownMenu = $("[id=city]");
    SelenideElement submittingForm = $(byClassName("modal-content"));
    //actions

    public void openPage() {
        open("https://demoqa.com/automation-practice-form");
    }

    public RegistrationPage setFirstNameInput (String value) {
        firstNameInput.setValue(value);
        return this;

    }

    public RegistrationPage setSecondNameInputNameInput (String value) {
        secondNameInput.setValue(value);
        return this;
    }

    public RegistrationPage setEmailInputInput (String value) {
        emailInput.setValue(value);
        return this;
    }

    public CalendarComponent calendar = new CalendarComponent();

    public SubjectsComponent subjectsComponent = new SubjectsComponent();

    public RegistrationPage setNumberInput (String value) {
        numberInput.setValue(value);
        return this;
    }

    public void clickOnMaleButton(){
        genderButtons.$(byText("Male")).click();
    }

    public void clickOnTheSportsCheckbox() {
        hobbiesButtons.$(byText("Sports")).click();
    }

    public RegistrationPage setAddressInput(String value) {
        addressInput.setValue(value);
        return this;
    }

    public void uploadPicture() {
        uploadPictureButton.uploadFile(new File("src/test/resources/img/1.png"));
        uploadPictureButton.uploadFromClasspath("img/1.png");
    }

    public void selectState(String value) {
        stateDropDownMenu.scrollTo().click();
        $(byText(value)).click();
    }

    public void selectCity(String value) {
        cityDropDownMenu.click();
        $(byText(value)).click();

    }

    public void clickOnTheSubmitButton() {
        submitButton.click();
    }

    public void checkContentOnSubmittingForm (String name, String surname, String email, String gender, String subject,
                                             String hobbies, String number, String address, String date, String state,
                                             String city) {
        submittingForm.shouldBe(visible);
        submittingForm.shouldHave(text(name));
        submittingForm.shouldHave(text(surname));
        submittingForm.shouldHave(text(email));
        submittingForm.shouldHave(text(gender));
        submittingForm.shouldHave(text(subject));
        submittingForm.shouldHave(text(hobbies));
        submittingForm.shouldHave(text(number));
        submittingForm.shouldHave(text(address));
        submittingForm.shouldHave(text(date));
        submittingForm.shouldHave(text(state));
        submittingForm.shouldHave(text(city));

    }


}
