package app.mapl.mapper;

import app.mapl.dto.UserDto;
import app.mapl.models.User;
import app.mapl.models.UserEntity;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)

public interface UserMapper {
    User toEntity(UserDto userDto); // soon to be deprecated TODO

    UserDto toDto(User user); // soon to be deprecated TODO

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDto, @MappingTarget User user);

}