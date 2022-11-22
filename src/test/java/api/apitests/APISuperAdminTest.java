package api.apitests;

import api.models.*;
import api.prepare_api_data.PrepareDataAPI;
import api.prepare_api_data.PrepareSuperAdminDataAPI;
import api.prepare_api_data.PrepareVendorDataAPI;
import api.utils.Specifications;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.Credentials;
import constants.Urls;
import constants.api.Messages;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class APISuperAdminTest {
    @Test
    public void getSuperAdminInfoTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        LoginUserRequestModel loginData = new LoginUserRequestModel(Credentials.SUPER_EMAIL, Credentials.SUPER_PASSWORD);
        LoginUserResponseModel loginUserData = given()
                .body(loginData)
                .when()
                .contentType(ContentType.JSON)
                .post(Urls.URL_LOGIN_USER)
                .then().log().all()
                .extract().as(LoginUserResponseModel.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/LoginSuperUser.json")) {
            gson.toJson(loginUserData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(loginUserData.getMessage(), Messages.LOGIN);
    }


    @Test
    public void putSuperPassAndRoleTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        SuperAdminPutRequestModel superAdminPutRequestModel = PrepareSuperAdminDataAPI.putSuperAdminInfo();
        String loginToken = PrepareDataAPI.getSuperToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(superAdminPutRequestModel)
                .when()
                .put(Urls.URL_SUPER_USER)
                .then()
                .log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String superPass = jsonPath.get("superPass");
        Assert.assertEquals(superPass, superAdminPutRequestModel.getSuperPass());
    }

    @Test
    public void updateRoleTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        SuperAdminPutRequestModel superAdminPutRequestModel = PrepareSuperAdminDataAPI.putSuperAdminInfo();
        String loginToken = PrepareDataAPI.getSuperToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(superAdminPutRequestModel)
                .when()
                .put(Urls.URL_SUPER_USER)
                .then()
                .log().all()
                .extract().response();
    }
    @Test
    public void getAllUsersInformationTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getSuperToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_ALL_USERS)
                .then()
                .log().all()
                .body("quantity", greaterThanOrEqualTo(1))
                .extract().response();
        JsonPath jsonPathWrite = response.jsonPath();
        List<UserInfoResponseModel> productJson = jsonPathWrite.getList("result");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/ListOfUsers.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test (priority = 2)
    public void deleteUserTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String idUser = PrepareDataAPI.getUserId();
        String loginToken = PrepareDataAPI.getSuperToken();
        DeleteByIdModel deleteVendor = PrepareVendorDataAPI.deleteByIdData(idUser);
        DeleteResponseModel deleteProduct = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(deleteVendor)
                .when()
                .delete(Urls.URL_ALL_USERS)
                .then().log().body()
                .extract().as(DeleteResponseModel.class);
        Assert.assertEquals(deleteProduct.getMessage(), Messages.DELETE_USER);
    }

}
