package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserData {
    private String name;
    private String email;


    public UserData(String name, String email) {
        this.name = name;
        this.email = email;
    }


}
