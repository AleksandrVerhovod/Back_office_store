package testdata;

import constants.Credentials;
import models.LoginModel;
import models.NewProductModel;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import utils.GenerateProduct;

public class PrepareProductData {

    private static final Logger LOGGER = LogManager.getLogger(PrepareProductData.class.getName());

    public static NewProductModel getValidDataNewProduct() {
        LOGGER.info("Generate new product with valid data");
        return NewProductModel
                .builder()
                .productName(GenerateProduct.generateProductName())
                .category(GenerateProduct.generateCategory())
                .price(GenerateProduct.generatePrice())
                .quantity(GenerateProduct.generateQuantity())
                .vendorsName(GenerateProduct.generateProductName())
                .vendorsRegCode(GenerateProduct.generateVendorsCode())
                .build();
    }
}
