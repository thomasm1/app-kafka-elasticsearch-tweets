package app.mapl.mapper;

import app.mapl.models.User;
import app.mapl.models.dto.UserDto;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
//    @Mapping(  target = "username", expression = "java(user.getEmail().truncate(10))")
//    @Mapping(source = "id", target sss


    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);
}
