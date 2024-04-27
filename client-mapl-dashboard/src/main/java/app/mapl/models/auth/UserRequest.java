package app.mapl.models.auth;

import app.mapl.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.v3.oas.annotations.info.Contact;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;


    @Getter
    @Setter
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @JsonIgnoreProperties(ignoreUnknown = true)
    public class UserRequest extends User {

        private static final long serialVersionUID = 1L;

        @NotEmpty(message = "First name is required")
        private String firstName;
        @NotEmpty(message = "Last name is required")
        private String lastName;
        @NotEmpty(message = "Email is required")
        @Email(message = "Email is invalid")
        private String email;
        @NotEmpty(message = "Password is required")
        private String password;
        private String bio;
        private String phone;

//    private boolean authenticated;


    public UserRequest(String email, String password,String firstName, String lastName   ) {
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
