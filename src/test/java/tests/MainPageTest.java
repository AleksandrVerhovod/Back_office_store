package tests;

import io.qameta.allure.Feature;
import jdk.jfr.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;

@Feature("Main Page")
public class MainPageTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test
    @Description("Open Log In page")
    public void clickLoginTest() {
        MainPage mainPage = new MainPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        mainPage.openMainPage()
                .clickLoginLink();
        LOGGER.info("Check if page is displayed");
        Assert.assertTrue(loginPage.isPageOpened());
    }

    @Test
    @Description("Open Sign Up page")
    public void clickSignUpTest() {
        MainPage mainPage = new MainPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", MainPage.class.getName()));
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        mainPage.openMainPage()
                .clickSignUpLink();
        LOGGER.info("Check if page is displayed");
        Assert.assertTrue(loginPage.isPageOpened());
    }
}
