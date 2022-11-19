package tests;

import org.testng.Assert;
import pages.InformationBoardPage;
import testdata.dataprovider.DataProviderRegistrationClass;
import jdk.jfr.Description;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import testdata.PrepareRegistrationData;

public class RegistrationTest extends BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(RegistrationTest.class.getName());

    @Test(dataProvider = "validEmailForSignInProvider", dataProviderClass = DataProviderRegistrationClass.class)
    @Description("Create users with constant email and password, valid data in all fields")
    public void createUsersForSignInTest(String data []) {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationModel(data[0], data[1]);
        registrationPage.openRegistrationPage()
                .fillRegistrationsFields(registrationModel)
                .clickSignUpButton();
        InformationBoardPage informationBoardPage = new InformationBoardPage(getDriver());
        Assert.assertTrue(informationBoardPage.isPageOpened(), "User not created");
    }

    @Test(dataProvider = "validRandomEmailPasswordProvider", dataProviderClass = DataProviderRegistrationClass.class)
    @Description("Create users with random valid data")
    public void createUsersWithRandomDataTest(String data []) {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationModel(data[0], data[1]);
        registrationPage.openRegistrationPage()
                .fillRegistrationsFields(registrationModel)
                .clickSignUpButton();
        InformationBoardPage informationBoardPage = new InformationBoardPage(getDriver());
        Assert.assertTrue(informationBoardPage.isPageOpened(), "User not created");
    }



    @Test(dataProvider = "notValidEmailProvider", dataProviderClass = DataProviderRegistrationClass.class)
    @Description("The user login with not valid email and valid other fields")
    public void notValidEmailRegistrationTest(String data[]) {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNegativeEmailModel(data[0]);
        registrationPage.openRegistrationPage()
                .fillRegistrationsFields(registrationModel)
                .clickSignUpButton();
        Assert.assertTrue(registrationPage.isErrorEmailMessageIsDisplayed(), "Error message isn't displayed");
    }


    @Test(dataProvider = "notValidPasswordProvider", dataProviderClass = DataProviderRegistrationClass.class)
    @Description("The user login with not valid password and valid other fields")
    public void notValidPasswordRegistrationTest(String data[]) {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNegativePasswordModel(data[0]);
        registrationPage.openRegistrationPage()
                .fillRegistrationsFields(registrationModel)
                .clickSignUpButton();
        Assert.assertTrue(registrationPage.isErrorPasswordMessageIsDisplayed(), "Error message isn't displayed");
    }

    @Test(dataProvider = "notValidFullNameProvider", dataProviderClass = DataProviderRegistrationClass.class)
    @Description("The user login with not valid full name and valid other fields")
    public void notValidFullNameRegistrationTest(String data[]) {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNegativeFullNameModel(data[0]);
        registrationPage.openRegistrationPage()
                .fillRegistrationsFields(registrationModel)
                .clickSignUpButton();
        Assert.assertTrue(registrationPage.isErrorFullNameMessageIsDisplayed(), "Error message isn't displayed");
    }

    @Test(dataProvider = "notValidConfirmPasswordProvider", dataProviderClass = DataProviderRegistrationClass.class)
    @Description("The user login with not valid confirm password and valid other fields")
    public void notValidConfirmPasswordRegistrationTest(String data[]) {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNotValidConfirmPasswordModel(data[0]);
        registrationPage.openRegistrationPage()
                .fillRegistrationsFields(registrationModel)
                .clickSignUpButton();
        Assert.assertTrue(registrationPage.isErrorConfirmPasswordMessageIsDisplayed(), "Error message isn't displayed");
    }

    @Test(dataProvider = "notValidSuperCodeProvider", dataProviderClass = DataProviderRegistrationClass.class)
    @Description("The user login with not valid Super Code and valid other fields")
    public void notValidSuperCodeRegistrationTest(String data[]) {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        RegistrationModel registrationModel = PrepareRegistrationData.fillRegistrationWithNotValidSuperCodeModel(data[0]);
        registrationPage.openRegistrationPage()
                .fillRegistrationsFields(registrationModel)
                .clickSignUpButton();
        Assert.assertTrue(registrationPage.isErrorSuperCodeIsDisplayed(), "Error message isn't displayed");
    }

}
