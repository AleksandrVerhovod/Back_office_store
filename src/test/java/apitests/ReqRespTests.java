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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class ReqRespTests {

    private static String id;
    private static String newProduct;

    @Test(priority = 1)
    public void registrationUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        Register user = PrepareAPIData.getRegistrationData();
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
        LoginData loginData = new LoginData(Credentials.EMAIL, Credentials.PASSWORD);
        LoginUserData loginUserData = given()
                .body(loginData)
                .when()
                .contentType(ContentType.JSON)
                .post(Urls.URL_LOGIN_USER)
                .then().log().all()
                .extract().as(LoginUserData.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/LoginUser.json")) {
            gson.toJson(loginUserData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(loginUserData.getMessage(), Messages.LOGIN);
    }

    @Test
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

    @Test
    public void addOneProductTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK201());
        ProductDataReq productDataReq = PrepareAPIData.getProductData();
        String loginToken = PrepareAPIData.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(productDataReq)
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
        Assert.assertEquals(PrepareAPIData.getProductName(), productDataReq.getName());
    }

    @Test
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
        List <ObjectData> productJson = jsonPath.getList("data[0].");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/Product.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    @Test
    public void deleteOneProductTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String idProduct = PrepareAPIData.getProductId();
        String loginToken = PrepareAPIData.getUserToken();
        String expectedMessage = String.format(Messages.DELETE_PRODUCT, idProduct);

        DeleteProductResp deleteProduct = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(idProduct)
                .when()
                .delete(Urls.URL_PRODUCT)
                .then().log().body()
                .extract().as(DeleteProductResp.class);
        Assert.assertEquals(deleteProduct.getMessage(), expectedMessage);
    }

    @Test
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
