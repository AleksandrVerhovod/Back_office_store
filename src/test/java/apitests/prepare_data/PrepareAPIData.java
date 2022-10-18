package apitests.prepare_data;

import apitests.models.ObjectData;
import apitests.models.Register;
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
                .category(GenerateTestData.generateCategory())
                .build();
    }
}
