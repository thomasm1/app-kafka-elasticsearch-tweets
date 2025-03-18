package xyz.cryptomaven.rest.mapper;

import org.mapstruct.*;
import xyz.cryptomaven.rest.models.Coin;
import xyz.cryptomaven.rest.models.dto.CoinDto;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING, uses = {NftMapper.class})
public interface CoinMapper {

  Set<Coin> toEntities(Set<CoinDto> coinDto);
  Coin toEntity(CoinDto coinDto);

  @AfterMapping
  default void linkNfts(@MappingTarget Coin coin) {
    coin.getNfts().forEach(nft -> nft.setCoin(coin));
  }

  CoinDto toDto(Coin coin);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Coin partialUpdate(CoinDto coinDto, @MappingTarget Coin coin);
}
