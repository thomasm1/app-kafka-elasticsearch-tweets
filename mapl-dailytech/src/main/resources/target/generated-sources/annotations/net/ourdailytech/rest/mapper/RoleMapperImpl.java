package net.ourdailytech.rest.mapper;

import javax.annotation.processing.Generated;
import net.ourdailytech.rest.models.Role;
import net.ourdailytech.rest.models.dto.RoleDto;
import net.ourdailytech.rest.models.dto.UserDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-07T17:33:49-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class RoleMapperImpl implements RoleMapper {

    @Override
    public Role toEntity(RoleDto roleDto1) {
        if ( roleDto1 == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( (long) roleDto1.getId() );
        role.name( roleDto1.getName() );

        return role.build();
    }

    @Override
    public RoleDto toDto(Role role) {
        if ( role == null ) {
            return null;
        }

        int id = 0;
        String name = null;

        if ( role.getId() != null ) {
            id = role.getId().intValue();
        }
        name = role.getName();

        UserDto user = null;

        RoleDto roleDto = new RoleDto( id, name, user );

        return roleDto;
    }

    @Override
    public Role partialUpdate(RoleDto roleDto1, Role role) {
        if ( roleDto1 == null ) {
            return role;
        }

        role.setId( (long) roleDto1.getId() );
        if ( roleDto1.getName() != null ) {
            role.setName( roleDto1.getName() );
        }

        return role;
    }
}
