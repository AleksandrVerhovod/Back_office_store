package tests;

import io.qameta.allure.Feature;
import jdk.jfr.Description;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.InformationBoardPage;
import pages.services.LoginSite;

@Feature("Information board page")
public class InformationBoardTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(InformationBoardTest.class.getName());

    @Test
    @Description("Test sidebar view")
    public void burgerButtonTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
        loginSite.loginForConfirm();
        InformationBoardPage informationBoardPage = new InformationBoardPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", InformationBoardPage.class.getName()));
        informationBoardPage.clickButtonBurger();
        Assert.assertTrue(informationBoardPage.textOfButtonsSidebarNoDisplayed(), "Text near buttons in sidebar is displayed");
    }

    @Test
    @Description("Header User info panel")
    public void headerUserInfoTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
        loginSite.loginForConfirm();
        InformationBoardPage informationBoardPage = new InformationBoardPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", InformationBoardPage.class.getName()));
        informationBoardPage.clickArrayButtonUserInfo();
        Assert.assertTrue(informationBoardPage.buttonLogOutIsDisplayed(), "Button 'Log Out' no displayed");
    }
}
