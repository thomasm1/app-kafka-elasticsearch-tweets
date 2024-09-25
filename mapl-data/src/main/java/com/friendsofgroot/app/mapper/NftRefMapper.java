package com.friendsofgroot.app.mapper;

import com.friendsofgroot.app.models.NftRef;
import com.friendsofgroot.app.models.dto.NftRefDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NftRefMapper {
    NftRef toEntity(NftRefDto nftRefDto);

    NftRefDto toDto(NftRef nftRef);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NftRef partialUpdate(NftRefDto nftRefDto, @MappingTarget NftRef nftRef);
}
