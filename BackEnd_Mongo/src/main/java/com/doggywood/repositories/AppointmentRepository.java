package com.doggywood.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.doggywood.entities.Appointment;

@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {

	List<Appointment> findByCustId(int custId);
	List<Appointment> findByPetId(int petId);
	List<Appointment> findByEmpId(int empId);
	List<Appointment> findByDate(String date);
}
