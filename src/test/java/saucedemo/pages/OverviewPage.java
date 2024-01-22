package saucedemo.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class OverviewPage {

    public SelenideElement titleOverview = $("[class='header_secondary_container']");
    public SelenideElement productName = $("[class='inventory_item_name']");
    public SelenideElement productPrice = $("[class='inventory_item_price']");
    public SelenideElement buttonFinish = $("[id='finish']");
}
