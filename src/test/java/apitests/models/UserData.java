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

    public UserData() {
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
