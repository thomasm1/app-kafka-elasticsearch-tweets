package com.doggywood.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doggywood.entities.Employee;

/**
 * EmployeeRepository extends CrudRepository and provides the methods for
 * creating, reading, updating, and deleting employees. It also provides
 * methods for finding employees by email and email and password.
 */
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

	Optional<Employee> findByEmail(String email);
	Optional<Employee> findByEmailAndPassword(String email, String password);


}
