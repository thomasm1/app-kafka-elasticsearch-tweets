package com.doggywood.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class VaccRecord {

	@Id
	@GeneratedValue
	@Column(name = "R_ID")
	private int id;

	@Column(name = "P_ID")
	private int nftId; 
	
	@Column(name = "VNAME")
	private String vacName;
	
	@Column(name = "VTIME")
	private int vacTime; 
	
	@Column(name = "VDATE")
	private String vacDate;

	public VaccRecord(int id, int nftId, String vacName, int vacTime, String vacDate) {
		super();
		this.id = id;
		this.nftId = nftId;
		this.vacName = vacName;
		this.vacTime = vacTime;
		this.vacDate = vacDate;
	}

	public VaccRecord(int nftId, String vacName, int vacTime, String vacDate) {
		super();
		this.nftId = nftId;
		this.vacName = vacName;
		this.vacTime = vacTime;
		this.vacDate = vacDate;
	}

	public VaccRecord() {
		super();
	}

	@Override
	public String toString() {
		return "VaccRecord [id=" + id + ", nftId=" + nftId + ", vacName=" + vacName + ", vacTime=" + vacTime
				+ ", vacDate=" + vacDate + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNftId() {
		return nftId;
	}

	public void setNftId(int nftId) {
		this.nftId = nftId;
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
