package com.doggywood.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doggywood.entities.Employee;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Optional<Employee> findByEmail(String email); 
	Optional<Employee> findByEmailAndPassword(String email, String password);
 ;

}
