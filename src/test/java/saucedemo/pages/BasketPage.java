package saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class BasketPage {

    public SelenideElement titleBasket = $("[class='header_secondary_container']");
    public SelenideElement productName = $("[class='inventory_item_name']");
    public SelenideElement productPrice = $("[class='inventory_item_price']");
    public SelenideElement buttonCheckout = $("[id='checkout']");

}
