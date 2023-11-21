package app.mapl.mapper;

import app.mapl.dto.NavigatorDto;
import app.mapl.models.Navigator;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface NavigatorMapper {
    Navigator toEntity(NavigatorDto navigatorDto);

    NavigatorDto toDto(Navigator navigator);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Navigator partialUpdate(NavigatorDto navigatorDto, @MappingTarget Navigator navigator);
}
