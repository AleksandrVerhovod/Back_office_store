package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginModel {
    private String email;
    private String password;
}
