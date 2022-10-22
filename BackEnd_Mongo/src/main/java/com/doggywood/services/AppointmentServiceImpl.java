package com.doggywood.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doggywood.entities.Appointment;
import com.doggywood.repositories.AppointmentRepository;

@Service
public class AppointmentServiceImpl implements AppointmentService {

	@Autowired
	AppointmentRepository ar;

	@Override
	public Appointment createAppointment(Appointment a) {
		return ar.save(a);
	}

	@Override
	public Appointment getAppointmentById(int id) {
		return ar.findById(id).get();
	}

	@Override
	public List<Appointment> getAllAppointments() {
		return (List<Appointment>) ar.findAll();
	}

	@Override
	public List<Appointment> getAppointmentsByCustId(int custId) {
		return ar.findByCustId(custId);
	}

	@Override
	public List<Appointment> getAppointmentsByPetId(int petId) {
		return ar.findByPetId(petId);
	}

	@Override
	public List<Appointment> getAppointmentsByEmpId(int empId) {
		return ar.findByEmpId(empId);
	}

	@Override
	public List<Appointment> getAppointmentsDate(String date) {
		return ar.findByDate(date);
	}

	@Override
	public Appointment updateAppointment(Appointment a) {
		return ar.save(a);
	}

	@Override
	public boolean deleteAppointment(Appointment a) {
		try {
			ar.delete(a);
			return true;
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
			return false;
		}
	}

}
