package com.infybuzz.request;

import java.util.List;

public class CreateStudentRequest {

	private String name;

	private Integer birthYear;

	private String country;

	private List<CreateSubjectRequest> subjectList;

	private CreateDepartmentRequest department;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getBirthYear() {
		return birthYear;
	}

	public void setBirthYear(Integer birthYear) {
		this.birthYear = birthYear;
	}

	public List<CreateSubjectRequest> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<CreateSubjectRequest> subjectList) {
		this.subjectList = subjectList;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public CreateDepartmentRequest getDepartment() {
		return department;
	}

	public void setDepartment(CreateDepartmentRequest department) {
		this.department = department;
	}

}
