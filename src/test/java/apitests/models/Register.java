package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Register {
    private String name;
    private String email;
    private String password;

    public Register(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

}
