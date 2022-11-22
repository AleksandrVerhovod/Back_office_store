package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import jdk.jfr.Description;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InformationBoardPage;
import pages.LoginPage;
import testdata.PrepareLoginData;
import testdata.dataprovider.DataProviderLoginClass;

@Feature("Authorization")
public class LoginTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(LoginTest.class.getName());
    @Test(dataProvider = "validEmailAndPasswordForLoginProvider", dataProviderClass = DataProviderLoginClass.class)
    @Description("Login users with valid email and password")
    @Step("Login user to application by {data[]}")
    public void loginByValidUsersTest(String data[]) {
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        LoginModel loginModel = PrepareLoginData.getValidDataForLogin(data[0], data[1]);
        LOGGER.info(String.format("Fill email and password fields", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .fillLoginForm(loginModel)
                .clickSignUpButton();
        InformationBoardPage informationBoardPage = new InformationBoardPage(getDriver());
        LOGGER.info(String.format("Initialization %s page", InformationBoardPage.class.getName()));
        LOGGER.info("Check if account is created");
        Assert.assertTrue(informationBoardPage.isPageOpened(), "User not log in");
    }

    @Test(dataProvider = "notValidEmailForLoginDataProvider", dataProviderClass = DataProviderLoginClass.class)
    @Description("Login users with not valid email and valid password")
    @Step("Login user to application by {data[]}")
    public void loginByNotValidEmailTest(String data[]) {
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        LoginModel loginModel = PrepareLoginData.getNotValidEmailLogin(data[0]);
        LOGGER.info(String.format("Fill email and password fields", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .fillLoginForm(loginModel)
                .clickSignUpButton();
        LOGGER.info("Check if message is displayed");
        Assert.assertTrue(loginPage.isEmailErrorMessageDisplayed());
    }


    @Test(dataProvider = "notValidPasswordForLoginDataProvider", dataProviderClass = DataProviderLoginClass.class)
    @Description("Login users with not valid password and valid email")
    @Step("Login user to application by {data[]}")
    public void loginByNotValidPasswordTest(String data[]) {
        LOGGER.info(String.format("Page %s initialized", LoginPage.class.getName()));
        LoginPage loginPage = new LoginPage(getDriver());
        LOGGER.info(String.format("Open %s page", LoginPage.class.getName()));
        LOGGER.info(String.format("Prepared valid data by %s", PrepareLoginData.class.getName()));
        LoginModel loginModel = PrepareLoginData.getNotValidPasswordLogin(data[0]);
        LOGGER.info(String.format("Fill email and password fields", PrepareLoginData.class.getName()));
        loginPage.openLoginPage()
                .fillLoginForm(loginModel)
                .clickSignUpButton();
        LOGGER.info("Check if message is displayed");
        Assert.assertTrue(loginPage.isPasswordErrorMessageDisplayed());
    }


}
