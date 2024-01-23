package saucedemo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saucedemo.pages.*;

import java.util.List;
import java.util.Random;

import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static saucedemo.pages.CatalogPage.*;

public class SaucedemoTests extends TestBase {
    private static final Logger logger = LogManager.getLogger(SaucedemoTests.class);

    @Test
    void saucedemoTestsRight() {
        final String[] productName = new String[1];
        final String[] productPrice = new String[1];

        logger.info("Product search on the website");
        open("https://www.saucedemo.com/");

        logger.info("Login into the app");
        step("Login into the app", () -> {
            LoginPage loginPage = new LoginPage();
            loginPage.userName.setValue(TestData.USER_NAME);
            loginPage.password.setValue(TestData.PASSWORD);
            loginPage.loginButton.click();
        });

        logger.info("Select product and add to basket");
        step("Select product and add to basket", () -> {
        CatalogPage catalogPage = new CatalogPage();
        catalogPage.titleCatalogPage.shouldHave(Condition.text("Products"));
        SelenideElement selectedProduct = selectRandomProduct();
        productName[0] = getProductName(selectedProduct);
        productPrice[0] = getProductPrice(selectedProduct);
        catalogPage.addToBasket.click();
        catalogPage.buttonBasket.click();
        });

        logger.info("Check parameters of the added product to the basket");
        step("Check parameters of the added product to the basket", () -> {
        BasketPage basketPage = new BasketPage();
        basketPage.titleBasket.shouldHave(Condition.text("Your Cart"));
        basketPage.productName.shouldHave(Condition.text(productName[0]));
        basketPage.productPrice.shouldHave(Condition.text(productPrice[0]));
        basketPage.buttonCheckout.click();
        });

        logger.info("Filling out personal information for ordering");
        step("Filling out personal information for ordering", () -> {
        OrderPage orderPage = new OrderPage();
        orderPage.titleOrderPage.shouldHave(Condition.text("Checkout: Your Information"));
        orderPage.firstName.setValue(TestData.FIRST_NAME);
        orderPage.lastName.setValue(TestData.LAST_NAME);
        orderPage.postalCode.setValue(TestData.POSTAL_CODE);
        orderPage.buttonContinue.click();
        });

        logger.info("Check parameters of the added product on overview page");
        step("Check parameters of the added product on overview page", () -> {
        OverviewPage overviewPage = new OverviewPage();
        overviewPage.titleOverview.shouldHave(Condition.text("Checkout: Overview"));
        overviewPage.productName.shouldHave(Condition.text(productName[0]));
        overviewPage.productPrice.shouldHave(Condition.text(productPrice[0]));
        overviewPage.buttonFinish.click();
        });

        logger.info("Checking that the order has been successfully completed");
        step("Checking that the order has been successfully completed", () -> {
        FinishPage finishPage = new FinishPage();
        finishPage.titleComplete.shouldHave(Condition.text("Checkout: Complete!"));
        });


    }

}
