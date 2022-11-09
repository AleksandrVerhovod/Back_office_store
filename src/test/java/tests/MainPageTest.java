package tests;

import jdk.jfr.Description;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.MainPage;
import testdata.PrepareLoginData;

public class MainPageTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test
    @Description("The user login with empty password and email fields")
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
}
