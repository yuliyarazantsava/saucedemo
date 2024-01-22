package saucedemo.pages;

import com.codeborne.selenide.SelenideElement;
import saucedemo.TestData;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    public SelenideElement userName = $("[placeholder='Username']");
    public SelenideElement password = $("[placeholder='Password']");
    public SelenideElement loginButton = $("[id='login-button']");

}
