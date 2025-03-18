package xyz.cryptomaven.rest.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@SuperBuilder  // ✅ Changed from @Builder to @SuperBuilder for JPA compatibility
@Entity
@Table(name = "users")
public class User implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "userid", nullable = false, unique = true)
  private Long userId;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Column(name = "lastname")
  private String lastName;

  @Column(name = "firstname")
  private String firstName;

  @Column(name = "usertype")
  private int userType;

  @Column(name = "email", nullable = false)
  private String email;

  @Column(name = "organizationcode")
  private String organizationCode;

  @Column(name = "cusurl")
  private String cusUrl;

  @Column(name = "dashboardcode")
  private String dashboardCode;

  @Column(name = "isactive")
  private int isActive;

  @Column(name = "contacttype")
  private int contactType;

  @Transient
  private String id;

  @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
  @ToString.Exclude  // ✅ Prevents infinite recursion
  @EqualsAndHashCode.Exclude // ✅ Avoids issues with hashCode()
  private Set<Address> addresses = new HashSet<>();


  @ToString.Exclude  // ✅ Prevents infinite recursion
  @EqualsAndHashCode.Exclude // ✅ Avoids issues with hashCode()
  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(
    name = "users_roles",
    joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userid"),
    inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
  )
  private Set<Role> roles = new HashSet<>();

}
