package pages.components;

import com.codeborne.selenide.SelenideElement;
import pages.RegistrationPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckForm {

    private final SelenideElement resultTable = $(".table-responsive");

    public CheckForm checkResult(String key, String value) {
        resultTable.$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }
}
