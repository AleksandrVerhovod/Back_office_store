package api.apitests;

import api.models.LoginUserRequestModel;
import api.models.LoginUserResponseModel;
import api.prepare_api_data.PrepareDataAPI;
import api.utils.Specifications;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import constants.Credentials;
import constants.Urls;
import constants.api.Messages;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class APICategoriesTest {
//
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
