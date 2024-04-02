package app.mapl.mapper;

import app.mapl.dto.UserDto;
import app.mapl.dto.UserProfileDto;
import app.mapl.models.User;
import app.mapl.models.UserProfile;
import org.mapstruct.*;


@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserProfileMapper {
    UserProfile toEntity(UserProfileDto userDto);

    UserProfileDto toDto(UserProfile user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    UserProfile partialUpdate(UserDto userDto, @MappingTarget UserProfile user);

    UserProfile toUserProfile(UserProfileDto userProfileDto);
}