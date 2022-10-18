package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProductsData {
    private String object;
    private String objects;

    public ProductsData(String object, String objects) {
        this.object = object;
        this.objects = objects;
    }
}
