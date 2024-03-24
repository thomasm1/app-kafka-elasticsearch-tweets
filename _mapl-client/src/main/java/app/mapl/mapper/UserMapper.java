package app.mapl.mapper;

import app.mapl.dto.UserDto;
import app.mapl.models.User;
import org.mapstruct.*;


public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}