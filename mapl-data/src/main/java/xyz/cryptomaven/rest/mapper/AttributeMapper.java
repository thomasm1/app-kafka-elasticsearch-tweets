package xyz.cryptomaven.rest.mapper;

import org.mapstruct.*;
import xyz.cryptomaven.rest.models.Attribute;
import xyz.cryptomaven.rest.models.dto.AttributeDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {MetadataMapper.class})
public interface AttributeMapper {
    Attribute toEntity(AttributeDto attributeDto);

    AttributeDto toDto(Attribute attribute);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Attribute partialUpdate(AttributeDto attributeDto, @MappingTarget Attribute attribute);

    Attribute toEntity1(AttributeDto attributeDto);
}
