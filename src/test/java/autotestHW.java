import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
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

        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month").$(byText("15")).click();
        $("#uploadPicture").uploadFromClasspath("Test-Test.jpg");
        $("#hobbiesWrapper").$(byText("Sports")).click();
        $("#currentAddress").setValue("Home");
        $("#state").click();
        $("#state").$(byText("NCR")).click();
        $("#city").click();
        $("#city").$(byText("Delhi")).click();
        $("#submit").click();


    }
}