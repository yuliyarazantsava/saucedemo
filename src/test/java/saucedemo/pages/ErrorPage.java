package saucedemo.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ErrorPage {
    public SelenideElement errorMessage = $("[class='error-message-container error']");
}
