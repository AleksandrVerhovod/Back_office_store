package api.apitests;

import api.models.*;
import api.prepare_api_data.PrepareDataAPI;
import api.prepare_api_data.PrepareVendorDataAPI;
import api.utils.Specifications;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.Urls;
import constants.api.Messages;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;


import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.notNullValue;

public class APIVendorsTest {
    @Test
    public void getAllVendorsTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_VENDORS)
                .then().log()
                .body()
                .body("quantity", greaterThanOrEqualTo(1))
                .extract().response();
    }

    @Test (priority = -1)
    public void addVendorTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK201());
        VendorRequestModel vendorRequestModel = PrepareVendorDataAPI.getValidVendorData();
        String loginToken = PrepareDataAPI.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(vendorRequestModel)
                .when()
                .post(Urls.URL_VENDORS)
                .then().log().body()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        HashMap<String, String> productJson = jsonPath.get("data");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/NewVendor.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(PrepareDataAPI.getVendorName(), vendorRequestModel.getName());
    }

    @Test
    public void getVendorByNameTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(String.format(Urls.URL_VALID_VENDOR_NAME, PrepareDataAPI.getVendorName()))
                .then().log().body()
                .body("quantity", greaterThanOrEqualTo(1))
                .extract().response();
    }

    @Test
    public void updateVendorTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        VendorRequestModel vendorRequestModel = PrepareVendorDataAPI.putValidVendorData();
        String loginToken = PrepareDataAPI.getUserToken();
        Response response = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .log().all()
                .and()
                .body(vendorRequestModel)
                .when()
                .put(Urls.URL_VENDORS)
                .then()
                .log().all()
                .extract().response();
        JsonPath jsonPath = response.jsonPath();
        String updProductMessage = jsonPath.get("message");
        HashMap<String, String> productJson = jsonPath.get("newData");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter writer = new FileWriter("src/test/resources/NewVendor.json")) {
            gson.toJson(productJson, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(updProductMessage, Messages.UPDATE_VENDOR);
    }

    @Test (priority = 2)
    public void deleteVendorTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String idVendor= PrepareDataAPI.getVendorId();
        String loginToken = PrepareDataAPI.getUserToken();
        DeleteByIdModel deleteVendor = PrepareVendorDataAPI.deleteByIdData(idVendor);
        DeleteResponseModel deleteProduct = given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .body(deleteVendor)
                .when()
                .delete(Urls.URL_VENDORS)
                .then().log().body()
                .extract().as(DeleteResponseModel.class);
        Assert.assertEquals(deleteProduct.getMessage(), Messages.DELETE_VENDOR);
    }

}
