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
    public int articul;
    @JsonProperty("V")
    public int v;
    public String role;
    public String superPass;
}
