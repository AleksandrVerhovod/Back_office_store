package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DiscountResponseModel {
    private String _id;
    private String name;
    private Integer price;
    private Integer quantity;
    private ArrayList<String> category;
    private String vendor;
    private String art;
    private String owner;
    private Date createdAt;
    private Date updatedAt;
    private Integer discountPrice;
    private String unit;
}
