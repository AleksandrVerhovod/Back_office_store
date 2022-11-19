package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegistrationModel {
    private String email;
    private String password;
    private String confirmPassword;
    private String fullName;
    private String superCode;
}
