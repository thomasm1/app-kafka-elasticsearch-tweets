package com.doggywood.entities;

public class CustomerKeysBean {

	private String message;
	
	public CustomerKeysBean(String message) {
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
		return String.format("Welcome to Doggywood [message=%s]", message);
	}
}
