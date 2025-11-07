package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckTextBox {
    private static final SelenideElement outputBox = $("#output");

    public CheckTextBox checkResultBox(String key, String value) {
        outputBox.$(byText(key))
                .parent()
                .shouldHave(text(value));
        return this;
    }
}