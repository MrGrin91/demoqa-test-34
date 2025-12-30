package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class PObjects {
    SelenideElement userName = $("#userName");
    SelenideElement userEmail = $("#userEmail");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement permanentAddress = $("#permanentAddress");
    SelenideElement shouldhaveName = $("#name");
    SelenideElement shouldhaveEmail = $("#email");
    SelenideElement shouldhaveAddress = $("p#currentAddress");
    SelenideElement shouldhavePAddress = $("p#permanentAddress");

    @Step("Установка значения имени")
    public PObjects setUserName(String userNameValue) {
        userName.setValue(userNameValue);

        return this;
    }
    @Step("Установка значения имейла")
    public pages.PObjects setUserEmail(String userEmailValue) {
        userEmail.setValue(userEmailValue);

        return this;
    }
    @Step("Установка значения адреса")
    public PObjects setUserAddress(String userAddresslValue) {
        currentAddress.setValue(userAddresslValue);

        return this;
    }
    @Step("Установка значения точного адреса")
    public PObjects setUserPAddress(String userPAddresslValue) {
        permanentAddress.setValue(userPAddresslValue);

        return this;
    }
    @Step("Проверка имени")
    public PObjects checkName(String chekNameValue) {
        shouldhaveName.shouldHave(text(chekNameValue));

        return this;
    }
    @Step("Проверка имейла")
    public PObjects checkEmail(String chekEmailValue) {
        shouldhaveEmail.shouldHave(text(chekEmailValue));

        return this;
    }
    @Step("Проверка адреса")
    public PObjects checkAddress(String chekAddressValue) {
        shouldhaveAddress.shouldHave(text(chekAddressValue));

        return this;
    }
    @Step("Проверка п. адреса")
    public PObjects checkPAddress(String chekPAddressValue) {
        shouldhavePAddress.shouldHave(text(chekPAddressValue));

        return this;
    }
}

