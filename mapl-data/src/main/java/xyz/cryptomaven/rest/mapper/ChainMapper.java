package xyz.cryptomaven.rest.mapper;

import org.mapstruct.*;
import xyz.cryptomaven.rest.models.Chain;
import xyz.cryptomaven.rest.models.dto.ChainDto;

import java.util.Set;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChainMapper {
  Chain toEntity(ChainDto chainDto);

  ChainDto toOneDto(Chain chain);
//    ChainDto toDto(List<Chain> chain);

  @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
  Chain partialUpdate(ChainDto chainDto, @MappingTarget Chain chain);

    Set<Chain> toEntities(Set<ChainDto> chains);
}
