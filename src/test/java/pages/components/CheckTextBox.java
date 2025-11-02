package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CheckTextBox {
    public CheckTextBox checkResultBox(String key, String value) {
        $("#output").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;
    }
}
