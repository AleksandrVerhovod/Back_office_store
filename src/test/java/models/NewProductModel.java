package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class NewProductModel {
    private String productName;
    private String category;
    private String price;
    private String quantity;
    private String vendorsName;
    private String vendorsRegCode;
}
