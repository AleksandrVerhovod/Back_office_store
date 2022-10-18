package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginData {
    private String email;
    private String password;

    public LoginData(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
