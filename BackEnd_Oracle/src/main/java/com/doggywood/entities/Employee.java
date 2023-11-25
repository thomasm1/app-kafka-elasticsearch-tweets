package com.doggywood.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "E_ID")
	private int id;

	@Column(name = "E_TYPE")
	private int eType;

	private String firstName;

	private String lastName;

	private String phone;
	@Column(nullable = false, unique = true)
	private String email;

	private String password;

	private String dashboardCode;

	public Employee(int eType, String firstName, String lastName, String phone, String email, String password, String dashboardCode) {
		super();
		this.eType = eType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.dashboardCode = dashboardCode;
	}
	public Employee() {
		super();
	}

	public Employee(int id, int eType, String firstName, String lastName, String phone, String email, String password, String dashboardCode) {
		this.id = id;
		this.eType = eType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
		this.dashboardCode = dashboardCode;
	}

	public Employee(int id, int eType, String firstName, String lastName, String email, String password, String dashboardCode) {
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", eType=" + eType + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", email=" + email + ", dashboardCode=" + dashboardCode + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int geteType() {
		return eType;
	}
	public void seteType(int eType) {
		this.eType = eType;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword()  {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDashboardCode() {
		return dashboardCode;
	}
	public void setDashboardCode(String dashboardCode) {
		this.dashboardCode = dashboardCode;
	}


}
