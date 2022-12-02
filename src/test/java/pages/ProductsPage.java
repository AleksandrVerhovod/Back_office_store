package pages;

import constants.Urls;
import io.qameta.allure.Step;
import models.NewProductModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends BasePage {
    private static final Logger LOGGER = LogManager.getLogger(LoginPage.class.getName());

    @FindBy(xpath = "//button[text()='Add new product']")
    private WebElement BUTTON_NEW_PRODUCT;

    @FindBy(xpath = "/html/body/div[2]/div/div/form/div/div[1]/div[1]/input")
    private WebElement PRODUCT_NAME_FIELD;

    @FindBy(xpath = "//div[contains(@class,'CreateProductForm_inputs')]//div[2]//input")
    private WebElement CATEGORY_FIELD;

    @FindBy(xpath = "//div[contains(@class,'CreateProductForm_inputs')]//div[3]//input")
    private WebElement PRICE_FIELD;

    @FindBy(xpath = "//div[contains(@class,'CreateProductForm_inputs')]//div[4]//input")
    private WebElement QUANTITY_FIELD;

    @FindBy(xpath = "//div[contains(@class,'CreateProductForm_inputs')]//div[5]//input")
    private WebElement VENDOR_NAME_FIELD;

    @FindBy(xpath = "//div[contains(@class,'CreateProductForm_inputs')]//div[6]//input")
    private WebElement VENDOR_CODE_FIELD;

    @FindBy(xpath = "//button[text()='Create']")
    private WebElement BUTTON_CREATE;

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        LOGGER.debug(String.format("Attempt to find button: %s", BUTTON_NEW_PRODUCT));
        return BUTTON_NEW_PRODUCT.isDisplayed();
    }

    @Step("Open product page")
    public ProductsPage openProductPage() {
        LOGGER.debug(String.format("Attempt to open URL: %s", String.format(Urls.URL_BACK_OFFICE_MAIN, Urls.URL_BACK_OFFICE_PRODUCTS)));
        driver.get(String.format(Urls.URL_BACK_OFFICE_MAIN, Urls.URL_BACK_OFFICE_PRODUCTS));
        return this;
    }

    @Step("Click button 'Add new product'")
    public ProductsPage clickButtonAddNewProduct() {
        LOGGER.debug(String.format("Click button by locator: %s", BUTTON_NEW_PRODUCT));
        BUTTON_NEW_PRODUCT.click();
        return this;
    }

    @Step("Fill the form of new product with valid data")
    public ProductsPage fillValidDataFormNewProducts(NewProductModel newProductModel) {
        PRODUCT_NAME_FIELD.sendKeys(newProductModel.getProductName());
        LOGGER.debug(String.format("Input Product Name: %s", newProductModel.getProductName()));
        CATEGORY_FIELD.sendKeys(newProductModel.getCategory());
        LOGGER.debug(String.format("Input Category: %s", newProductModel.getCategory()));
        PRICE_FIELD.sendKeys(newProductModel.getPrice());
        LOGGER.debug(String.format("Input Price: %s", newProductModel.getPrice()));
        QUANTITY_FIELD.sendKeys(newProductModel.getQuantity());
        LOGGER.debug(String.format("Input Quantity: %s", newProductModel.getQuantity()));
        VENDOR_NAME_FIELD.sendKeys(newProductModel.getVendorsName());
        LOGGER.debug(String.format("Input Vendor's name: %s", newProductModel.getVendorsName()));
        VENDOR_CODE_FIELD.sendKeys(newProductModel.getVendorsRegCode());
        LOGGER.debug(String.format("Input Vendor's Code: %s", newProductModel.getVendorsRegCode()));
        return this;
    }

    @Step("Click button 'Create'")
    public ProductsPage clickButtonCreateProduct() {
        LOGGER.debug(String.format("Click button by locator: %s", BUTTON_CREATE));
        BUTTON_CREATE.click();
        return this;
    }

}
