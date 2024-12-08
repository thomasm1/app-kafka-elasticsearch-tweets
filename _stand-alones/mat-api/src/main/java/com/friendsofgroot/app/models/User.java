package com.friendsofgroot.app.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.*;




@NoArgsConstructor
@AllArgsConstructor
@Getter @Setter @ToString
@Builder
@Entity
@Table(name = "USERS")
public class User  implements Serializable{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_MAKER" )
    @SequenceGenerator(name = "ID_MAKER", sequenceName = "ID_MAKER", allocationSize = 1)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="userid", nullable = false, unique = true)
    private int userId;

    @Column(name="username" , unique = true )
    private String username;

    @NotBlank(message="*Must give password")
    @Size(min=2, max=120)
    @Column(name="password" )
    private String password;
    @Column(name="lastname")
    private String lastName;

    @Column(name="firstname")
    private String firstName;

    @Column(name="usertype") /// 0 = admin, 1 = user
    private int userType;

    @Column(name="phone")
    private String phone;

    @NotBlank
//    @Email(message="*Must be a valid email address")
    @Column(name="email", length = 255, unique = true)
    private String email;
    @Column(name="cusurl")
    private String cusUrl;

    @Column(name="photopath")
    private String photoPath;

    @Column(name="isactive")
    private int isActive;

    @Column(name="contacttype")
    private int contactType; // ContactType contactType

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USERS_ROLES",
            joinColumns = {@JoinColumn(name = "userid", referencedColumnName = "userid")},
            inverseJoinColumns = {@JoinColumn(name = "role_id", referencedColumnName = "id")}
    )
    private Set<Role> roles = new HashSet<>();


//    @OneToMany(fetch = FetchType.EAGER, mappedBy = "id"  , orphanRemoval = true)
//    private List<Address> addresses;

//    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.PERSIST},
//            fetch = FetchType.LAZY)
//    @JoinTable(name="CHAIN_USERS",
//            joinColumns=@JoinColumn(name="userid"),
//            inverseJoinColumns= @JoinColumn(name="chain_id")
//    )
//    @JsonIgnore
//    @ToString.Exclude
//    private List<Chain> chains = new ArrayList<>();


//    @Builder.Default
//    @OneToMany(mappedBy = "user")
//    @ToString.Exclude
//    private Set<ChainOrder> chainOrders = new HashSet<>();

    public User(int userid, String username, String password, String lastName, String firstName, int userType, String phone, String email, String cusUrl, String photoPath, int isActive, int contactType) {

        this.userId = userid;
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.phone = phone;
        this.email = email;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
        this.isActive = isActive;
        this.contactType = contactType;
    }

    ////////////////////

    public boolean setRole(String admin) {
        this.userType = 9;
        return true;
    }
    public void addRole(Role role){
        this.roles.add(role);
//
//        if(!role.getUsers().contains(this)){
//            role.getUsers().add(this);
//        }
    }

    public void removeRole(Role role){
        this.roles.remove(role);
//        role.getUsers().remove(this);
    }


    ///////////////////////////
    public User(int userid, String username, String password, String lastName, String firstName, int userType, String phone, String email, String cusUrl, String photoPath,   int isActive, int contactType,   List<Address> user) {
        super();

        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.email = email;
        this.phone = phone;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
        this.isActive = isActive;
        this.contactType = contactType;

    }


//
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
    public User(int userId, String username, String password, int userType) {
        super();
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.userType = userType;
    }


    //	 overloaded WITHOUT userId  FOR Creating TO ORACLE DB  FOR ORACLE DB INSERTION/RETRIEVAL
    public User(String username, String password, String lastName, String firstName,
                 int userType, String phone,String email,  String cusUrl, String photoPath,
                int isActive,
                int contactType ) {
        super();
        this.username = username;
        this.password = password;
        this.lastName = lastName;
        this.firstName = firstName;
        this.userType = userType;
        this.phone = phone;
        this.email = email;
        this.cusUrl = cusUrl;
        this.photoPath = photoPath;
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
public User(  String password, String lastName, String firstName, int userType, String phone,String email,  String cusUrl, String photoPath,   int isActive,
            int contactType // ContactType contactType
          ) {
    super();

    this.password = password;
    this.lastName = lastName;
    this.firstName = firstName;
    this.userType = userType;
    this.email = email;
    this.phone = phone;
    this.cusUrl = cusUrl;
    this.photoPath = photoPath;
    this.isActive = isActive;
    this.contactType = contactType;

}



//    public void registerThis(String un, String pw, String ln, String fn) {
//        this.username = un;
//        this.password = pw;
//        this.lastName = ln;
//        this.firstName = fn;
//    }
}
