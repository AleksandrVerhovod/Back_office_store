package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ObjectData {
    public String _id;
    public String name;
    public Integer price;
    public String owner;

    public ObjectData(String _id, String name, Integer price, String owner) {
        this._id = _id;
        this.name = name;
        this.price = price;
        this.owner = owner;
    }
}
