package testdata.dataprovider;

import constants.Credentials;
import io.qameta.allure.Step;
import org.testng.annotations.DataProvider;
import utils.GenerateEmail;
import utils.GenerateFullName;
import utils.GeneratePassword;
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
                {Credentials.CYRILLIC_VALID_EMAIL, Credentials.VALID_PASSWORD}
        };
    }

    @DataProvider(name = "validRandomEmailPasswordProvider")
    public static Object[][] dataRandomValidProviderData() {
        return new Object[][]{
                {GenerateEmail.generateEmail(), GeneratePassword.generatePassword()},
                {GenerateEmail.generateMinEmail(), GeneratePassword.generatePasswordMin()},
                {GenerateEmail.generateEmailSpecChars(), GeneratePassword.generatePasswordMax()},
                {GenerateEmail.generateEmailUPPERCase(), GeneratePassword.generatePasswordWithSpecChars()},
                {GenerateEmail.generateEmailWithSpaces(), GeneratePassword.generatePasswordWithSpacesBeginAndEnd()},
                {GenerateEmail.generateEmailMinPlus1(), GeneratePassword.generatePasswordMinPlus1()},
                {GenerateEmail.generateEmailMaxMinus1(), GeneratePassword.generatePasswordMaxMinus1()},
                {GenerateEmail.generateEmailWithCyrillic(), GeneratePassword.generatePassword()},
        };
    }

    @DataProvider(name = "notValidEmailProvider")
    public static Object[][] dataNoValidProviderEmail() {
        return new Object[][]{
                {GenerateEmail.generateEmailWithDotBegin()},
                {GenerateEmail.generateEmailWithout_a()},
                {GenerateEmail.generateEmailWithoutDot()},
                {GenerateEmail.generateEmailWithEmptyLocal()},
                {GenerateEmail.generateEmailWithEmptyDomen()},
                {GenerateEmail.generateEmailMaxPlus1()},
                {GenerateEmail.generateMinMinus1Email()},
                {"           "},
                {"<script>alert(123)</script>"},
                {"<script>alert(«Hello, world!»)</alert>"},
                {"DROP TABLE user;"},
                {"«»‘~!@#$%^&*()?>,./<][ /*<!—«», «${code}»;—>"},
                {"%%%/%%%"},
                {""},
                {Credentials.CYRILLIC_VALID_EMAIL},
                {Credentials.VALID_CONST_EMAIL},

        };
    }

    @DataProvider(name = "notValidPasswordProvider")
    public static Object[][] notValidPasswordDataProvider() {
        return new Object[][]{
                {GeneratePassword.generatePasswordMaxPlus1()},
                {GeneratePassword.generatePasswordMinMinus1()},
                {GeneratePassword.generatePasswordLowerCase()},
                {GeneratePassword.generatePasswordWithoutSpecChar()},
                {GeneratePassword.generatePasswordWithoutNumber()},
                {GeneratePassword.generatePasswordWithCyrillic()},
                {"<script>alert(123)</script>"},
                {"          "},
                {""},
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

    @DataProvider(name = "notValidFullNameProvider")

    public static Object[][] notValidFullNameDataProvider() {
        return new Object[][]{
                {GenerateFullName.generateMaxPlus1FullName()},
                {GenerateFullName.generateMinMinus1FullName()},
                {""},
                {"     "},
                {GenerateFullName.generateWithTreeSpacesFullName()},
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
