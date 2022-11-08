package apitests.tests;

import apitests.prepare_api_data.PrepareDataAPI;
import apitests.utils.Specifications;
import constants.DataConstants;
import constants.Urls;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class APICategoriesTest {

    @Test
    public void getAllCategoriesTest() throws FileNotFoundException {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String loginToken = PrepareDataAPI.getUserToken();
        given()
                .auth()
                .preemptive()
                .oauth2(loginToken)
                .when()
                .get(Urls.URL_CATEGORIES)
                .then().log()
                .body()
                .body("quantity", notNullValue())
                .extract().response();
    }
}
