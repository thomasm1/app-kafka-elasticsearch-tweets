package app.mapl.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Getter
@Setter
public class RegisterDto implements Serializable {
    private static long serialVersionUID = 1L;
    private String email;
    private String lastName;
    private String firstName;
    private String password;

    public RegisterDto(String email, String password,String firstName, String lastName   ) {
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.firstName = firstName;

    }

    String makeUsername(String email) {
        	String[] parts = email.split("@");
        	return parts[0];
    }

}
