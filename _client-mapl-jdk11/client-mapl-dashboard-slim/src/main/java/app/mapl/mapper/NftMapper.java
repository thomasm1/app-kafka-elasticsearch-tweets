package app.mapl.mapper;

import app.mapl.models.Nft;
import app.mapl.models.dto.NftDto;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NftMapper {
    Nft toEntity(NftDto nftDto);

    NftDto toDto(Nft nft);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Nft partialUpdate(NftDto nftDto, @MappingTarget Nft nft);
}