package app.mapl.dto;

import app.mapl.models.Address;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto  implements Serializable {


    private int userId; // userId
    private String username;
    private String lastName; // lastName
    private String firstName; // firstName
    private String organizationCode;

    private String dashboardCode; // usergroup
    private String cusUrl; // usergroup
    private int userType;
    private String email;
    private int contactType;
    private int isActive;


    private String id; // id

    private List<Address> addresses ;

    public String getPassword() {
        return username; // for/admin
    }
}
