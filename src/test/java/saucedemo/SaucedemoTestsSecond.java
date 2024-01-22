package saucedemo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import saucedemo.pages.ErrorPage;
import saucedemo.pages.LoginPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

public class SaucedemoTestsSecond {
    private static final Logger logger = LogManager.getLogger(SaucedemoTests.class);

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 15000;
    }

    @Test
    void SaucedemoTestsCell() {

        logger.info("Product search on the website");
        open("https://www.saucedemo.com/");
        LoginPage loginPage = new LoginPage();
        logger.info("Login into the app");
        step("Login into the app", () -> {
            loginPage.userName.setValue(TestData.USER_NAME2);
            loginPage.password.setValue(TestData.PASSWORD);
            loginPage.loginButton.click();
        });

        logger.info("Checking the error message ");
        step("Checking the error message ", () -> {
            ErrorPage errorPage = new ErrorPage();
            errorPage.errorMessage.shouldHave(Condition.text("Epic sadface: Sorry, this user has been locked out."));
        });
    }
}
