package apitests.prepare_data;

import apitests.models.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.GenerateTestData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PrepareAPIData {

    public static Register getRegistrationData() {
        return Register
                .builder()
                .name(GenerateTestData.generateName())
                .email(GenerateTestData.generateEmail())
                .password(GenerateTestData.generatePassword())
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

    public static DeleteProductRequest deleteProductData(String id) {
        return DeleteProductRequest
                .builder()
                .id(id)
                .build();
    }

    public static String getUserToken() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/LoginUser.json");
        String json = gson.fromJson(reader, LoginUserData.class).getToken();
                return json;
    }

    public static String getProductName() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/Product.json");
        String json = gson.fromJson(reader, ProductDataResp.class).getName();
        return json;
    }

    public static String getProductId() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/Product.json");
        String json = gson.fromJson(reader, ProductDataResp.class).toString();
        return json;
    }

}
