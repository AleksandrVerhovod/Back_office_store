package pages;

import constants.Urls;
import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//a[@href='/login']")
    private WebElement LINK_LOGIN;

    @FindBy(xpath = "//a[@href='/register']")
    private WebElement LINK_REGISTRATION;

    @FindBy(xpath = "//div[contains(@class,'Logo_contentWrapper')]")
    private WebElement LOGO;


    public MainPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", LOGO));
        return LOGO.isDisplayed();
    }
    @Step("Open login page")
    public MainPage openMainPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", Urls.URL_BACK_OFFICE_OPEN));
        driver.get(Urls.URL_BACK_OFFICE_OPEN);
        return this;
    }
    public LoginPage clickLoginLink() {
        LOGGER.debug(String.format("Attempt to click link: %s", LINK_LOGIN));
        LINK_LOGIN.click();
        return new LoginPage(driver);
    }

    public LoginPage clickSignUpLink() {
        LOGGER.debug(String.format("Attempt to click link: %s", LINK_REGISTRATION));
        LINK_REGISTRATION.click();
        return new LoginPage(driver);
    }


}
