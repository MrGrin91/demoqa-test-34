package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class PObjects {
    SelenideElement userName = $("#userName");
    SelenideElement userEmail = $("#userEmail");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement permanentAddress = $("#permanentAddress");
    SelenideElement shouldhaveName = $("#name");
    // SelenideElement shouldhaveEmail = $("#name");
   // SelenideElement shouldhaveAddress = $("#name");
   // SelenideElement shouldhavePAdress = $("#name");

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
        shouldhaveName.setValue(chekNameValue);

        return this;
    }
}

