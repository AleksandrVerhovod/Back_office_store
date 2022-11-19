package api.prepare_api_data;

import api.models.DeleteByIdModel;
import api.models.VendorRequestModel;
import utils.GenerateTestData;

import java.io.FileNotFoundException;

public class PrepareVendorDataAPI {
    public static VendorRequestModel getValidVendorData() {
        return VendorRequestModel
                .builder()
                .name(GenerateTestData.generateVendorName())
                .address(GenerateTestData.generateVendorAddress())
                .build();
    }

    public static VendorRequestModel putValidVendorData() throws FileNotFoundException {
        return VendorRequestModel
                .builder()
                .id(PrepareDataAPI.getVendorId())
                .name(GenerateTestData.generateVendorName())
                .address(GenerateTestData.generateVendorAddress())
                .build();
    }

    public static DeleteByIdModel deleteByIdData(String id) {
        return DeleteByIdModel
                .builder()
                .id(id)
                .build();
    }

}
