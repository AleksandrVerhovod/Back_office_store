package testdata.dataprovider;

import constants.Credentials;
import org.testng.annotations.DataProvider;
import utils.GenerateTestData;

public class DataProviderRegistrationClass {

    @DataProvider(name = "validEmailForSignInProvider")
    public static Object[][] dataConstantaProviderValidEmail() {
        return new Object[][]{
                {Credentials.VALID_CONST_EMAIL, Credentials.VALID_PASSWORD},
                {Credentials.MIN_VALID_EMAIL, Credentials.MIN_VALID_PASSWORD},
                {Credentials.MINplus1_VALID_EMAIL, Credentials.MINplus1_VALID_PASSWORD},
                {Credentials.MAX_VALID_EMAIL, Credentials.MAX_VALID_PASSWORD},
                {Credentials.MAXminus1_VALID_EMAIL, Credentials.MAXminus1_VALID_PASSWORD},
                {Credentials.UPPERCASE_VALID_EMAIL, Credentials.VALID_PASSWORD},
                {Credentials.WITH_SPACES_VALID_EMAIL, Credentials.WITH_SPACES_VALID_PASSWORD},
                {Credentials.CYRILLIC_VALID_EMAIL, Credentials.VALID_PASSWORD},
        };
    }

    @DataProvider(name = "validRandomEmailPasswordProvider")
    public static Object[][] dataRandomValidProviderData() {
        return new Object[][]{
                {GenerateTestData.generateEmail(), GenerateTestData.generatePassword()},
                {GenerateTestData.generateMinEmail(), GenerateTestData.generateMinPassword()},
                {GenerateTestData.generateMinPlus1Email(), GenerateTestData.generateMinPlus1Password()},
                {GenerateTestData.generateMaxEmail(), GenerateTestData.generateMaxPassword()},
                {GenerateTestData.generateMaxMinus1Email(), GenerateTestData.generateMaxMinus1Password()},
                {GenerateTestData.generateUPPERCaseEmail(), GenerateTestData.generatePassword()},
                {GenerateTestData.generateWithSpacesEmail(), GenerateTestData.generatePassword()},
        };
    }

    @DataProvider(name = "notValidEmailProvider")
    public static Object[][] dataNoValidProviderEmail() {
        return new Object[][]{
                {".testemail@mail.com"},
                {"tesmail.com"},
                {"testemail@mailcom"},
                {"testemail@"},
                {"@mail.com"},
                {"test0test0test0test0test0test0test0test0test0test01@mail.com"},
                {"te@mail.com"},
                {"           "},
                {"<script>alert(123)</script>"},
                {"<script>alert(«Hello, world!»)</alert>"},
                {"DROP TABLE user;"},
                {"«»‘~!@#$%^&*()?>,./<][ /*<!—«», «${code}»;—>"},
                {"%%%/%%%"},
                {""},
        };
    }

    @DataProvider(name = "notValidPasswordProvider")
    public static Object[][] notValidPasswordDataProvider() {
        return new Object[][]{
                {Credentials.VALID_CONST_EMAIL},
                {GenerateTestData.generateMax1Password()},
                {GenerateTestData.generateMin1Password()},
                {GenerateTestData.generateLowerCasePassword()},
                {GenerateTestData.generateUpperCasePassword()},
                {GenerateTestData.generateWithoutSpecCharPassword()},
                {GenerateTestData.generateWithoutNumberPassword()},
                {GenerateTestData.generateWithCyrillicPassword()},
                {"<script>alert(123)</script>"},
                {"          "},
                {""},
        };
    }

    @DataProvider(name = "notValidFullNameProvider")
    public static Object[][] notValidFullNameDataProvider() {
        return new Object[][]{
                {GenerateTestData.generateMinMinus1FullName()},
                {GenerateTestData.generateMaxPlus1FullName()},
                {""},
                {"     "},
                {GenerateTestData.generateWithTreeSpacesFullName()},
                {"DROP TABLE user;"},
        };
    }

    @DataProvider(name = "notValidConfirmPasswordProvider")
    public static Object[][] notValidConfirmPasswordDataProvider() {
        return new Object[][]{
                {GenerateTestData.generatePassword()},
                {""},
                {"DROP TABLE user;"},
        };
    }

    @DataProvider(name = "notValidSuperCodeProvider")
    public static Object[][] notValidSuperCodeDataProvider() {
        return new Object[][]{
                {Credentials.NOT_VALID_SUPER_CODE},
                {Credentials.NOT_VALID_2digits_SUPER_CODE},
                {Credentials.NOT_VALID_4digits_SUPER_CODE},
                {""},
                {"   "},
        };
    }
}
