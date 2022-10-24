package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteProductRequest {
    private String id;

    public DeleteProductRequest(String id) {
        this.id = id;
    }
}
