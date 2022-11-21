package pages.services;

import io.qameta.allure.Step;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import testdata.PrepareLoginData;

public class LoginSite {

    private static final Logger LOGGER = LogManager.getLogger(LoginSite.class.getName());
    private final WebDriver driver;

    public LoginSite(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Login by confirm test user")
    public void loginForConfirm() {
        LoginPage loginPage = new LoginPage(driver);
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginModel loginModel = PrepareLoginData.getValidLogin();
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .fillLoginForm(loginModel);
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
    }

}