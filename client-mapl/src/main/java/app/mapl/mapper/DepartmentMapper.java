package app.mapl.mapper;

import app.mapl.dto.DepartmentDto;
import app.mapl.models.Department;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface DepartmentMapper {
    Department toEntity(DepartmentDto departmentDto);

    DepartmentDto toDto(Department department);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Department partialUpdate(DepartmentDto departmentDto, @MappingTarget Department department);
}
