package pages;

import constants.Urls;
import io.qameta.allure.Step;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//input[@placeholder='Set the email address as the login name']")
    private WebElement EMAIL_FIELD;

    @FindBy(xpath = "//input[@placeholder='Enter the password']")
    private WebElement PASSWORD_FIELD;

    @FindBy(xpath = "//input[@placeholder='Enter the password again']")
    private WebElement CONFIRM_PASSWORD_FIELD;

    @FindBy(xpath = "//input[@placeholder='Enter first and last name']")
    private WebElement FULL_NAME_FIELD;

    @FindBy(xpath = "//input[@placeholder='Enter the Super Code']")
    private WebElement SUPER_CODE_FIELD;

    @FindBy(xpath = "//button[@type='button']")
    private WebElement SIGNUP_BUTTON;

    @FindBy(xpath = "//label[text()='Email Address']//..//p")
    private WebElement ERROR_EMAIL_MESSAGE;

    @FindBy(xpath = "//label[text()='Login Password']//..//p")
    private WebElement ERROR_PASSWORD_MESSAGE;

    @FindBy(xpath = "//label[text()='Full name']//..//p")
    private WebElement ERROR_FULLNAME_MESSAGE;

    @FindBy(xpath = "//label[text()='Confirm Password']//..//p")
    private WebElement ERROR_CONFIRM_PASSWORD_MESSAGE;

    @FindBy(xpath = "//p[contains(text(),'Your Super Code is incorrect')]")
    private WebElement ERROR_SUPER_CODE_MESSAGE;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", SIGNUP_BUTTON));
        return SIGNUP_BUTTON.isDisplayed();
    }

    @Step("Open registration page")
    public RegistrationPage openRegistrationPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", String.format(Urls.URL_BACK_OFFICE_MAIN, Urls.URL_BACK_OFFICE_REGISTER)));
        driver.get(String.format(Urls.URL_BACK_OFFICE_MAIN, Urls.URL_BACK_OFFICE_REGISTER));
        return this;
    }

    @Step("Fill registration form with not valid email")
    public RegistrationPage fillRegistrationsFields(RegistrationModel regModel) {
        EMAIL_FIELD.sendKeys(regModel.getEmail());
        PASSWORD_FIELD.sendKeys(regModel.getPassword());
        CONFIRM_PASSWORD_FIELD.sendKeys(regModel.getConfirmPassword());
        FULL_NAME_FIELD.sendKeys(regModel.getFullName());
        SUPER_CODE_FIELD.sendKeys(regModel.getSuperCode());
        return this;
    }

    @Step("Click button 'Sign Up'")
    public InformationBoardPage clickSignUpButton() {
        SIGNUP_BUTTON.click();
        return new InformationBoardPage(driver);
    }

    public boolean isErrorEmailMessageIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find button: %s", ERROR_EMAIL_MESSAGE));
        return ERROR_EMAIL_MESSAGE.isDisplayed();
    }


    public boolean isErrorPasswordMessageIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find button: %s", ERROR_PASSWORD_MESSAGE));
        return ERROR_PASSWORD_MESSAGE.isDisplayed();


    }

    public boolean isErrorConfirmPasswordMessageIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find button: %s", ERROR_CONFIRM_PASSWORD_MESSAGE));
        return ERROR_CONFIRM_PASSWORD_MESSAGE.isDisplayed();
    }

    public boolean isErrorFullNameMessageIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find button: %s", ERROR_FULLNAME_MESSAGE));
        return ERROR_FULLNAME_MESSAGE.isDisplayed();
    }

    public boolean isErrorSuperCodeIsDisplayed() {
        LOGGER.debug(String.format("Attempt to find button: %s", ERROR_SUPER_CODE_MESSAGE));
        return ERROR_SUPER_CODE_MESSAGE.isDisplayed();
    }
}