package com.doggywood.repositories;

import com.doggywood.entities.Employee;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryTest {
    EmployeeRepository  employeeRepository;
    @BeforeEach
    void setUp() {
        employeeRepository.save(new Employee());
    }



    @AfterEach
    void tearDown() {
    }

    @Test
    void findByEmail() {

        Optional<Employee> employee = employeeRepository.findByEmail("thomasm1.maestas@gmail.com");
        assertEquals(true, employee.isPresent());
        assertEquals("thomas", employee.get().getFirstName());
    }

    @Test
    void findByEmailAndPassword() {
    }
}
