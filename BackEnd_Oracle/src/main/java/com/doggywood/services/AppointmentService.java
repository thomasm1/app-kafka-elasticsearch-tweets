package com.doggywood.services;

import java.util.List;

import com.doggywood.entities.Appointment;

public interface AppointmentService {

	public Appointment createAppointment(Appointment a);
	public Appointment getAppointmentById(int id);
	public List<Appointment> getAllAppointments();
	public List<Appointment> getAppointmentsByCustId(int custId);
	public List<Appointment> getAppointmentsByPetId(int petId);
	public List<Appointment> getAppointmentsByEmpId(int empId);
	public List<Appointment> getAppointmentsDate(String date);
	public Appointment updateAppointment(Appointment a);
	public boolean deleteAppointment(Appointment a);
}
