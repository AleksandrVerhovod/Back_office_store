package tests;

import jdk.jfr.Description;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import testdata.PrepareLoginData;


public class LoginTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());

    @Test
    @Description("The user login with empty password and email fields")
    public void loginWithEmptyFields() {
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginModel loginModel = PrepareLoginData.getLoginWithEmptyFieldsLogin();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .sendLoginForm(loginModel);
        LOGGER.info("Check if message is displayed");
        Assert.assertTrue(loginPage.isEmailErrorMessageDisplayed());
        Assert.assertTrue(loginPage.isPasswordErrorMessageDisplayed());
    }
}
