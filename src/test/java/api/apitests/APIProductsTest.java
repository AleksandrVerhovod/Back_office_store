package api.apitests;

import api.models.*;
import api.prepare_api_data.PrepareDataAPI;
import api.prepare_api_data.PrepareProductDataAPI;
import api.utils.Specifications;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.Credentials;
import constants.api.Messages;
import constants.Urls;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

public class APIProductsTest {

    @Test (priority = -1)
    public void getAllProductsTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_ALL_PRODUCTS)
                .then().log().all()
                .body("qty", greaterThanOrEqualTo(1))
                .extract().response();
        JsonPath jsonPathWrite = response.jsonPath();
        List<ProductDataResponseModel> productJson = jsonPathWrite.getList("result");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/ListOfProduct.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = -1)
    public void addValidProductTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK201());
        CreatedProductModel createdProductModel = PrepareProductDataAPI.getValidCreatedProductData();
        String loginToken = PrepareDataAPI.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(createdProductModel)
                .when()
                .post(Urls.URL_PRODUCT)
                .then().log().body()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        HashMap<String, String> productJson = jsonPath.get("data");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/NewProduct.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(PrepareDataAPI.getProductName(), createdProductModel.getName());
    }

    @Test (priority = -1)
    public void getProductByNameTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(String.format(Urls.URL_VALID_NAME_PRODUCT, PrepareDataAPI.getProductName()))
                .then().log().body()
                .body("qty", greaterThanOrEqualTo(1))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<ProductDataResponseModel> productJson = jsonPath.getList("result");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/ProductForEdit.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getProductByVendorTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(String.format(Urls.URL_VALID_VENDOR_PRODUCT, PrepareDataAPI.getProductVendor()))
                .then().log().body()
                .body("qty", greaterThanOrEqualTo(1))
                .extract().response();
    }

    @Test
    public void getProductByMultipleParametersTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_VALID_MULTI_PARAMETERS_PRODUCT)
                .then().log().body()
                .body("qty", greaterThanOrEqualTo(1))
                .extract().response();

    }
    @Test
    public void getProductByPriceRangeTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_VALID_RANGE_PRICE_PRODUCT)
                .then().log().body()
                .body("qty", greaterThanOrEqualTo(1))
                .extract().response();
    }


    @Test
    public void updateOneProductTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        ProductDataRequestModel productDataReq = PrepareProductDataAPI.getProductAllFieldsUpdData();
        String loginToken = PrepareDataAPI.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .log().all()
                .and()
                .body(productDataReq)
                .when()
                .put(Urls.URL_PRODUCT)
                .then()
                .log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String updProductMessage = jsonPath.get("message");
        Assert.assertEquals(updProductMessage, Messages.UPDATE_PRODUCT);
    }

    @Test (priority = 2)
    public void deleteOneProductTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String idProduct = PrepareDataAPI.getProductId();
        String loginToken = PrepareDataAPI.getUserToken();
        String expectedMessage = String.format(Messages.DELETE_PRODUCT, idProduct);
        DeleteByIdModel deleteProductRequest = PrepareProductDataAPI.deleteProductData(idProduct);
        DeleteResponseModel deleteProduct = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(deleteProductRequest)
                .when()
                .put(Urls.URL_PRODUCT)
                .then().log().body()
                .extract().as(DeleteResponseModel.class);
        Assert.assertEquals(deleteProduct.getMessage(), expectedMessage);
    }
}
