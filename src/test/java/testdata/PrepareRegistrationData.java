package testdata;

import constants.Credentials;
import models.RegistrationModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateEmail;
import utils.GeneratePassword;
import utils.GenerateTestData;

public class PrepareRegistrationData {
    private static final Logger LOGGER = LogManager.getLogger(PrepareRegistrationData.class.getName());

    public static RegistrationModel fillRegistrationModel(String email, String password) {
        LOGGER.info(String.format("Generate registration with data: %s", email,password));
        return RegistrationModel
                .builder()
                .email(email)
                .password(password)
                .confirmPassword(password)
                .fullName(GenerateTestData.generateFullName())
                .superCode(Credentials.SUPER_CODE)
                .build();
    }

    public static RegistrationModel fillRegistrationValidRendomModel() {
        String email = GenerateEmail.generateEmail();
        String password = GeneratePassword.generatePassword();
        LOGGER.info(String.format("Generate registration with data: %s", email,password));
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
        LOGGER.info(String.format("Generate registration with Email: %s", email));
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
        LOGGER.info(String.format("Generate registration with Password: %s",password));
        return RegistrationModel
                .builder()
                .email(GenerateEmail.generateEmail())
                .password(password)
                .confirmPassword(password)
                .fullName(GenerateTestData.generateFullName())
                .superCode(Credentials.SUPER_CODE)
                .build();
    }

    public static RegistrationModel fillRegistrationWithNegativeFullNameModel(String fullName) {
        String password = GenerateTestData.generatePassword();
        LOGGER.info(String.format("Generate registration with Full Name: %s", fullName));
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
        LOGGER.info(String.format("Generate registration with Confirm Password: %s", confirmPassword));
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
        LOGGER.info(String.format("Generate registration with Super Code: %s", superCode));
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
