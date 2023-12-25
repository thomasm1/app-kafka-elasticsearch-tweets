package app.mapl.dto;

import app.mapl.models.Navigator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class APIResponseDto {
    private EmployeeDto employee;
    private NavigatorDto navigator;
    private DashboardDto dashboard;
    private OrganizationDto organization;
}
