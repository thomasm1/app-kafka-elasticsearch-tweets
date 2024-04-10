package app.mapl.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.data.convert.ValueConverter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;



@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Entity
@Table(name = "USERS")
public class User  implements Serializable{
    @Serial
    private static final long serialVersionUID = 1L;
    @Id
    private long id;

    private long createdBy;
    private long updatedBy;
    @NotBlank
    private String userId;

    private String password;
    @NotBlank
    private String firstName;

    @NotBlank
    private String lastName;


    @NotBlank
    @Size(max = 120)
    private String email;

    @NotBlank /*TODO Enum cardinal*/
    private int userType;

    private String imageUrl;

    private String organizationCode;

    private String dashboardCode; // 0 = admin, 1 = user

    private String bio;

    @Column(columnDefinition = "text")
    private String qrCodeImageUri;

    private LocalDateTime lastLogin;

    private Integer loginAttempts;

    private String createdAt;
    private String updatedAt;
    private String role;
    private String authorities;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private boolean mfa;

    // UserDetailsCommandLineRunner
    public User(long id, String userId,  String lastname, String firstName, int userType, String organizationCode, String email, String imageUrl, String dashboardCode,  Boolean accountNonExpired ) {
          super();
        this.userId =  userId ;
        this.lastName = lastname;
        this.firstName = firstName;
        this.userType = userType;
        this.organizationCode = organizationCode;
        this.email = email;
        this.imageUrl = imageUrl;
        this.dashboardCode = dashboardCode;
        this.accountNonExpired = accountNonExpired;
    }

    // overloaded for getUsersByCArs() call to DB
//    public User(int userId, String email) {
//        super();
//        this.userId = userId;
//        this.email = email;
//    }

    public User(String email, String password) {
        super();
        this.email = email;
//        this.password = password;
    }


    //	 overloaded WITHOUT userId  FOR Creating TO ORACLE DB  FOR ORACLE DB INSERTION/RETRIEVAL
    public User( String lastName, String firstName,
                 int userType, String organizationCode,String email,  String imageUrl, String dashboardCode
    ) {
        super();
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.organizationCode = organizationCode;
        this.email = email;
        this.imageUrl = imageUrl;
        this.dashboardCode = dashboardCode;


    }

    public User(int i, String s, String password, String lastNamedd, String firstname, int i1, String s1, String s2, String s3, String photopaath, int i2, int i3, Object o) {




    }

    public User(int i, String s, String password, String lastName, String firstName, int i1, String organizationCode, String s1, String cusUrl, String dashboardCode, int i2, int i3) {
    }

    public User(String value, String value1, String value2, String value3, int parseInt, String value4, String value5, String value6, String value7, int parseInt1, int parseInt2) {
    }


//    public User(int userId, String email, String password) {
//        super();
//        this.userId = userId;
//        this.email = email;
//        this.password = password;
//    }

//     Contstructor for EDIT PROFILE (options available for user)
//public User(  String password, String lastName, String firstName, int userType, String organizationCode,String email,  String imageUrl, String dashboardCode,   int isActive,
//            int contactType // ContactType contactType
//          ) {
//    super();
//
//    this.password = password;
//    this.lastName = lastName;
//    this.firstName = firstName;
//    this.userType = userType;
//    this.email = email;
//    this.organizationCode = organizationCode;
//    this.imageUrl = imageUrl;
//    this.dashboardCode = dashboardCode;
//    this.isActive = isActive;
//    this.contactType = contactType;
//
//}



//    public void registerThis(String un, String pw, String ln, String fn) {
//        this.email = un;
//        this.password = pw;
//        this.lastName = ln;
//        this.firstName = fn;
//    }
}
