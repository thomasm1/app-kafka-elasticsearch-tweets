package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto saveEmployee(EmployeeDto employeeDto);

    APIResponseDto getEmployeeById(Long employeeId);
}
