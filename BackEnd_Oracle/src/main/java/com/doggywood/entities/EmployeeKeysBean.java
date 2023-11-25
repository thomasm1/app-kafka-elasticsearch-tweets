package com.doggywood.entities;

public class EmployeeKeysBean {

	private String message;
	
	public EmployeeKeysBean(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("Employee Logged into Doggywood [message=%s]", message);
	}
}
