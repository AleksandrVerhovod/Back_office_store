package testdata;
import constants.Credentials;
import models.LoginModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateTestData;
public class PrepareLoginData {
    private static final Logger LOGGER = LogManager.getLogger(PrepareLoginData.class.getName());

    public static LoginModel getValidLogin() {
        LOGGER.info("Generate login valid data");
        return LoginModel
                .builder()
                .email(Credentials.VALID_CONST_EMAIL)
                .password(Credentials.VALID_PASSWORD)
                .build();
    }

    public static LoginModel getFakeEmailLogin() {
        LOGGER.info("Generate login data with random email");
        return LoginModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .password(Credentials.VALID_PASSWORD)
                .build();
    }

    public static LoginModel getFakePasswordLogin() {
        LOGGER.info("Generate login data with invalid password");
        return LoginModel
                .builder()
                .email(Credentials.VALID_CONST_EMAIL)
                .password(GenerateTestData.generatePassword())
                .build();
    }

    public static LoginModel getLoginWithEmptyFieldsLogin() {
        LOGGER.info("Generate login data with empty fields password and confirm password");
        return LoginModel
                .builder()
                .email("")
                .password("")
                .build();
    }
}
