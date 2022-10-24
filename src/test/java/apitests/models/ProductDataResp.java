package apitests.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDataResp{
    private String name;
    private String price;
    private String category;
    private String owner;

    public ProductDataResp(String name, String price, String category, String owner) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.owner = owner;
    }
}
