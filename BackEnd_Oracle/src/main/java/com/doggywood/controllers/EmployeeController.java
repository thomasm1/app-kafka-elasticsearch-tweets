package com.doggywood.controllers;

import java.util.List;

import com.doggywood.dto.APIResponseDto;
import com.doggywood.dto.EmployeeDto;
import com.doggywood.entities.Employee;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.doggywood.services.EmployeeService;

@CrossOrigin(origins = "*")
@RestController
public class EmployeeController {
	private EmployeeService es;

	// Build Save EmployeeDto REST API
	@PostMapping
	public ResponseEntity<EmployeeDto> saveEmployee(@RequestBody EmployeeDto employeeDto){
		EmployeeDto savedEmployee = es.createEmployee(employeeDto);
		return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
	}

	// Build Get EmployeeDto REST API
	@GetMapping("{id}")
	public ResponseEntity<APIResponseDto> getEmployee(@PathVariable("id") Integer employeeId){
		APIResponseDto apiResponseDto = es.getEmployeeById(employeeId);
		return new ResponseEntity<>(apiResponseDto, HttpStatus.OK);
	}
	@RequestMapping(value = "/employees", method = RequestMethod.POST, consumes = "application/json")
	public Employee createEmployee(@RequestBody Employee employee) {
		return es.saveEmployee(employee);
	}

	@GetMapping(value = "/employees/{id}")
	public APIResponseDto getEmployeeById(@PathVariable("id") int id) {

		 APIResponseDto resp =  new APIResponseDto();
		 resp.setEmployee(es.getEmployeeById(id).getEmployee());
		 resp.setDashboard(es.getDashboardByEmployeeId(id));
		return resp;
	}

	@GetMapping(value = "/employees")
	public List<Employee> getAllEmployees() {
		return es.getAllEmployees();
	}

	@PutMapping(value = "/employees", consumes = "application/json")
	public Employee updatesEmployee(Employee change) {
		return es.updatesEmployee(change);
	}

	@DeleteMapping(value = "/employees/{id}")
	public boolean deleteEmployee(@PathVariable("id") int id) {
		try {
			EmployeeDto employeeDto = new EmployeeDto();
//			es.deleteEmployee(employeeDto.getEmployee()); // TDODO: fix this
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
