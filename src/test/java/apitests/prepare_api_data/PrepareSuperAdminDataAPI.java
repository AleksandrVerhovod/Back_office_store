package apitests.prepare_api_data;

import apitests.models.RegisterModel;
import apitests.models.SuperAdminPutRequestModel;
import constants.Credentials;
import utils.GenerateTestData;

public class PrepareSuperAdminDataAPI {

    public static SuperAdminPutRequestModel putSuperAdminInfo() {
        return SuperAdminPutRequestModel.builder().build()
                .builder()
                .superPass("777")
                .role("super admin")
                .build();
    }
}
