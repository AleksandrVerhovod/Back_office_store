package apitests.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDataRequestModel {

    private String id;
    private String name;
    private Integer price;
    private Integer quantity;
    private String category;
    private Integer discountPrice;
}
