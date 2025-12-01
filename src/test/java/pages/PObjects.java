package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class PObjects {
    SelenideElement userName = $("#userName");
    SelenideElement userEmail = $("#userEmail");
    SelenideElement currentAddress = $("#currentAddress");
    SelenideElement permanentAddress = $("#permanentAddress");

    public PObjects setUserName(String userNameValue) {
        userName.setValue(userNameValue);

        return this;
    }

    public pages.PObjects setUserEmail(String userEmailValue) {
        userEmail.setValue(userEmailValue);

        return this;
    }

    public PObjects setUserAddress(String userAddresslValue) {
        currentAddress.setValue(userAddresslValue);

        return this;
    }

    public PObjects setUserPAddress(String userPAddresslValue) {
        permanentAddress.setValue(userPAddresslValue);

        return this;
    }

}