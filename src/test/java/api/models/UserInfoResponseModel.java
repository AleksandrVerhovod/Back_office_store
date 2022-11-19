package api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoResponseModel {
    private String _id;
    private String name;
    private String email;
    private Date createdAt;
    private Date updatedAt;
    private String admin;
}
