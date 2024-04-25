package app.mapl.mapper;

import app.mapl.models.auth.UserResponse;
import app.mapl.models.auth.UserRequest;
import app.mapl.models.auth.User;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toUser(UserRequest userDto);  // REQUEST FROM UI

    UserResponse toDto(User user); // RESPONSE TO UI

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserResponse userResponse, @MappingTarget User user);

}