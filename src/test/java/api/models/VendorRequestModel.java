package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VendorRequestModel {
    private String id;
    private String name;
    private Integer regCode;
    private Integer code;
    private String address;
}
