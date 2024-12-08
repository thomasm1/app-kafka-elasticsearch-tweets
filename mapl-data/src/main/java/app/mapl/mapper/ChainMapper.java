package app.mapl.mapper;

import app.mapl.models.dto.ChainDto;
import app.mapl.models.Chain;
import org.mapstruct.*;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChainMapper {
    Chain toEntity(ChainDto chainDto);
    ChainDto toOneDto( Chain chain);






//    ChainDto toDto(List<Chain> chain);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Chain partialUpdate(ChainDto chainDto, @MappingTarget Chain chain);

    List<ChainDto> toListDto(List<Chain> allChains);

}
