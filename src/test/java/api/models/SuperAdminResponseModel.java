package api.models;

import io.qameta.allure.internal.shadowed.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SuperAdminResponseModel {
    private int articul;
    @JsonProperty("V")
    private int v;
    private String role;
    private String superPass;
}
