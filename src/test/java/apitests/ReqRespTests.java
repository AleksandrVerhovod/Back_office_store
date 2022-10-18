package apitests;

import apitests.models.*;
import apitests.prepare_data.PrepareAPIData;
import apitests.utils.Specifications;
import constants.Credentials;
import constants.Messages;
import constants.Urls;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class ReqRespTests {

    @Test
    public void registrationUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String name = PrepareAPIData.getRegistrationData().getName();
        String email = PrepareAPIData.getRegistrationData().getEmail();
        Register registerUser = new Register(name, email, PrepareAPIData.getRegistrationData().getPassword());
        UserData user = given()
                .body(registerUser)
                .when()
                .contentType(ContentType.JSON)
                .post(Urls.URL_REG_USER)
                .then().log().all()
                .extract().as(UserData.class);
        Assert.assertEquals(user.getName(), name);
        Assert.assertEquals(user.getEmail(), email);
    }

    @Test
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
        Assert.assertEquals(loginUserData.getMessage(), Messages.LOGIN);
    }

    @Test
    public void logoutUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        given()
                .when()
                .contentType(ContentType.JSON)
                .header("token", Credentials.TOKEN)
                .get(Urls.URL_LOGOUT_USER)
                .then().log().all()
                .body("message", equalTo(Messages.LOGOUT));
    }

    @Test
    public void getAllProductsTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        List<ProductsData> allProducts = given()
                .when()
                .contentType(ContentType.JSON)
                .header("token", Credentials.TOKEN)
                .get(Urls.URL_ALL_PRODUCTS)
                .then().log().all()
                .extract().body().jsonPath().getList("data", ProductsData.class);

    }

}

