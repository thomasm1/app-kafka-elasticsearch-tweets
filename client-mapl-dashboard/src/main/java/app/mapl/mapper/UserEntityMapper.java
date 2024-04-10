package app.mapl.mapper;

import app.mapl.dto.UserDto;
import app.mapl.dto.UserEntityDto;
import app.mapl.models.UserEntity;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserEntityMapper {
    UserEntity toEntity(UserEntityDto userDto);

    UserEntityDto toDto(UserEntity user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserEntity partialUpdate(UserDto userDto, @MappingTarget UserEntity user);

    UserEntity toUserEntity(UserEntityDto uerEntityDto);
}