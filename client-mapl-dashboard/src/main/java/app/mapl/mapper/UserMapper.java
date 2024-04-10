package app.mapl.mapper;

import app.mapl.dto.UserDto;
import app.mapl.dto.UserEntityDto;
import app.mapl.models.User;
import app.mapl.models.UserEntity;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface UserMapper {
    User toEntity(UserDto userDto);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);

    UserEntity toUserEntity(UserEntityDto uerEntityDto);
}