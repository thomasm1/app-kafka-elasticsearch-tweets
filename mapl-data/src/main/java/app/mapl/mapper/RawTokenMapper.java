package app.mapl.mapper;

import app.mapl.models.dto.RawTokenDto;
import app.mapl.models.RawToken;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface RawTokenMapper {
    RawToken toEntity(RawTokenDto rawTokenDto);

    RawTokenDto toDto(RawToken rawToken);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    RawToken partialUpdate(RawTokenDto rawTokenDto, @MappingTarget RawToken rawToken);
}
