package app.mapl.models.auth;

import app.mapl.models.auth.RoleEntity;
import app.mapl.models.dto.UserDto;
import lombok.*;

import java.io.Serializable;
import java.util.Set;


//@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponse  extends User  {
    static final long serialVersionUID = 1L;

//    private int userId;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private int userType;
    private String bio;
    private String phone;

     private boolean authenticated;
    private String organizationCode;

    private String dashboardCode;

    // parent of many
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<RoleEntity> roles;

}
