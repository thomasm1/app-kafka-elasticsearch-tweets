package app.mapl.mapper;

import app.mapl.dto.DashboardDto;
import app.mapl.models.Dashboard;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DashboardMapper {
    Dashboard toEntity(DashboardDto dashboardDto);

    DashboardDto toDto(Dashboard dashboard);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Dashboard partialUpdate(DashboardDto dashboardDto, @MappingTarget Dashboard dashboard);
}
