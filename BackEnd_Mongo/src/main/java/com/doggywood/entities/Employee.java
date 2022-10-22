package com.doggywood.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {

	@Id
	@GeneratedValue
	@Column(name = "E_ID")
	private int id;
	
	@Column(name = "E_TYPE")
	private int eType;
	
	@Column(name = "FNAME")
	private String firstName;
	@Column(name = "LNAME")
	private String lastName;
	@Column(name = "PHONE")
	private String phone;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "PASS")
	private String password;
	public Employee(int id, int eType, String firstName, String lastName, String phone, String email, String password) {
		super();
		this.id = id;
		this.eType = eType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	public Employee(int eType, String firstName, String lastName, String phone, String email, String password) {
		super();
		this.eType = eType;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.password = password;
	}
	public Employee() {
		super();
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", eType=" + eType + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", phone=" + phone + ", email=" + email + ", password=" + password + "]";
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
