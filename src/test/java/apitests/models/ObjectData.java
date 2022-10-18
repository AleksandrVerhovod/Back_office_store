package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjectData {
    private String _id;
    private String name;
    private Integer price;
    private String category;
    private String owner;
    private String createdAt;
    private String updateAt;

    public ObjectData(String _id, String name, Integer price, String category, String owner, String createdAt, String updateAt) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.category = category;
        this.owner = owner;
        this.createdAt = createdAt;
        this.updateAt = updateAt;
    }
}
