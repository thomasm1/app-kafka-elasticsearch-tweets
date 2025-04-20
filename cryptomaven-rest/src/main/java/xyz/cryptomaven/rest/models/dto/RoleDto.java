package xyz.cryptomaven.rest.models.dto;

import lombok.*;

import java.io.Serializable;

/**
 * DTO for {@link  rest.models.Role}
 */

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class RoleDto implements Serializable {
    int id;
    String name;
    UserDto user;
}
