package app.mapl.models.auth;

import app.mapl.models.BaseModel;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import app.mapl.models.auth.Authority;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "ROLE_ENTITY")
@JsonInclude(NON_DEFAULT)
public class RoleEntity extends BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private Authority authorities;
//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "role_id"),    inverseJoinColumns = @JoinColumn(name = "userid"))
//    private Set<User> users = new HashSet<>();



    }
