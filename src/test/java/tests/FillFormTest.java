package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.util.Locale;

public class FillFormTest extends TestBase {

    Faker faker = new Faker(new Locale("en-US"));

    String firstName = faker.harryPotter().character();
    String secondName = faker.twinPeaks().character();
    String email = faker.internet().emailAddress();
    String number = faker.number().digits(10);
    String streetName = faker.address().streetName();
    String buildingNumber = faker.address().buildingNumber();
    String city = faker.address().city();
    String country = faker.address().country();

    @Test
    void fillFormTest() {

        registrationPage.openPage();
        registrationPage.setFirstNameInput(firstName)
                .setSecondNameNameInput(secondName)
                .setEmailInput(email)
                .setNumberInput(number);

        registrationPage.clickOnMaleButton();

        registrationPage.calendar.setDateOfBirthInput("15", "April", "1996");

        registrationPage.subjectsComponent.enterMathInSubjects();

        registrationPage.clickOnTheSportsCheckbox();

        registrationPage.uploadPicture();

        registrationPage.setAddressInput(streetName + buildingNumber + city + country);

        registrationPage.selectState("NCR");

        registrationPage.selectCity("Delhi");

        registrationPage.clickOnTheSubmitButton();

        registrationPage.checkContentOnSubmittingForm(firstName, secondName, email, "Male"
                , "Maths", "Sports", number, streetName + buildingNumber + city + country, "15 April,1996", "NCR", "Delhi");


    }
}