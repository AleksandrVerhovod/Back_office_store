package apitests.prepare_api_data;

import apitests.models.RegisterModel;
import constants.Credentials;
import utils.GenerateTestData;

public class PrepareRegistrationDataAPI {
    public static RegisterModel getValidRegistrationAdminData() {
        return RegisterModel
                .builder()
                .name(GenerateTestData.generateName())
                .email(GenerateTestData.generateEmail())
                .password(GenerateTestData.generatePassword())
                .superPassword(Credentials.superPassword)
                .build();
    }
}