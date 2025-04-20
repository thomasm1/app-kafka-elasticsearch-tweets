package xyz.cryptomaven.rest.models.dto;

import xyz.cryptomaven.rest.models.User;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class AddressResponse implements Serializable {
    static long serialVersionUID = 1L;

    private Long id;

    private String email;
    private String chain;

    private String iconUrl;

    private String firstName;

    private String lastName;




}
