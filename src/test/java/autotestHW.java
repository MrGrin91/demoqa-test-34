import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class autotestHW {
    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1200x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    public void fillFormAutoTest() {

        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("#firstName").setValue("Vadim");
        $("#lastName").setValue("Ruch");
        $("#userEmail").setValue("test@ya.ru");
        $("#genterWrapper").$(byText("Male")).click();
        $("#userNumber").setValue("89001234567");
        $("#dateOfBirthInput").click();

    }
}