import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Selenide2HW {
    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1200x900";
        Configuration.baseUrl = "https://github.com/";
    }

    @Test
    void formTest() {
        open("https://github.com");
        $(".HeaderMenu-nav").find(byText("Solutions")).hover();
        $$(".HeaderMenu-dropdown-link").findBy(text("Enterprises")).click();
        $("#hero-section-brand-heading").shouldHave(text("The AI-powered developer platform"));

        sleep(5000);
    }
}