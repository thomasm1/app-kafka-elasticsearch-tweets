package xyz.cryptomaven.rest.mapper;

import org.mapstruct.*;
import xyz.cryptomaven.rest.models.Metadata;
import xyz.cryptomaven.rest.models.dto.MetadataDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MetadataMapper {
    Metadata toEntity(MetadataDto metadataDto);

    MetadataDto toDto(Metadata metadata);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Metadata partialUpdate(MetadataDto metadataDto, @MappingTarget Metadata metadata);
}
