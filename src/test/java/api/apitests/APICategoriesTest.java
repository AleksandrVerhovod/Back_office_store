package api.apitests;

import api.prepare_api_data.PrepareDataAPI;
import api.utils.Specifications;
import constants.Urls;
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
