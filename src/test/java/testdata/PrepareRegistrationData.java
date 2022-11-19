package testdata;

import constants.Credentials;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateTestData;

public class PrepareRegistrationData {
    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());

    public static RegistrationModel fillRegistrationModel(String email, String password) {
        LOGGER.info("Generate registration valid data");
        return RegistrationModel
                .builder()
                .email(email)
                .password(password)
                .confirmPassword(password)
                .fullName(GenerateTestData.generateFullName())
                .superCode(Credentials.SUPER_CODE)
                .build();
    }

    public static RegistrationModel fillRegistrationWithNegativeEmailModel(String email) {
        LOGGER.info("Generate registration with not valid emails");
        String password = GenerateTestData.generatePassword();
        return RegistrationModel
                .builder()
                .email(email)
                .password(password)
                .confirmPassword(password)
                .fullName(GenerateTestData.generateFullName())
                .superCode(Credentials.SUPER_CODE)
                .build();
    }

    public static RegistrationModel fillRegistrationWithNegativePasswordModel(String password) {
        LOGGER.info("Generate registration with not valid passwords");
        return RegistrationModel
                .builder()
                .email(Credentials.VALID_CONST_EMAIL)
                .password(password)
                .confirmPassword(password)
                .fullName(GenerateTestData.generateFullName())
                .superCode(Credentials.SUPER_CODE)
                .build();
    }

    public static RegistrationModel fillRegistrationWithNegativeFullNameModel(String fullName) {
        String password = GenerateTestData.generatePassword();
        LOGGER.info("Generate registration with not valid full name");
        return RegistrationModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .password(password)
                .confirmPassword(password)
                .fullName(fullName)
                .superCode(Credentials.SUPER_CODE)
                .build();
    }

    public static RegistrationModel fillRegistrationWithNotValidConfirmPasswordModel(String confirmPassword) {
        LOGGER.info("Generate registration with not valid confirm data");
        return RegistrationModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .password(Credentials.VALID_PASSWORD)
                .confirmPassword(confirmPassword)
                .fullName(GenerateTestData.generateFullName())
                .superCode(Credentials.SUPER_CODE)
                .build();
    }

    public static RegistrationModel fillRegistrationWithNotValidSuperCodeModel(String superCode) {
        LOGGER.info("Generate registration with not valid super code");
        String password = GenerateTestData.generatePassword();
        return RegistrationModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .password(password)
                .confirmPassword(password)
                .fullName(GenerateTestData.generateFullName())
                .superCode(superCode)
                .build();
    }
}
