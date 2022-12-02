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
                .email(Credentials.VALID_EMAIL)
                .password(Credentials.VALID_PASSWORD)
                .build();
    }

    public static LoginModel getValidDataForLogin(String email, String password) {
        LOGGER.info("Generate successfully user");
        return LoginModel
                .builder()
                .email(email)
                .password(password)
                .build();
    }

    public static LoginModel getNotValidEmailLogin(String email) {
        LOGGER.info("Generate login data with not valid Email");
        return LoginModel
                .builder()
                .email(email)
                .password(Credentials.VALID_PASSWORD)
                .build();
    }

    public static LoginModel getNotValidPasswordLogin(String password) {
        LOGGER.info("Generate login data with not valid Email");
        return LoginModel
                .builder()
                .email(Credentials.VALID_CONST_EMAIL)
                .password(password)
                .build();
    }
}
