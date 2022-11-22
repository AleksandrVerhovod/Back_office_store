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
public class VendorResponseModel {

    private String name;
    private Integer regCode;
    private Integer code;
    private String address;
    private String owner;
    private String _id;
    private Date createdAt;
    private Date updatedAt;

}
