package app.mapl.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserRequest {
    private String email;
    private String password;
    private boolean authenticated;

    public UserRequest(String email, String password) {
        this.email = email;
        this.password = password;
        this.authenticated = false;
    }

}
