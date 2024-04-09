package app.mapl.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;




@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "USERS")
public class User  implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
    private long userid;

    @NotBlank
    private String userId;


    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;


    @NotBlank
    @Size(max = 120)
    private String email;

    @NotBlank
    private int userType;

    private String imageUrl;

    private String organizationCode;

    private String dashboardCode; // 0 = admin, 1 = user

    private String bio;

    private String referenceId;


    @JsonIgnore
    private String qrCodeSecret;
    @Column(columnDefinition = "text")
    private String qrCodeImageUri;

    private Integer loginAttempts;
    private LocalDateTime lastLogin;
    private boolean enabled;
    private boolean mfa;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "USERS_ROLES", joinColumns = @JoinColumn(name = "id"),    inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<User> roles = new HashSet<>();  // ADMIN, USER, READER, EDITOR, DEVELOPER


    // UserDetailsCommandLineRunner
    public User(long id, String userId,  String lastname, String firstName, int userType, String organizationCode, String email, String imageUrl, String dashboardCode,  Boolean accountNonExpired, Boolean accountNonLocked) {

        this.id = id;
        this.userId = Integer.parseInt(userId);
        this.lastName = lastname;
        this.firstName = firstName;
        this.userType = userType;
        this.organizationCode = organizationCode;
        this.email = email;
        this.imageUrl = imageUrl;
        this.dashboardCode = dashboardCode;
        this.accountNonExpired = accountNonExpired;
        this.contactType = contactType;
    }

    // overloaded for getUsersByCArs() call to DB
//    public User(int userId, String username) {
//        super();
//        this.userId = userId;
//        this.username = username;
//    }

    public User(String email, String password) {
        super();
        this.email = email;
        this.password = password;
    }

    // overloaded for OFFER/ Groups must be multi-purpose
    public User(int userId, String username, String password, int userType) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }


    //	 overloaded WITHOUT userId  FOR Creating TO ORACLE DB  FOR ORACLE DB INSERTION/RETRIEVAL
    public User(String username, String password, String lastName, String firstName,
                 int userType, String organizationCode,String email,  String imageUrl, String dashboardCode,
                int isActive,
                int contactType ) {
        super();
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.organizationCode = organizationCode;
        this.email = email;
        this.imageUrl = imageUrl;
        this.dashboardCode = dashboardCode;
        this.isActive = isActive;
        this.contactType = contactType;

    }

    public User(int userId, String username, String password) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

//     Contstructor for EDIT PROFILE (options available for user)
public User(  String password, String lastName, String firstName, int userType, String organizationCode,String email,  String imageUrl, String dashboardCode,   int isActive,
            int contactType // ContactType contactType
          ) {
    super();

    this.password = password;
    this.lastName = lastName;
    this.firstName = firstName;
    this.userType = userType;
    this.email = email;
    this.organizationCode = organizationCode;
    this.imageUrl = imageUrl;
    this.dashboardCode = dashboardCode;
    this.isActive = isActive;
    this.contactType = contactType;

}



    public void registerThis(String un, String pw, String ln, String fn) {
        this.username = un;
        this.password = pw;
        this.lastName = ln;
        this.firstName = fn;
    }
}
