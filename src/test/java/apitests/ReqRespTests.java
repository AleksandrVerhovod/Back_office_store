package apitests;

import apitests.models.*;
import apitests.prepare_data.PrepareAPIData;
import apitests.utils.Specifications;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.Credentials;
import constants.DataConstants;
import constants.Messages;
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
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class ReqRespTests {

    @Test(priority = 1, enabled = false)
    public void registrationUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        RegisterModel user = PrepareAPIData.getRegistrationData();
        Response response = given()
                .when()
                .body(user)
                .post(Urls.URL_REG_USER)
                .then().log().all()
                .body("message", equalTo(Messages.REG_USER))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String regUser = jsonPath.get("data.email");
        Assert.assertEquals(regUser, user.getEmail());
    }

    @Test(priority = 1)
    public void loginUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        LoginUserRequestModel loginData = new LoginUserRequestModel(Credentials.EMAIL, Credentials.PASSWORD);
        LoginUserResponseModel loginUserData = given()
                .body(loginData)
                .when()
                .contentType(ContentType.JSON)
                .post(Urls.URL_LOGIN_USER)
                .then().log().all()
                .extract().as(LoginUserResponseModel.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/LoginUser.json")) {
            gson.toJson(loginUserData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(loginUserData.getMessage(), Messages.LOGIN);
    }

    @Test (priority = 2)
    public void getAllProductsTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareAPIData.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_ALL_PRODUCTS)
                .then().log()
                .body()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<String> products = jsonPath.get("data.name");
        System.out.println(products);
        System.out.println(DataConstants.PRODUCTS());
        Assert.assertEquals(DataConstants.PRODUCTS(), products);
    }

    @Test (priority = 3)
    public void addOneProductTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK201());
        CreatedProductModel createdProductModel = PrepareAPIData.getCreatedProductData();
        String loginToken = PrepareAPIData.getUserToken();
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
        try (FileWriter writer = new FileWriter("src/test/resources/Product.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(PrepareAPIData.getProductName(), createdProductModel.getName());
    }

    @Test (priority = 4)
    public void getProductByQueryTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareAPIData.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(String.format(Urls.URL_VALID_QUERY_PRODUCT, PrepareAPIData.getProductName()))
                .then().log().body()
                .body("data.id", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<ProductDataResponseModel> productJson = jsonPath.getList("data");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/ProductForEdit.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 5, enabled = false)
    public void updateOneProductTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK201());
        ProductDataRequestModel productDataReq = PrepareAPIData.getProductData();
        String loginToken = PrepareAPIData.getUserToken();
        ProductDataResponseModel updateProduct = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
               .log().all()
       .and()
       .body(productDataReq)
       .when()
       .put("*******")
       .then()
       .log().all()
                .extract().body().jsonPath().getObject("data", ProductDataResponseModel.class);
        Assert.assertEquals(updateProduct.getName(), productDataReq.getName());
    }

    @Test (priority = 6)
    public void deleteOneProductTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String idProduct = PrepareAPIData.getProductId();
        String loginToken = PrepareAPIData.getUserToken();
        String expectedMessage = String.format(Messages.DELETE_PRODUCT, idProduct);
        DeleteProductRequestModel deleteProductRequest = PrepareAPIData.deleteProductData(idProduct);
        DeleteProductResponseModel deleteProduct = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(deleteProductRequest)
                .when()
                .delete(Urls.URL_PRODUCT)
                .then().log().body()
                .extract().as(DeleteProductResponseModel.class);
        Assert.assertEquals(deleteProduct.getMessage(), expectedMessage);
    }
       @Test (priority = 7)
    public void logoutUserTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareAPIData.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_LOGOUT_USER)
                .then().log().all();
    }
}
