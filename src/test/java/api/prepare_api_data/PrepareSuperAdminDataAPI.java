package api.prepare_api_data;

import api.models.SuperAdminPutRequestModel;

public class PrepareSuperAdminDataAPI {

    public static SuperAdminPutRequestModel putSuperAdminInfo() {
        return SuperAdminPutRequestModel.builder().build()
                .builder()
                .superPass("777")
                .role("admin")
                .build();
    }
}
