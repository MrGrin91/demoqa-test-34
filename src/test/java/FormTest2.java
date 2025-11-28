// Класс -
// Объект -
// Метод -
// Переменная -
// @ - аннотации

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PObjects;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class FormTest2 {
    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1200x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    PObjects mainPage = new PObjects();

    Faker FakerTest = new Faker();
@Tag("formtest")
@DisplayName("Тестируем форму на сайте")
@ValueSource(strings = {
        "Vad", "Dim", "Mash"
})
@ParameterizedTest(name = "Проверка пароля {0} ")
    @Test
    public void letsfilltheform() {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        String randomEmailtest = FakerTest.internet().emailAddress();
        mainPage.setUserName("Vad");
      //  pObjects01.setUserEmail("Testim@gg.ru");
        mainPage.setUserEmail(randomEmailtest);
        mainPage.setUserAddress("Moscow");
        mainPage.setUserPAddress("Yes,Moscow!");
        $("#submit").click();

        $("#name").shouldHave(text("Vad"));
        $("#email").shouldHave(text(randomEmailtest));
        $("p#currentAddress").shouldHave(text("Moscow"));
        $("p#permanentAddress").shouldHave(text("Yes,Moscow!"));


        sleep(5000);
    }
}
