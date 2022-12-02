package tests;

import io.qameta.allure.Feature;
import jdk.jfr.Description;
import models.NewProductModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.Test;
import pages.ProductsPage;
import pages.services.LoginSite;
import testdata.PrepareProductData;

@Feature("Products Page")
public class ProductsTest extends BaseTest {

    private static final Logger LOGGER = LogManager.getLogger(ProductsTest.class.getName());

    @Test
    @Description("Open Log In page")
    public void addNewProductInputValidDataTest() {
        LoginSite loginSite = new LoginSite(getDriver());
        LOGGER.info(String.format("Page %s initialized", LoginSite.class.getName()));
        loginSite.loginForConfirm();
        ProductsPage productsPage = new ProductsPage(getDriver());
        LOGGER.info(String.format("Page %s initialized", ProductsPage.class.getName()));
        NewProductModel newProductModel = PrepareProductData.getValidDataNewProduct();
        productsPage.openProductPage()
                .clickButtonAddNewProduct()
                .fillValidDataFormNewProducts(newProductModel)
                .clickButtonCreateProduct();
    }

}
