package com.doggywood.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.doggywood.entities.Appointment;
import com.doggywood.services.AppointmentService;

@CrossOrigin(origins = "*")
@RestController
public class AppointmentController {

	@Autowired
	AppointmentService as;

	// create
	@PostMapping(value = "/appointments", consumes = "application/json")
	public Appointment createAppointment(@RequestBody Appointment a) {
		return as.createAppointment(a);
	}

	// get all
	@GetMapping(value = "/appointments")
	public List<Appointment> getAllAppointments() {
		return as.getAllAppointments();
	}

	// get by id
	@GetMapping(value = "/appointments/{id}")
	public Appointment getAppointmentById(@PathVariable("id") int id) {
		return as.getAppointmentById(id);
	}

	// appointments by customer
	@GetMapping(value = "customers/{id}/appointments")
	public List<Appointment> getAppointmentsByCustId(@PathVariable("id") int custId) {
		return as.getAppointmentsByCustId(custId);
	}

	// appointments by pet
	@GetMapping(value = "pets/{id}/appointments")
	public List<Appointment> getAppointmentsByPetId(@PathVariable("id") int petId) {
		return as.getAppointmentsByPetId(petId);
	}

	// appointments by employee
	@GetMapping(value = "employees/{id}/appointments")
	public List<Appointment> getAppointmentsByEmpId(@PathVariable("id") int empId) {
		return as.getAppointmentsByEmpId(empId);
	}

	// appointments by date. it will probably not be used
//	@GetMapping(value = "appoinmentsByDateTemp/{date}")
//	public List<Appointment> getAppointmentsDate(String date) {
//		return as.getAppointmentsDate(date);
//	}

	// update
	@PutMapping(value = "/appointments", consumes = "application/json")
	public Appointment updateAppointment(@RequestBody Appointment a) {
		return as.updateAppointment(a);
	}

	// delete
	@DeleteMapping(value = "/appointments/{id}")
	public boolean deleteAppointment(@PathVariable("id") int id) {
		return as.deleteAppointment(as.getAppointmentById(id));
	}
}
