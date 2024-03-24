package app.mapl.mapper;

import app.mapl.dto.CoinDto;
import app.mapl.models.Coin;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface CoinMapper {
    Coin toEntity(CoinDto coinDto);

    CoinDto toDto(Coin coin);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Coin partialUpdate(CoinDto coinDto, @MappingTarget Coin coin);
}