package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteProductResp {
    private String message;

    public DeleteProductResp(String message) {
        this.message = message;
    }
}
