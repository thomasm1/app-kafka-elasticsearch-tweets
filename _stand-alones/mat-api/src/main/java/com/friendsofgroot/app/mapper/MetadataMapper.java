package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.models.Metadata;
import com.friendsofgroot.app.models.dto.MetadataDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface MetadataMapper {
    Metadata toEntity(MetadataDto metadataDto);

    MetadataDto toDto(Metadata metadata);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Metadata partialUpdate(MetadataDto metadataDto, @MappingTarget Metadata metadata);
}
