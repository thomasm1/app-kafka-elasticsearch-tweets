package xyz.cryptomaven.rest.models.dto;

import lombok.*;
import org.springframework.stereotype.Repository;
import xyz.cryptomaven.rest.models.Role;

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
  private String email;
  private String password;
  private String username;
  private String firstName;
  private String lastName;

  public RegisterDto(String email, String password   ) {

    this.email = email;
    this.password = password;


  }

  String makeUsername(String email) {
//        	String[] parts = email.split("@");
//        	return parts[0];
    return email;
  }

  public void setRoles(Set<RoleDto> roleUser) {
  }
}
