package com.doggywood.services;

import java.util.List;

import com.doggywood.dto.APIResponseDto;
import com.doggywood.dto.DashboardDto;
import com.doggywood.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.doggywood.entities.Employee;
import com.doggywood.repositories.EmployeeRepository;
import org.springframework.web.client.RestTemplate;


@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

	static final String HTTP_ = "http://";
	static final String HOST_ = "localhost";
	static final String PORT_ = ":8080";
	static final String PATH_ = "/api/dashboards/";

	private RestTemplate restTemplate;
//    private WebClient webClient;
//    private APIClient apiClient;

	@Autowired
	EmployeeRepository er;

	/**
	 * @param employee
	 * @return
	 */
	@Override
	public Employee saveEmployee(Employee employee) {
		return null;
	}

	/**
	 * @param employeeDto
	 * @return EmployeeDto
	 */
	@Override
	public EmployeeDto createEmployee(EmployeeDto employeeDto) {

		Employee employee = new Employee(
				employeeDto.getId(),
				employeeDto.getEType(),
				employeeDto.getFirstName(),
				employeeDto.getLastName(),
				employeeDto.getPhone(),
				employeeDto.getEmail(),
				employeeDto.getPassword(),
				employeeDto.getDashboardCode(),
				employeeDto.getOrganizationCode()
		);
		Employee saveDEmployee = er.save(employee);

		EmployeeDto savedEmployeeDto = new EmployeeDto(
				saveDEmployee.getId(),
				saveDEmployee.geteType(),
				saveDEmployee.getFirstName(),
				saveDEmployee.getLastName(),
				saveDEmployee.getPhone(),
				saveDEmployee.getEmail(),
				saveDEmployee.getPassword(),
				saveDEmployee.getDashboardCode()
		);

		return savedEmployeeDto;
	}

//	@Override
//	public APIResponseDto getEmployeeById(int  eId) {
//
//		Employee employee = er.findById(eId).get();
//
//        ResponseEntity<DashboardDto> responseEntity = restTemplate.getForEntity("http://localhost:8080/api/dashboards/" + employee.getDashboardCode(),
//                DashboardDto.class);
//
//        DashboardDto dashboardDto = responseEntity.getBody();
//
////        DashboardDto dashboardDto = webClient.get()
////                .uri("http://localhost:8080/api/dashboards/" + employee.getDashboardCode())
////                .retrieve()
////                .bodyToMono(DashboardDto.class)
////                .block();
////
////        DashboardDto dashboardDto = apiClient.getDashboard(employee.getDashboardCode());
//
//		EmployeeDto employeeDto = new EmployeeDto(
//				employee.getId(),
//				employee.geteType(),
//				employee.getFirstName(),
//				employee.getLastName(),
//				employee.getPhone(),
//				employee.getEmail(),
//				employee.getPassword(),
//				employee.getDashboardCode()
//		);
//
//		APIResponseDto apiResponseDto = new APIResponseDto();
//		apiResponseDto.setEmployee(employeeDto);
//		apiResponseDto.setDashboard(dashboardDto);
//
//		return apiResponseDto;
//	}

	@Override
	public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
		return null;
	}

	/**
	 * @param eId
	 * @return
	 */
	@Override
	public APIResponseDto getEmployeeById(Integer eId) {
		return null;
	}

	@Override
	public Employee getEmployeeByEmail(String email) {
	try {
		return er.findByEmail(email).get();
	} catch (Exception e) {
	return null;
	}
	}

//	@Override
//	public Object getEmployeeByEmailAndPassword(String email, String password) {
//		return er.findByEmailAndPassword(email).get();
//	}

	@Override
	public List<Employee> getAllEmployees() {
		return (List<Employee>) er.findAll();
	}

	@Override
	public Employee updatesEmployee(Employee change) {
		return er.save(change);
	}

	@Override
	public boolean deleteEmployee(Employee employee) {
		try {
			er.delete(employee);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public Employee getEmployeeByEmailAndPassword(String email, String password) {
		return er.findByEmailAndPassword(email, password).get();
	}

	/**
	 * @param id
	 * @return
	 */
	@Override
	public DashboardDto getDashboardByEmployeeId(int id) {
		return null;
	}


}
