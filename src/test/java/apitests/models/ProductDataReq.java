package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductDataReq {

    public String name;
    public String price;
    public String category;

    public ProductDataReq(String name, String price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }
}
