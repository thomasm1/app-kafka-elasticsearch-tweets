package app.mapl.mapper;

import app.mapl.models.auth.CredentialEntity;
import app.mapl.models.auth.RoleEntity;
import app.mapl.models.auth.User;
import app.mapl.models.auth.UserRequest;
import app.mapl.models.auth.UserResponse;
import app.mapl.models.dto.UserDto;
import org.mapstruct.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toUser(UserDto userDto);  // REQUEST FROM UI

    UserDto toDto(User user); // RESPONSE TO UI

    User userRequestToUser(UserRequest userRequest); // REQUEST FROM UI


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userResponse, @MappingTarget User user);

    default UserResponse userToUserResponse(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserId(user.getUserId());
        userResponse.setEmail(user.getEmail());
        userResponse.setFirstName(user.getFirstName());
        userResponse.setLastName(user.getLastName());
        userResponse.setUserType(user.getUserType());
        userResponse.setBio(user.getBio());
        userResponse.setPhone(user.getPhone());
        userResponse.setAuthenticated(user.isAuthenticated());
        userResponse.setOrganizationCode(user.getOrganizationCode());
        userResponse.setDashboardCode(user.getDashboardCode());
        userResponse.setRoles((Set<RoleEntity>) new ArrayList<RoleEntity>((Collection<? extends RoleEntity>) user.getRole()));
        return userResponse;
    };

}