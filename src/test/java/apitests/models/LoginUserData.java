package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginUserData {
    private String message;
    private String token;

    public LoginUserData(String message, String token) {
        this.message = message;
        this.token = token;
    }
}
