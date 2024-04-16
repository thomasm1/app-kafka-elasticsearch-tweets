package app.mapl.mapper;

import app.mapl.dto.UserDto;
import app.mapl.dto.UserRequest;
import app.mapl.models.UserEntity;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {
    UserEntity toEntity(UserRequest userDto);

    UserRequest toDto(UserEntity user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserDto userDto, @MappingTarget UserEntity user);

    UserEntity toUserEntity(UserRequest uerEntityDto);
}