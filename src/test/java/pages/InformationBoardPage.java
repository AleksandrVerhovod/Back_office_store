package pages;

import io.qameta.allure.Step;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationBoardPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());
    @FindBy(xpath = "//div[contains(@class, 'Header_userInfo')]//label")
    private WebElement ACCOUNT_NAME;

    @FindBy(xpath = "//span[text()='Products']")
    private WebElement BUTTON_PRODUCTS;

    @FindBy(xpath = "//nav[contains(@class, 'Sidebar_menu')]//button")
    private WebElement BUTTON_BURGER;

    @FindBy(xpath = "//span[text()='Products']/ancestor::div[contains(@class, 'Link_collapsed_')]")
    private WebElement LINK_PRODUCTS;

    @FindBy(xpath = "//span[text()='Categories']/ancestor::div[contains(@class, 'Link_collapsed_')]")
    private WebElement LOGO_CATEGORIES_WITHOUT_TEXT;

    @FindBy(xpath = "//img[contains(@class,'Header_arrow')]")
    private WebElement BUTTON_USER_INFO;

    @FindBy(xpath = "//button[text()='Log Out']")
    private WebElement BUTTON_LOGOUT_USER;

    public InformationBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return ACCOUNT_NAME.isDisplayed();
    }

    @Step("Click button 'Products'")
    public ProductsPage clickButtonProducts() {
        LOGGER.debug(String.format("Click button by locator: %s", BUTTON_PRODUCTS));
        BUTTON_PRODUCTS.click();
        return new ProductsPage(driver);
    }

    @Step("Click button 'Burger'")
    public InformationBoardPage clickButtonBurger() {
        LOGGER.debug(String.format("Click button by locator: %s", BUTTON_BURGER));
        BUTTON_BURGER.click();
        return this;
    }

    @Step("Check that sidebar change the view")
    public boolean textOfButtonsSidebarNoDisplayed() {
        LOGGER.debug(String.format("Click button by locator: %s", LOGO_CATEGORIES_WITHOUT_TEXT));
        return LOGO_CATEGORIES_WITHOUT_TEXT.isDisplayed();
    }

    @Step("Click button 'Array' of the user info")
    public InformationBoardPage clickArrayButtonUserInfo() {
        LOGGER.debug(String.format("Click button by locator: %s", BUTTON_USER_INFO));
        BUTTON_USER_INFO.click();
        return this;
    }

    @Step("Check that sidebar change the view")
    public boolean buttonLogOutIsDisplayed() {
        LOGGER.debug(String.format("Click button by locator: %s", BUTTON_LOGOUT_USER));
        return BUTTON_LOGOUT_USER.isDisplayed();
    }

}
