import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormTest2 {
    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1200x900";
        Configuration.baseUrl = "https://demoqa.com/";
    }

        @Test
        public void letsfilltheform() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#userName").setValue("Vad");
        $("#userEmail").setValue("Testim@gg.ru");
        $("#currentAddress").setValue("Moscow");
        $("#permanentAddress").setValue("Yes,Moscow!");
        $("#submit").click();

        $(".table-responsive").shouldHave(text("Vad"));
        $(".table-responsive").shouldHave(text("Testim@gg.ru"));
        $(".table-responsive").shouldHave(text("Moscow"));
        $(".table-responsive").shouldHave(text("Yes,Moscow!"));

        sleep(5000);
        }
    }
