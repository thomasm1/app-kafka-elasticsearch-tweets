package app.mapl.dto;

import app.mapl.models.Address;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto  implements Serializable {

    @Id
    private int userId; // userId
    private String userName;
    private String lastName; // lastName
    private String firstName; // firstName
    private String photoPath;

    private String userGroup; // usergroup

    private String email;

    private String id; // id

    private List<Address> addresses ;

}
