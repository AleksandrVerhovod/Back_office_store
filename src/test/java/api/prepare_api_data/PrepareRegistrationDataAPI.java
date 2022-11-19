package api.prepare_api_data;

import api.models.RegisterModel;
import constants.Credentials;
import utils.GenerateTestData;

public class PrepareRegistrationDataAPI {
    public static RegisterModel getValidRegistrationAdminData() {
        return RegisterModel
                .builder()
                .name(GenerateTestData.generateName())
                .email(GenerateTestData.generateEmail())
                .password(GenerateTestData.generateMinPassword())
                .superCode(Credentials.SUPER_CODE)
                .build();
    }
}
