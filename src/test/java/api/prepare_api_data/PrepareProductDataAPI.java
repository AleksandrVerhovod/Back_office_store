package api.prepare_api_data;

import api.models.CreatedProductModel;
import api.models.DeleteByIdModel;
import api.models.ProductDataRequestModel;
import utils.GenerateTestData;

import java.io.FileNotFoundException;

public class PrepareProductDataAPI {
    public static CreatedProductModel getValidCreatedProductData() {
        return CreatedProductModel
                .builder()
                .name(GenerateTestData.generateName())
//                .price(GenerateTestData.generatePrice())
//                .quantity(GenerateTestData.generateQuantity())
//               .unit(GenerateTestData.getUnit())
//                .category(GenerateTestData.generateCategory())
//                .discountPrice(GenerateTestData.generateDiscountPrice())
                .build();
    }

    public static ProductDataRequestModel getProductAllFieldsUpdData() throws FileNotFoundException {
        return ProductDataRequestModel
                .builder()
                .id(PrepareDataAPI.getProductId())
                .name(GenerateTestData.generateName())
                .price(GenerateTestData.generatePrice())
                .quantity(GenerateTestData.generateQuantity())
                .category(GenerateTestData.generateCategory())
                .discountPrice(GenerateTestData.generateDiscountPrice())
                .build();
    }

    public static DeleteByIdModel deleteProductData(String string) {
        return DeleteByIdModel
                .builder()
                .id(string)
                .status("deleted")
                .build();
    }
}
