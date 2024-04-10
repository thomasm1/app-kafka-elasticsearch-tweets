package app.mapl.dto;

import app.mapl.models.RoleEntity;
import lombok.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;


//@NoArgsConstructor
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto  implements Serializable {
    static final long serialVersionUID = 1L;
    private int userId; // userId;
    private String email;
    private String password;
    private String lastName;
    private String firstName;
    private int userType;
    private String organizationCode;

    private String dashboardCode;

    // parent of many
//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)

    private Set<RoleEntity> roles;

}
