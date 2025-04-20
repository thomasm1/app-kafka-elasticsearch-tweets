package xyz.cryptomaven.rest.mapper;

import org.mapstruct.*;
import xyz.cryptomaven.rest.models.Role;
import xyz.cryptomaven.rest.models.dto.RoleDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {
    Role toEntity(RoleDto roleDto1);

    RoleDto toDto(Role role);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Role partialUpdate(RoleDto roleDto1, @MappingTarget Role role);
}
