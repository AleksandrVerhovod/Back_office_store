package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreatedProductModel {
    private String name;
    private Integer price;
    private Integer quantity;
    private String unit;
    private String category;
    private Integer discountPrice;
}
