package net.ourdailytech.rest.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false, unique = true)
    private int userId;

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
    private int contactType; // ContactType contactType

    @Transient
    private String id;

    @ToString.Exclude  // ✅ Prevents infinite recursion
    @EqualsAndHashCode.Exclude // ✅ Avoids issues with hashCode()
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "userid"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id")
    )
    private Set<Role> roles = new HashSet<>();


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private Set<PostEntity> posts = new HashSet<>();


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
