package pages.components;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CalendarComponent {

    private SelenideElement dateOfBirthInput = $("#dateOfBirthInput");

    public void setDateOfBirthInput(String day, String month, String year) {
        dateOfBirthInput.click();
        $(byClassName("react-datepicker__month-select")).click();
        $(byText(month)).click();
        $(byClassName("react-datepicker__year-select")).selectOptionByValue(year);
        $$(".react-datepicker__day").find(Condition.text(day)).click();
    }

}
