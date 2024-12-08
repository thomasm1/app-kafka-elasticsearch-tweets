package app.mapl.models.dto;

import app.mapl.models.Role;
import lombok.*;

import java.io.Serializable;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RegisterDto implements Serializable {
    private static long serialVersionUID = 1L;
    private String username;
    private String lastName;
    private String firstName;
    private String email;
    private String password;

    public RegisterDto(String email, String password,String firstName, String lastName   ) {
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;

        this.username = makeUsername(email);
    }

    String makeUsername(String email) {
        	String[] parts = email.split("@");
        	return parts[0];
    }

}
