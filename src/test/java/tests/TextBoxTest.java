package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;
import pages.components.CheckTextBox;

public class TextBoxTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();
//    CheckTextBox checkTextBox = new CheckTextBox();

    @Test
    void fillTextBox() {
        textBoxPage.openPage()
                .setUserName("Roman")
                .setUserEmail("roman@email.com")
                .setCurrentAddress("This home")
                .setPermanentAddress("Another home")
                .setSubmit();
        new CheckTextBox().checkResultBox("Name:", "Roman")
                .checkResultBox("Permananet Address :", "Another home");
    }
}
