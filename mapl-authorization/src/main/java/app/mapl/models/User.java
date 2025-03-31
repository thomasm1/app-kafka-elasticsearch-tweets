package app.mapl.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Document(collection = "users")
public class User {

    @Field(name = "userid" )
    private int userId;

    @Field(name = "username")
    private String username;

    @Field(name = "password")
    private String password;

    @Field(name = "lastname")
    private String lastName;

    @Field(name = "firstname")
    private String firstName;

    @Field(name = "usertype")
    private int userType;

    @Field(name = "email" )
    private String email;

    @Field(name = "organizationcode")
    private String organizationCode;

    @Field(name = "cusurl")
    private String cusUrl;

    @Field(name = "dashboardcode")
    private String dashboardCode;

    @Field(name = "isactive")
    private int isActive;

    @Field(name = "contacttype")
    private int contactType; // ContactType contactType

    private String id;

    @ToString.Exclude  // ✅ Prevents infinite recursion
    @EqualsAndHashCode.Exclude // ✅ Avoids issues with hashCode()
//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(
//            name = "users_roles",
//            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userid"),
//            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
//    )
    @DBRef
    private Set<Role> roles = new HashSet<>();




    // Constructor for full user creation
    public User(int userId, String username, String password, String lastName, String firstName, int userType,
                String organizationCode, String email, String cusUrl, String dashboardCode, int isActive, int contactType, String id) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.email = email;
        this.organizationCode = organizationCode;
        this.cusUrl = cusUrl;
        this.dashboardCode = dashboardCode;
        this.isActive = isActive;
        this.contactType = contactType;
        this.id = id;
    }

    // Constructor for minimal user data
    public User(int userId, String username) {
        this.userId = userId;
        this.username = username;
    }

    // Constructor for authentication
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Constructor for profile updates
    public User(String password, String lastName, String firstName, int userType, String organizationCode,
                String email, String cusUrl, String dashboardCode, int isActive, int contactType, String id) {
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.organizationCode = organizationCode;
        this.email = email;
        this.cusUrl = cusUrl;
        this.dashboardCode = dashboardCode;
        this.isActive = isActive;
        this.contactType = contactType;
        this.id = id;
    }
}
