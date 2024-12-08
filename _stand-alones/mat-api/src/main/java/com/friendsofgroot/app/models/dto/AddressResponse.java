package com.friendsofgroot.app.models.dto;

import com.friendsofgroot.app.models.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AddressResponse implements Serializable {
    static long serialVersionUID = 1L;

    private int id;

    private String email;
    private String chain;

    private String iconUrl;

    private String firstName;

    private String lastName;




}
