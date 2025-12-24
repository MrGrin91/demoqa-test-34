package pages;

import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LessonFirstDecember {

    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1200x900";
        Configuration.baseUrl = "https://demoqa.com";
    }

    PObjects mainPage = new PObjects();
    static Faker FakerTest = new Faker();

    @Tag("formtest")
  //  @Disabled
    @DisplayName("Тестируем форму на сайте")
    @MethodSource("emailProvider")
    @ParameterizedTest(name = "Проверка пароля {0} ")
    public void successFillForm(String emailAddress) {
        open("/text-box");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        Allure.step("Заполнение личных данных", () -> {
        mainPage.setUserName("Vad");
        mainPage.setUserEmail(emailAddress);
        mainPage.setUserAddress("Moscow");
        mainPage.setUserPAddress("Yes,Moscow!");
        $("#submit").click();
        });

        mainPage.checkName("Vad");
        //$("#name").shouldHave(text("Vad"));
        $("#email").shouldHave(text(emailAddress));
        $("p#currentAddress").shouldHave(text("Moscow"));
        $("p#permanentAddress").shouldHave(text("Yes,Moscow!"));
    }

    static Stream<Arguments> emailProvider() {
        return Stream.of(
                Arguments.of(generateEmail()),
                Arguments.of("Vadim@yahoo.com"),
                Arguments.of("Vadim@mail.ru")
        );
    }

    static public String generateEmail() {
        return FakerTest.internet().emailAddress();
    }

}
