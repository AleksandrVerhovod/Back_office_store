package apitests.models;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ProductDataResp{
    public String name;
    public String price;
    public String category;
    public String owner;

    public ProductDataResp(String name, String price, String category, String owner) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.owner = owner;
    }
}
