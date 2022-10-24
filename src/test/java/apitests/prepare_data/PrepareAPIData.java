package apitests.prepare_data;

import apitests.models.*;
import utils.GenerateTestData;

public class PrepareAPIData {

    public static Register getRegistrationData() {
        return Register
                .builder()
                .name(GenerateTestData.generateName())
                .email(GenerateTestData.generateEmail())
                .password(GenerateTestData.generatePassword())
                .build();
    }

    public static ObjectData getObjectData() {
        return ObjectData
                .builder()
                .name(GenerateTestData.generateName())
                .price(GenerateTestData.generatePrice())
                .build();
    }

    public static ProductDataReq getProductData() {
        return ProductDataReq
                .builder()
                .name(GenerateTestData.generateName())
                .price(String.valueOf(GenerateTestData.generatePrice()))
                .category(GenerateTestData.generateCategory())
                .build();
    }

    public static DeleteProductRequest deleteProductData(String string) {
        return DeleteProductRequest
                .builder()
                .id(string)
                .build();
    }
}
