package net.cryptomaven.mappings.dto;

import lombok.Data;

@Data
public class UserDTO {

    private Long id;

    private int userId; //#1
    private String userName;
    private String lastName;
    private String firstName;


}
