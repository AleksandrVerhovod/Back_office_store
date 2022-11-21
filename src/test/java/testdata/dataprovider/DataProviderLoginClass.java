package testdata.dataprovider;

import constants.Credentials;
import org.testng.annotations.DataProvider;
import utils.GenerateEmail;
import utils.GeneratePassword;

public class DataProviderLoginClass {

    @DataProvider(name = "validEmailAndPasswordForLoginProvider")
    public static Object[][] validEmailAndPasswordForLoginDataProvider() {
        return new Object[][]{
                {Credentials.MAX_VALID_EMAIL, Credentials.MAX_VALID_PASSWORD},
                {Credentials.MIN_VALID_EMAIL, Credentials.MIN_VALID_PASSWORD},
                {Credentials.MAXminus1_VALID_EMAIL, Credentials.MAXminus1_VALID_PASSWORD},
                {Credentials.MINplus1_VALID_EMAIL, Credentials.MINplus1_VALID_PASSWORD},
                {Credentials.UPPERCASE_VALID_EMAIL, Credentials.VALID_PASSWORD},
                {Credentials.VALID_CONST_EMAIL, Credentials.VALID_PASSWORD},
                {Credentials.CYRILLIC_VALID_EMAIL, Credentials.VALID_PASSWORD},
        };
    }


    @DataProvider(name = "notValidEmailForLoginDataProvider")
    public static Object[][] notValidEmailForLoginDataProvider() {
        return new Object[][]{
                {Credentials.WITH_SPACES_VALID_EMAIL},
                {GenerateEmail.generateEmail()},
                {Credentials.UPPERCASE_NOT_VALID_EMAIL},
                {Credentials.VALID_CONST_WITHOUT_a_EMAIL},
                {Credentials.VALID_CONST_WITHOUT_DOT_EMAIL},
                {Credentials.VALID_CONST_WITH_SPACE_BEGIN_EMAIL},
                {Credentials.VALID_CONST_WITH_SPACE_MIDDLE_EMAIL},
                {Credentials.VALID_CONST_WITH_SPACE_END_EMAIL},
                {""},
                {"               "},
                {Credentials.VALID_PASSWORD},
                {"<script>alert(123)</script>"},
                {"<script>alert(«Hello, world!»)</alert>"},
                {"DROP TABLE user;"},
                {"%%%/%%%"},
                {GenerateEmail.generateMinMinus1Email()},
                {GenerateEmail.generateEmailMaxPlus1()}
        };
    }

    @DataProvider(name = "notValidPasswordForLoginDataProvider")
    public static Object[][] notValidPasswordForLoginDataProvider() {
        return new Object[][]{
                {GeneratePassword.generatePassword()},
                {Credentials.WITH_SPACES_VALID_PASSWORD},
                {Credentials.VALID_WITH_SPACE_BEGIN_PASSWORD},
                {Credentials.VALID_WITH_SPACE_MIDDLE_PASSWORD},
                {Credentials.VALID_WITH_SPACE_END_PASSWORD},
                {Credentials.VALID_WITH_CYRILLIC_PASSWORD},
                {Credentials.VALID_WITHOUT_SPEC_CHAR_PASSWORD},
                {GeneratePassword.generatePasswordMaxPlus1()},
                {GeneratePassword.generatePasswordMinMinus1()},
                {""},
                {"       "},
                {"<script>alert(123)</script>"},
                {"<script>alert(«Hello, world!»)</alert>"},
                {"DROP TABLE user;"},
                {"%%%/%%%"},
                {Credentials.VALID_WITHOUT_DIGIT_PASSWORD},
                {Credentials.VALID_LOWER_CASE_PASSWORD}

        };
    }

}
