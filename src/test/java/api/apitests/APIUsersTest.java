package api.apitests;
import api.models.*;
import api.prepare_api_data.PrepareDataAPI;
import api.prepare_api_data.PrepareRegistrationDataAPI;
import api.utils.Specifications;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.Credentials;
import constants.DataConstants;
import constants.api.Messages;
import constants.Urls;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;


public class APIUsersTest {
    @Test (priority = -3)
    public void registrationUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK201());
        RegisterModel user = PrepareRegistrationDataAPI.getValidRegistrationAdminData();
        Response response = given()
                .when()
                .body(user)
                .post(Urls.URL_REG_USER)
                .then().log().all()
                .body("message", equalTo(Messages.REG_USER))
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String regUser = jsonPath.get("user.email");
        Assert.assertEquals(regUser, user.getEmail());
    }

    @Test (priority = -2)
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

    @Test
    public void getUserTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_GET_USERS)
                .then().log()
                .body()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String userName = jsonPath.get("user.name");
        System.out.println(userName);
        System.out.println(DataConstants.USER());
        Assert.assertEquals(DataConstants.USER(), userName);
    }
    @Test (priority = 3)
    public void logoutUserTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_LOGOUT_USER)
                .then().log().all();
    }
}
