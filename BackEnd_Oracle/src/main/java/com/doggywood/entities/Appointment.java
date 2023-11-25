package com.doggywood.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Appointment {

	@Id
	@GeneratedValue
	@Column(name = "a_id")
	int id;
	
	@Column(name = "c_id")
	int custId;
	
	@Column(name = "p_id")
	int nftId;
	
	@Column(name = "e_id")
	int empId;
	
	@Column(name = "a_date")
	String date;
	
	int weight;
	
	@Column(name = "time_slot")
	int timeSlot;
	
	@Column(name = "a_description")
	String description;

	public Appointment() {
		super();
	}

	public Appointment(int id, int custId, int nftId, int empId, String date, int weight, int timeSlot,
			String description) {
		super();
		this.id = id;
		this.custId = custId;
		this.nftId = nftId;
		this.empId = empId;
		this.date = date;
		this.weight = weight;
		this.timeSlot = timeSlot;
		this.description = description;
	}

	public Appointment(int custId, int nftId, int empId, String date, int weight, int timeSlot, String description) {
		super();
		this.custId = custId;
		this.nftId = nftId;
		this.empId = empId;
		this.date = date;
		this.weight = weight;
		this.timeSlot = timeSlot;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

	public int getNftId() {
		return nftId;
	}

	public void setNftId(int nftId) {
		this.nftId = nftId;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getTimeSlot() {
		return timeSlot;
	}

	public void setTimeSlot(int timeSlot) {
		this.timeSlot = timeSlot;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", custId=" + custId + ", nftId=" + nftId + ", empId=" + empId + ", date="
				+ date + ", weight=" + weight + ", timeSlot=" + timeSlot + ", description=" + description + "]";
	}
}
