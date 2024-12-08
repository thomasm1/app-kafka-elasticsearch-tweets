package app.mapl.models.dto;

import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Getter
@Setter
public class LoginDto  implements Serializable {
    static long serialVersionUID = 1L;
    private String usernameOrEmail;
    private String password;

    public LoginDto(String usernameOrEmail, String password ) {
        this.usernameOrEmail = usernameOrEmail;
        this.password = password;
    }


}
