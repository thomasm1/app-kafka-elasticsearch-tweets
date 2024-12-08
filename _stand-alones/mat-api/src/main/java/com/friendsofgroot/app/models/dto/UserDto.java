package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.Role;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Schema(
        description = "User profile information Data Transfer Object"
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserDto  implements Serializable {

    static final long serialVersionUID = 1L;

    private int userId; // userId;
    @Schema(description = "User First Name")
    @NotEmpty(message = "User last name should not be null or empty")
    private String username;
    private String password;
    private String lastName;
    @Schema(description = "User First Name")
    private String firstName;
    private int userType;
    private String phone;
    @Schema(description = "Username==email")
    @NotEmpty(message = "User email should not be null or empty")
    @Email(message = "Email address should be valid")
    private String email;
    private String cusUrl;

    private String photoPath;
    private int isActive;
    private int contactType;

    private Set<Role> roles;

    //  uni-directional many-to-many relationships
    // private List<AddressDto> addresses;
    // private List<ChainDto> chains;


}
