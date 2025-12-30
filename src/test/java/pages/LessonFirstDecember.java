package pages;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.github.javafaker.Faker;
import helpers.Attach;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;
import java.util.stream.Stream;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class LessonFirstDecember {

    @BeforeAll
    static void setupConfig() {
        Configuration.pageLoadStrategy = "eager";
        Configuration.browserSize = "1200x900";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.timeout = 30000;
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;

    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo("Last video");
    }

    PObjects mainPage = new PObjects();
    static Faker FakerTest = new Faker();

    @Tag("jenkinstest")
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

        Allure.step("Заполнение дополнительных данных", () -> {
        mainPage.checkName("Vad");
        mainPage.checkEmail(emailAddress);
        mainPage.checkAddress("Moscow");
        mainPage.checkPAddress("Yes,Moscow!");
        });
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
