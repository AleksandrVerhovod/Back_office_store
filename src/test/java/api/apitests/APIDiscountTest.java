package api.apitests;

import api.models.DiscountResponseModel;
import api.models.LoginUserRequestModel;
import api.models.LoginUserResponseModel;
import api.prepare_api_data.PrepareDataAPI;
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
import utils.GenerateTestData;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class APIDiscountTest {
    @Test(priority = 1)
    public void loginUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        LoginUserRequestModel loginData = new LoginUserRequestModel(Credentials.VALID_EMAIL, Credentials.VALID_PASSWORD);
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


    @Test(priority = 2)
    public void getProductWithDiscountTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_DISCOUNT)
                .then().log().body()
                .body("qty", notNullValue())
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        List<DiscountResponseModel> productJson = jsonPath.getList("result");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/DiscountList.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void getDiscountByCategoryTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(String.format(Urls.URL_DISCOUNT_SEARCH_BY_CATEGORY, GenerateTestData.getCategory()))
                .then().log().body()
                .body("qty", notNullValue())
                .extract().response();
    }

    @Test(priority = 4)
    public void getDiscountByPriceTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(String.format(Urls.URL_DISCOUNT_SEARCH_BY_PRICE, PrepareDataAPI.getDiscountByPrice()))
                .then().log().body()
                .body("qty", notNullValue())
                .extract().response();
    }

    @Test(priority = 4)
    public void getDiscountByVendorTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(String.format(Urls.URL_DISCOUNT_SEARCH_BY_VENDOR, PrepareDataAPI.getDiscountByVendor()))
                .then().log().body()
                .body("qty", notNullValue())
                .extract().response();
    }


}
