package api.prepare_api_data;

import api.models.RegisterModel;
import constants.Credentials;
import utils.GeneratePassword;
import utils.GenerateTestData;

public class PrepareRegistrationDataAPI {
    public static RegisterModel getValidRegistrationAdminData() {
        return RegisterModel
                .builder()
                .email(GenerateTestData.generateEmail())
                .name(GenerateTestData.generateName())
                .password(GenerateTestData.generatePassword())
                .superCode(Credentials.SUPER_CODE)
                .build();
    }
}
