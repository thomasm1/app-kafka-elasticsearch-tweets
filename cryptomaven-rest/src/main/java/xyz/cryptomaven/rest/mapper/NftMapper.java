package xyz.cryptomaven.rest.mapper;

import org.mapstruct.*;
import xyz.cryptomaven.rest.models.NftCoin;
import xyz.cryptomaven.rest.models.dto.NftCoinDto;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface NftMapper {
    NftCoin toEntity(NftCoinDto nftCoinDto);

    NftCoinDto toDto(NftCoin coin);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    NftCoin partialUpdate(NftCoinDto nftCoinDto, @MappingTarget NftCoin coin);
}
