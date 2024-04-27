package app.mapl.mapper;

import app.mapl.models.auth.User;
import app.mapl.models.dto.UserDto;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toUser(UserDto userDto);  // REQUEST FROM UI

    UserDto toDto(User user); // RESPONSE TO UI

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userResponse, @MappingTarget User user);

}