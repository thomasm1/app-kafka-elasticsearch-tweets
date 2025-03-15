package net.ourdailytech.rest.models.dto;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link net.ourdailytech.rest.models.Role}
 */
@Value
public class RoleDto implements Serializable {
    int id;
    String name;
    UserDto user;
}