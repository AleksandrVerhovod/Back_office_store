package pages;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InformationBoardPage extends BasePage {

    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());
    @FindBy(xpath = "//div[contains(@class, 'Header_userInfo')]//label")
    private WebElement ACCOUNT_NAME;


    public InformationBoardPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return ACCOUNT_NAME.isDisplayed();
    }
}
