package apitests;

import apitests.models.*;
import apitests.prepare_data.PrepareAPIData;
import apitests.utils.Specifications;
import constants.Credentials;
import constants.DataConstants;
import constants.Messages;
import constants.Urls;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;


public class ReqRespTests {
String token;
    @Test (priority = 1)
    public void registrationUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        Register user = PrepareAPIData.getRegistrationData();
        UserData userData = given()
                .when()
                .body(user)
                .post(Urls.URL_REG_USER)
                .then().log().all()
                .extract().body().jsonPath().getObject("data", UserData.class);
        Assert.assertEquals(userData.getEmail(), user.getEmail());
    }

    @Test (priority = 1)
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
//         = loginUserData.getToken();
        Assert.assertEquals(loginUserData.getMessage(), Messages.LOGIN);
    }

    @Test
    public void getProductByQueryTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        List<ObjectData> queryProducts = given()
                .auth()
                .preemptive()
                .oauth2(Credentials.TOKEN)
                .when()
                .get(Urls.URL_VALID_QUERY_PRODUCT)
                .then().log().body()
                .extract().body().jsonPath().getList("data", ObjectData.class);
        List<String> products = queryProducts.stream().map(ObjectData::getName).collect(Collectors.toList());
        Assert.assertEquals(products, DataConstants.QUERY_PRODUCTS());
    }

    @Test
    public void getAllProductsTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        List<ObjectData> allProducts = given()
                .auth()
                .preemptive()
                .oauth2(Credentials.TOKEN)
                .when()
                .get(Urls.URL_ALL_PRODUCTS)
                .then().log().body()
                .extract().body().jsonPath().getList("data", ObjectData.class);
        List<String> products = allProducts.stream().map(ObjectData::getName).collect(Collectors.toList());
        System.out.println(products);
        System.out.println(DataConstants.PRODUCTS());
        Assert.assertEquals(DataConstants.PRODUCTS(), products);
    }

    @Test
    public void сreateOneProductTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK201());
        ProductDataReq productDataReq = PrepareAPIData.getProductData();
        ProductDataResp addedProduct = given()
                .auth()
                .preemptive()
                .oauth2(Credentials.TOKEN)
                .body(productDataReq)
                .when()
                .post(Urls.URL_PRODUCT)
                .then().log().body()
                .extract().body().jsonPath().getObject("data", ProductDataResp.class);
        Assert.assertEquals(addedProduct.getName(), productDataReq.getName());
    }

    @Test
    public void deleteOneProductTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        String idProduct = "635704b385bc08351e446de3";
        String expectedMessage = String.format(Messages.DELETE_PRODUCT, idProduct);
        DeleteProductRequest deleteProductRequest = PrepareAPIData.deleteProductData(idProduct);
        DeleteProductResp deleteProduct = given()
                .auth()
                .preemptive()
                .oauth2(Credentials.TOKEN)
                .body(deleteProductRequest)
                .when()
                .delete(Urls.URL_PRODUCT)
                .then().log().body()
                .extract().as(DeleteProductResp.class);
        Assert.assertEquals(deleteProduct.getMessage(), expectedMessage);
    }

        @Test
    public void logoutUserTest() {
        Specifications.installSpec(Specifications.requestSpecification(Urls.URL_API), Specifications.responseSpecOK200());
        given()
                .auth()
                .preemptive()
                .oauth2(Credentials.TOKEN)
                .when()
                .get(Urls.URL_LOGOUT_USER)
                .then().log().all();
    }
}
