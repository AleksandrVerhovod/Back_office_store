package apitests.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginToken {
    private String token;

    public LoginToken(String token) {
        this.token = token;
    }
}
