package net.ourdailytech.rest.mapper;

import java.util.LinkedHashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import net.ourdailytech.rest.models.Role;
import net.ourdailytech.rest.models.User;
import net.ourdailytech.rest.models.dto.RoleDto;
import net.ourdailytech.rest.models.dto.UserDto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-07T17:33:49-0500",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 17.0.10 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto userDto) {
        if ( userDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.userId( userDto.getUserId() );
        user.username( userDto.getUsername() );
        user.password( userDto.getPassword() );
        user.lastName( userDto.getLastName() );
        user.firstName( userDto.getFirstName() );
        user.userType( userDto.getUserType() );
        user.email( userDto.getEmail() );
        user.organizationCode( userDto.getOrganizationCode() );
        user.cusUrl( userDto.getCusUrl() );
        user.dashboardCode( userDto.getDashboardCode() );
        user.isActive( userDto.getIsActive() );
        user.contactType( userDto.getContactType() );
        user.id( userDto.getId() );
        user.roles( roleDtoSetToRoleSet( userDto.getRoles() ) );

        return user.build();
    }

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.userId( user.getUserId() );
        userDto.username( user.getUsername() );
        userDto.lastName( user.getLastName() );
        userDto.firstName( user.getFirstName() );
        userDto.organizationCode( user.getOrganizationCode() );
        userDto.dashboardCode( user.getDashboardCode() );
        userDto.cusUrl( user.getCusUrl() );
        userDto.userType( user.getUserType() );
        userDto.email( user.getEmail() );
        userDto.contactType( user.getContactType() );
        userDto.isActive( user.getIsActive() );
        userDto.roles( roleSetToRoleDtoSet( user.getRoles() ) );
        userDto.id( user.getId() );

        return userDto.build();
    }

    @Override
    public User partialUpdate(UserDto userDto, User user) {
        if ( userDto == null ) {
            return user;
        }

        user.setUserId( userDto.getUserId() );
        if ( userDto.getUsername() != null ) {
            user.setUsername( userDto.getUsername() );
        }
        if ( userDto.getPassword() != null ) {
            user.setPassword( userDto.getPassword() );
        }
        if ( userDto.getLastName() != null ) {
            user.setLastName( userDto.getLastName() );
        }
        if ( userDto.getFirstName() != null ) {
            user.setFirstName( userDto.getFirstName() );
        }
        user.setUserType( userDto.getUserType() );
        if ( userDto.getEmail() != null ) {
            user.setEmail( userDto.getEmail() );
        }
        if ( userDto.getOrganizationCode() != null ) {
            user.setOrganizationCode( userDto.getOrganizationCode() );
        }
        if ( userDto.getCusUrl() != null ) {
            user.setCusUrl( userDto.getCusUrl() );
        }
        if ( userDto.getDashboardCode() != null ) {
            user.setDashboardCode( userDto.getDashboardCode() );
        }
        user.setIsActive( userDto.getIsActive() );
        user.setContactType( userDto.getContactType() );
        if ( userDto.getId() != null ) {
            user.setId( userDto.getId() );
        }
        if ( user.getRoles() != null ) {
            Set<Role> set = roleDtoSetToRoleSet( userDto.getRoles() );
            if ( set != null ) {
                user.getRoles().clear();
                user.getRoles().addAll( set );
            }
        }
        else {
            Set<Role> set = roleDtoSetToRoleSet( userDto.getRoles() );
            if ( set != null ) {
                user.setRoles( set );
            }
        }

        return user;
    }

    protected Role roleDtoToRole(RoleDto roleDto) {
        if ( roleDto == null ) {
            return null;
        }

        Role.RoleBuilder role = Role.builder();

        role.id( (long) roleDto.getId() );
        role.name( roleDto.getName() );

        return role.build();
    }

    protected Set<Role> roleDtoSetToRoleSet(Set<RoleDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<Role> set1 = new LinkedHashSet<Role>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( RoleDto roleDto : set ) {
            set1.add( roleDtoToRole( roleDto ) );
        }

        return set1;
    }

    protected RoleDto roleToRoleDto(Role role) {
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

    protected Set<RoleDto> roleSetToRoleDtoSet(Set<Role> set) {
        if ( set == null ) {
            return null;
        }

        Set<RoleDto> set1 = new LinkedHashSet<RoleDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Role role : set ) {
            set1.add( roleToRoleDto( role ) );
        }

        return set1;
    }
}
