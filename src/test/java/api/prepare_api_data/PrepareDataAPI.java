package api.prepare_api_data;

import api.models.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PrepareDataAPI {



    public static String getUserToken() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/LoginUser.json");
        String json = gson.fromJson(reader, LoginUserResponseModel.class).getToken();
        return json;
    }

    public static String getSuperToken() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/LoginSuperUser.json");
        String json = gson.fromJson(reader, LoginUserResponseModel.class).getToken();
        return json;
    }


    public static String getProductName() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/NewProduct.json");
        String json = gson.fromJson(reader, ProductDataResponseModel.class).getName();
        return json;
    }

    public static String getProductId() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/ProductForEdit.json");
        Type listType = new TypeToken<ArrayList<ProductDataResponseModel>>() {
        }.getType();
        List<ProductDataResponseModel> yourClassList = new Gson().fromJson(reader, listType);
        return yourClassList.iterator().next().get_id();
    }

    public static String getProductVendor() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/ProductForEdit.json");
        Type listType = new TypeToken<ArrayList<ProductDataResponseModel>>() {
        }.getType();
        List<ProductDataResponseModel> yourClassList = new Gson().fromJson(reader, listType);
        return yourClassList.iterator().next().getVendor();
    }

    public static String getVendorName() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/NewVendor.json");
        String json = gson.fromJson(reader, VendorResponseModel.class).getName();
        return json;
    }
    public static String getVendorId() throws FileNotFoundException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("src/test/resources/NewVendor.json");
        String json = gson.fromJson(reader, VendorResponseModel.class).get_id();
        return json;
    }
    public static String getUserId() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/ListOfUsers.json");
        Type listType = new TypeToken<ArrayList<UserInfoResponseModel>>() {
        }.getType();
        List<UserInfoResponseModel> yourClassList = new Gson().fromJson(reader, listType);
        return yourClassList.stream().skip(yourClassList.size() - 1).findFirst().get().get_id();
    }

    public static String getDiscountByPrice() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/DiscountList.json");
        Type listType = new TypeToken<ArrayList<DiscountResponseModel>>() {
        }.getType();
        List<DiscountResponseModel> yourClassList = new Gson().fromJson(reader, listType);
        return String.valueOf(yourClassList.iterator().next().getPrice());
    }
    public static String getDiscountByVendor() throws FileNotFoundException {
        Reader reader = new FileReader("src/test/resources/DiscountList.json");
        Type listType = new TypeToken<ArrayList<DiscountResponseModel>>() {
        }.getType();
        List<DiscountResponseModel> yourClassList = new Gson().fromJson(reader, listType);
        return String.valueOf(yourClassList.iterator().next().getVendor());
    }
}
