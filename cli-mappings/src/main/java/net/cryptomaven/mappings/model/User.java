package net.cryptomaven.mappings.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {

//    private int userId; //#1
//    private String userName;
    private String password;
@Column(name = "last_name")
    private String lastName;
    @Column(name = "first_name")
    private String firstName;

//    private int groups;
//
////    @Column(name="user_type")
//    private int userType;
    private String email;
//    private String phone;
//    private String cusUrl;
//    private String photoPath;
//    private String userGroup;
//    private int isActive;
//    private int contactType; // ContactType contactType

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "location_id")
    private Location location;

//    private String id;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
