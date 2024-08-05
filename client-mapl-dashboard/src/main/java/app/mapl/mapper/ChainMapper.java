package app.mapl.mapper;

import app.mapl.dto.ChainDto;
import app.mapl.models.Chain;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChainMapper {
    Chain toEntity(ChainDto chainDto);
    ChainDto toOneDto( Chain chain);
//    ChainDto toDto(List<Chain> chain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chain partialUpdate(ChainDto chainDto, @MappingTarget Chain chain);
}