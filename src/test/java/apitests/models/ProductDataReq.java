package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDataReq {

    private String name;
    private String price;
    private String category;

    public ProductDataReq(String name, String price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
