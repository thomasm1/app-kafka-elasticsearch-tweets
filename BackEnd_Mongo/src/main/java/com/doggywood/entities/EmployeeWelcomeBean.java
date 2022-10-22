package com.doggywood.entities;

public class EmployeeWelcomeBean {

	private String message;
	
	public EmployeeWelcomeBean(String message) {
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
