import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleTest {

    @Test
    void successfulSearchTest() {
        open("http://google.com/");
        $(By.cssSelector("[name=q]")).setValue("selenide").pressEnter();
        $(By.cssSelector("[id=search]")).shouldHave(text("https://selenide.corg/"));
    }
}
