package app.mapl.mapper;

import app.mapl.models.Metadata;
import app.mapl.models.dto.MetadataDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MetadataMapper {
    Metadata toEntity(MetadataDto metadataDto);

    MetadataDto toDto(Metadata metadata);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Metadata partialUpdate(MetadataDto metadataDto, @MappingTarget Metadata metadata);
}
