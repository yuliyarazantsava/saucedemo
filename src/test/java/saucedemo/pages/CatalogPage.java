package saucedemo.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.$;

public class CatalogPage {
    public SelenideElement titleCatalogPage = $("[class='header_secondary_container']");
    public static SelenideElement selectRandomProduct() {
        List<SelenideElement> products = Selenide.$$("[class='inventory_item']");
        if (!products.isEmpty()) {
            int randomIndex = new Random().nextInt(products.size());
            return products.get(randomIndex);
        }
        else {
            throw new RuntimeException("The list is clear");
        }
    }
    public static String getProductName(SelenideElement product) {
        return product.$("[class='inventory_item_name ']").getText();
    }

    public static String getProductPrice(SelenideElement product) {
        return product.$("[class='inventory_item_price']").getText();
    }

    public SelenideElement addToBasket = $("[class='btn btn_primary btn_small btn_inventory ']");
    public SelenideElement buttonBasket = $("[id='shopping_cart_container']");
}
