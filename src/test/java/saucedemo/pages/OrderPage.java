package saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import saucedemo.TestData;

import static com.codeborne.selenide.Selenide.$;

public class OrderPage {
    public SelenideElement titleOrderPage = $("[class='header_secondary_container']");
    public SelenideElement firstName = $("[id='first-name']");
    public SelenideElement lastName = $("[id='last-name']");
    public SelenideElement postalCode = $("[id='postal-code']");
    public SelenideElement buttonContinue = $("[id='continue']");


}
