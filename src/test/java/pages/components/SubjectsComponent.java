package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class SubjectsComponent {

    SelenideElement subjectInput = $("#subjectsInput");

    public void enterMathInSubjects() {
        subjectInput.click();
        subjectInput.setValue("a");
        $(byText("Maths")).click();
    }

}
