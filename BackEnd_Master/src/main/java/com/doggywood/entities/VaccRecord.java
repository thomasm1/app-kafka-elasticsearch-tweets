package com.doggywood.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class VaccRecord {

	@Id
	@GeneratedValue
	@Column(name = "R_ID")
	private int id;

	@Column(name = "P_ID")
	private int petId; 
	
	@Column(name = "VNAME")
	private String vacName;
	
	@Column(name = "VTIME")
	private int vacTime; 
	
	@Column(name = "VDATE")
	private String vacDate;

	public VaccRecord(int id, int petId, String vacName, int vacTime, String vacDate) {
		super();
		this.id = id;
		this.petId = petId;
		this.vacName = vacName;
		this.vacTime = vacTime;
		this.vacDate = vacDate;
	}

	public VaccRecord(int petId, String vacName, int vacTime, String vacDate) {
		super();
		this.petId = petId;
		this.vacName = vacName;
		this.vacTime = vacTime;
		this.vacDate = vacDate;
	}

	public VaccRecord() {
		super();
	}

	@Override
	public String toString() {
		return "VaccRecord [id=" + id + ", petId=" + petId + ", vacName=" + vacName + ", vacTime=" + vacTime
				+ ", vacDate=" + vacDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPetId() {
		return petId;
	}

	public void setPetId(int petId) {
		this.petId = petId;
	}

	public String getVacName() {
		return vacName;
	}

	public void setVacName(String vacName) {
		this.vacName = vacName;
	}

	public int getVacTime() {
		return vacTime;
	}

	public void setVacTime(int vacTime) {
		this.vacTime = vacTime;
	}

	public String getVacDate() {
		return vacDate;
	}

	public void setVacDate(String vacDate) {
		this.vacDate = vacDate;
	} 
	



}
