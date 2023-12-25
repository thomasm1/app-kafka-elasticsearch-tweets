package app.mapl.service;

import app.mapl.dto.APIResponseDto;
import app.mapl.dto.DashboardDto;
import app.mapl.dto.EmployeeDto;
import app.mapl.dto.OrganizationDto;
import app.mapl.mapper.EmployeeMapper;
import app.mapl.models.Employee;
import app.mapl.repositories.EmployeeRepository;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.AllArgsConstructor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    private EmployeeRepository employeeRepository;

   // private RestTemplate restTemplate;
    private WebClient webClient;
    private APIClient apiClient;

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Employee saveDEmployee = employeeRepository.save(employee);

        EmployeeDto savedEmployeeDto = EmployeeMapper.mapToEmployeeDto(saveDEmployee);

        return savedEmployeeDto;
    }

    //@CircuitBreaker(name = "${spring.application.name}", fallbackMethod = "getDefaultDashboard")
    @Retry(name = "${spring.application.name}", fallbackMethod = "getDefaultDashboard")
    @Override
    public APIResponseDto getEmployeeById(Long employeeId) {

        LOGGER.info("inside getEmployeeById() method");
        Employee employee = employeeRepository.findById(employeeId).get();

//        ResponseEntity<DashboardDto> responseEntity = restTemplate.getForEntity("http://DASHBOARD-SERVICE/api/dashboards/" + employee.getDashboardCode(),
//                DashboardDto.class);
//
//        DashboardDto dashboardDto = responseEntity.getBody();

        DashboardDto dashboardDto = webClient.get()
                .uri("http://localhost:8080/api/dashboards/" + employee.getDashboardCode())
                .retrieve()
                .bodyToMono(DashboardDto.class)
                .block();

      //  DashboardDto dashboardDto = apiClient.getDashboard(employee.getDashboardCode());

        OrganizationDto organizationDto = webClient.get()
                .uri("http://localhost:8083/api/organizations/" + employee.getOrganizationCode())
                .retrieve()
                .bodyToMono(OrganizationDto.class)
                .block();

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDashboard(dashboardDto);
        apiResponseDto.setOrganization(organizationDto);
        return apiResponseDto;
    }

    public APIResponseDto getDefaultDashboard(Long employeeId, Exception exception) {

        LOGGER.info("inside getDefaultDashboard() method");

        Employee employee = employeeRepository.findById(employeeId).get();

        DashboardDto dashboardDto = new DashboardDto();
        dashboardDto.setDashboardName("R&D Dashboard");
        dashboardDto.setDashboardCode("RD001");
        dashboardDto.setDashboardDescription("Research and Development Dashboard");

        EmployeeDto employeeDto = EmployeeMapper.mapToEmployeeDto(employee);

        APIResponseDto apiResponseDto = new APIResponseDto();
        apiResponseDto.setEmployee(employeeDto);
        apiResponseDto.setDashboard(dashboardDto);
        return apiResponseDto;
    }
}
