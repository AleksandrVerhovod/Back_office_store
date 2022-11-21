package pages;

import constants.Urls;
import io.qameta.allure.Step;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//input[@type='text']")
    private WebElement EMAIL_INPUT;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement PASSWORD_INPUT;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement BUTTON_LOGIN;

    @FindBy(xpath = "//font[text()='Forgot you Password?']/..")
    private WebElement LINK_FORGOT_PASSWORD;

    @FindBy(xpath = "//div[contains(@class,'Login_message')]//p")
    private WebElement ERROR_LOGIN;

    @FindBy(xpath = "//p[contains(text(),'email')]")
    private WebElement ERROR_MAIL;

    @FindBy(xpath = "//p[contains(text(),'password')]")
    private WebElement ERROR_PASSWORD;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", BUTTON_LOGIN));
        return BUTTON_LOGIN.isDisplayed();
    }

    @Step("Open login page")
    public LoginPage openLoginPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", String.format(Urls.URL_BACK_OFFICE_MAIN, Urls.URL_BACK_OFFICE_LOGIN)));
        driver.get(String.format(Urls.URL_BACK_OFFICE_MAIN, Urls.URL_BACK_OFFICE_LOGIN));
        return this;
    }

    @Step("Fill user form by valid random data")
    public LoginPage fillLoginForm(LoginModel loginModel) {
        EMAIL_INPUT.sendKeys(loginModel.getEmail());
        LOGGER.debug(String.format("Input email: %s", loginModel.getEmail()));
        PASSWORD_INPUT.sendKeys(loginModel.getPassword());
        LOGGER.debug(String.format("Input password: %s", loginModel.getPassword()));
        LOGGER.debug(String.format("Attempt to click button: %s", BUTTON_LOGIN));
        BUTTON_LOGIN.click();
        return this;
    }

    @Step("Click button 'Sign Up'")
    public InformationBoardPage clickSignUpButton() {
        LOGGER.debug(String.format("Attempt to click button by locator: %s", BUTTON_LOGIN));
        BUTTON_LOGIN.click();
        return new InformationBoardPage(driver);
    }

    @Step("Check if Error message is displayed")
    public boolean isEmailErrorMessageDisplayed() {
        LOGGER.debug(String.format("Attempt to find message: %s", ERROR_MAIL));
        return ERROR_MAIL.isDisplayed();
    }

    @Step("Get text by error message")
    public boolean isPasswordErrorMessageDisplayed() {
        LOGGER.debug(String.format("Attempt to find message: %s", ERROR_PASSWORD));
        return ERROR_PASSWORD.isDisplayed();
    }

    @Step("Check if Error message is displayed")
    public boolean isLoginErrorMessageDisplayed() {
        LOGGER.debug(String.format("Attempt to find message: %s", ERROR_LOGIN));
        return ERROR_LOGIN.isDisplayed();
    }


}