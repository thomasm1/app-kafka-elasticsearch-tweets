package app.mapl.dto;

import app.mapl.models.Role;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@Getter
@Setter
public class RegisterDto implements Serializable {
    private static long serialVersionUID = 1L;
    private String email;
    private String password;

    public RegisterDto(String email, String password   ) {

        this.email = email;
        this.password = password;

    }

    String makeUsername(String email) {
//        	String[] parts = email.split("@");
//        	return parts[0];
        return email;
    }
 
    public void setRoles(Set<Role> roleUser) {
    } 
}
