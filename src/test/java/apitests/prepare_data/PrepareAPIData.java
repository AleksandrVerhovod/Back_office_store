package apitests.prepare_data;

import apitests.models.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import utils.GenerateTestData;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrepareAPIData {

    public static RegisterModel getRegistrationData() {
        return RegisterModel
                .builder()
                .name(GenerateTestData.generateName())
                .email(GenerateTestData.generateEmail())
                .password(GenerateTestData.generatePassword())
                .build();
    }
    public static CreatedProductModel getCreatedProductData() {
        return CreatedProductModel
                .builder()
                .name(GenerateTestData.generateName())
                .price(String.valueOf(GenerateTestData.generatePrice()))
                .category(GenerateTestData.generateCategory())
                .build();
    }

    public static ProductDataRequestModel getProductData() {
        return ProductDataRequestModel
                .builder()
                .name(GenerateTestData.generateName())
                .price(String.valueOf(GenerateTestData.generatePrice()))
                .category(GenerateTestData.generateCategory())
                .build();
    }

    public static DeleteProductRequestModel deleteProductData(String string) {
        return DeleteProductRequestModel
                .builder()
                .id(string)
                .build();
    }
    public static String getUserToken() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/LoginUser.json");
        String json = gson.fromJson(reader, LoginUserResponseModel.class).getToken();
        return json;
    }

    public static String getProductName() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/Product.json");
        String json = gson.fromJson(reader, CreatedProductModel.class).getName();
        return json;
    }

    public static String getProductId() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/ProductForEdit.json");
        Type listType = new TypeToken<ArrayList<ProductDataResponseModel>>() {
        }.getType();
        List<ProductDataResponseModel> yourClassList = new Gson().fromJson(reader, listType);
        return yourClassList.iterator().next().get_id();
    }
}
