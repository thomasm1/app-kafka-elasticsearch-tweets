package app.mapl.models;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;


@Data
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
@Table(name = "USERS")
public class User {

    @Id
//    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
//    @SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="USERID", nullable = false, unique = true)
    private int userId;

    @Column(name="USERNAME", nullable = false )
    private String username;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="LASTNAME")
    private String lastName;

    @Column(name="FIRSTNAME")
    private String firstName;
    @Transient
    private int groups;
    @Column(name="USERTYPE")
    private int userType;
    @Column(name="EMAIL", nullable = false )
    private String email;
    @Column(name="ORGANIZATIONCODE")
    private String organizationCode;

    @Column(name="CUSURL")
    private String cusUrl;

    @Transient
    private String photoPath;

    @Column(name="DASHBOARDCODE")
    private String dashboardCode;
    @Column(name="ISACTIVE")
    private int isActive;

    @Column(name="CONTACTTYPE")
    private int contactType; // ContactType contactType
    @Transient
    private String id;

    // parent of many
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Address> addresses;

//    @ManyToMany(fetch = FetchType.EAGER)
//   @JoinTable(name = "USERS_ROLE", joinColumns = @JoinColumn(name = "userid"), inverseJoinColumns = @JoinColumn(name = "role_id"))
//    private List<Role> roles = new ArrayList<>();
////
    public User(int userid, String username, String password, String lastName, String firstName, int groups, int userType, String organizationCode, String email, String cusUrl, String photoPath, String dashboardCode, int isActive, int contactType, String id, List<Address> user) {
        super();

        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.groups = groups;
        this.email = email;
        this.organizationCode = organizationCode;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
        this.dashboardCode = dashboardCode;
        this.isActive = isActive;
        this.contactType = contactType;
        this.id = id;
    }


//    public void addRole(Role role){
//        if(!this.roles.contains(role)){
//            this.roles.add(role);
//        }
//
//        if(!role.getUsers().contains(this)){
//            role.getUsers().add(this);
//        }
//    }
//
//    public void removeRole(Role role){
//        this.roles.remove(role);
//        role.getUsers().remove(this);
//    }


    //////////////////////////////////////
    // overloaded for getUsersByCArs() call to DB
    public User(int userId, String username) {
        super();
        this.userId = userId;
        this.username = username;
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    // overloaded for OFFER/ Groups must be multi-purpose
    public User(int userId, String username, String password, int groups, int userType) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
        this.groups = groups;
    }


    //	 overloaded WITHOUT userId  FOR Creating TO ORACLE DB  FOR ORACLE DB INSERTION/RETRIEVAL
    public User(String username, String password, String lastName, String firstName,
                int groups, int userType, String organizationCode,String email,  String cusUrl, String photoPath,
                String dashboardCode,
                int isActive,
                int contactType,
                String id) {
        super();
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.groups = groups;
        this.userType = userType;
        this.organizationCode = organizationCode;
        this.email = email;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
        this.dashboardCode = dashboardCode;
        this.isActive = isActive;
        this.contactType = contactType;
        this.id = id;
    }

    public User(int userId, String username, String password) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
    }

//     Contstructor for EDIT PROFILE (options available for user)
public User(  String password, String lastName, String firstName,
            int groups, int userType, String organizationCode,String email,  String cusUrl, String photoPath,
            String dashboardCode,
            int isActive,
            int contactType, // ContactType contactType
            String id) {
    super();

    this.password = password;
    this.lastName = lastName;
    this.firstName = firstName;
    this.userType = userType;
    this.groups = groups;
    this.email = email;
    this.organizationCode = organizationCode;
    this.cusUrl = cusUrl;
    this.photoPath = photoPath;
    this.dashboardCode = dashboardCode;
    this.isActive = isActive;
    this.contactType = contactType;
    this.id = id;
}

//    public void registerThis(String un, String pw, String ln, String fn) {
//        this.username = un;
//        this.password = pw;
//        this.lastName = ln;
//        this.firstName = fn;
//    }
}