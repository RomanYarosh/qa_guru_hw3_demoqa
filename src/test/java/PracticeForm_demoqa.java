import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticeForm_demoqa {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }
    
    @Test
    void fillFormTest() {
        open("/automation-practice-form");

        $("#firstName").setValue("Roman");
        $("#lastName").setValue("Yar");
        $("#userEmail").setValue("roman@email.com");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("0123456789");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption("June");
        $(".react-datepicker__year-select").selectOption("1993");
        $(".react-datepicker__day--001").click();
        $("#subjectsInput").setValue("Comp").pressEnter();
        $("#subjectsInput").setValue("En").pressEnter();
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#hobbiesWrapper").$(byText("Music")).click();

        $("#submit").scrollTo();

        $("#uploadPicture").uploadFromClasspath("images.png");
        $("#currentAddress").setValue("My home");
        $("#state").click();
        $("#stateCity-wrapper").$(byText("Haryana")).click();
        $("#city").click();
        $("#stateCity-wrapper").$(byText("Panipat")).click();

        $("#submit").click();

        $(".table-responsive").shouldHave(
                text("Roman Yar"),
                text("roman@email.com"),
                text("Male"),
                text("0123456789"),
                text("01 June,1993"),
                text("Computer Science, English"),
                text("Sports, Music"),
                text("images.jpg"),
                text("My home"),
                text("Haryana Panipat")
        );

    }
}
