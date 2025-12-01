// Класс -
// Объект -
// Метод -
// Переменная -
// @ - аннотации
//@ParameterizedTest - означает разные исходные данные и тест будет запущен несколько раз

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.PObjects;

import java.util.List;
import java.util.stream.Stream;

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
@MethodSource("methodSourceExampleTest")

    @ParameterizedTest
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
    static Stream<Arguments> methodSourceExampleTest() {
        Faker FakerTest = new Faker();
        return Stream.of(
                // с первым запуском тест получит в виде аргументов строки и список
                Arguments.of("Vadim"),
                // со вторым запуском уже другую строку и список
                Arguments.of(FakerTest.internet().emailAddress())
        );
    }
}