package apitests.tests;

import apitests.models.*;
import apitests.prepare_api_data.PrepareSuperAdminDataAPI;
import apitests.utils.Specifications;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.Credentials;
import constants.Urls;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;

public class APISuperAdminTest {
    @Test(priority = 1)
    public void getSuperAdminInfoTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        SuperAdminResponseModel loginUserData = given()
                .auth().preemptive().basic(Credentials.SUPER_EMAIL, Credentials.superPassword)
                .when()
                .contentType(ContentType.JSON)
                .get(Urls.URL_SUPER_USER)
                .then().log().all()
                .extract().as(SuperAdminResponseModel.class);
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/LoginSuperUser.json")) {
            gson.toJson(loginUserData, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test(priority = 2)
    public void putSuperPassAndRoleTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        SuperAdminPutRequestModel superAdminPutRequestModel = PrepareSuperAdminDataAPI.putSuperAdminInfo();
        Response response = given()
                .auth().preemptive().basic(Credentials.SUPER_EMAIL, Credentials.superPassword)
                .body(superAdminPutRequestModel)
                .when()
                .put(Urls.URL_SUPER_USER)
                .then()
                .log().all()
                .extract().response();
    }

    @Test(priority = 2)
    public void getAllUsersInformationTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        SuperAdminPutRequestModel superAdminPutRequestModel = PrepareSuperAdminDataAPI.putSuperAdminInfo();
        given()
                .auth().preemptive().basic(Credentials.SUPER_EMAIL, Credentials.superPassword)
                .when()
                .get(Urls.URL_ALL_USERS)
                .then()
                .log().all()
                .extract().response();
    }


    @Test(priority = 2)
    public void updateRoleTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        SuperAdminPutRequestModel superAdminPutRequestModel = PrepareSuperAdminDataAPI.putSuperAdminInfo();
        given()
                .auth().preemptive().basic(Credentials.SUPER_EMAIL, Credentials.superPassword)
                .body(superAdminPutRequestModel)
                .when()
                .put(Urls.URL_ALL_USERS)
                .then()
                .log().all()
                .extract().response();
    }

}
