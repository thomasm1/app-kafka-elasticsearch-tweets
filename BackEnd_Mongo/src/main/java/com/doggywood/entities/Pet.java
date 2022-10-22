package com.doggywood.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Pet {

	@Id
	@GeneratedValue
	@Column(name = "P_ID")
	private int id;
	
	@Column(name = "C_ID")
	private int custId;
	
	@Column(name = "P_NAME")
	private String petName;
	
	@Column(name = "DOB")
	private String birthDate;
	
	@Column(name = "P_WEIGHT")
	private int weight;
	
	@Column(name = "P_COLOR")
	private String color;
	
	@Column(name = "P_TYPE")
	private int type;
	
	@Column(name = "P_BREED")
	private String breed;
	
	@Column(name = "NEUTER")
	private int neuter; 
	
	@Column(name = "P_DESCRIPTION")
	private String description;
	
	@Column(name = "PET_URL")
	private String petUrl;

	public Pet(int id, int custId, String petName, String birthDate, int weight, String color, int type, String breed,
			int neuter, String description, String petUrl) {
		super();
		this.id = id;
		this.custId = custId;
		this.petName = petName;
		this.birthDate = birthDate;
		this.weight = weight;
		this.color = color;
		this.type = type;
		this.breed = breed;
		this.neuter = neuter;
		this.description = description;
		this.petUrl = petUrl;
	}

	public Pet(int custId, String petName, String birthDate, int weight, String color, int type, String breed, int neuter,
			String description, String petUrl) {
		super();
		this.custId = custId;
		this.petName = petName;
		this.birthDate = birthDate;
		this.weight = weight;
		this.color = color;
		this.type = type;
		this.breed = breed;
		this.neuter = neuter;
		this.description = description;
		this.petUrl = petUrl;
	}

	public Pet() {
		super();
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", custId=" + custId + ", petName=" + petName + ", birthDate=" + birthDate + ", weight="
				+ weight + ", color=" + color + ", type=" + type + ", breed=" + breed + ", neuter=" + neuter
				+ ", description=" + description + ", petUrl=" + petUrl + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
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

	public String getPetName() {
		return petName;
	}

	public void setPetName(String petName) {
		this.petName = petName;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getNeuter() {
		return neuter;
	}

	public void setNeuter(int neuter) {
		this.neuter = neuter;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPetUrl() {
		return petUrl;
	}

	public void setPetUrl(String petUrl) {
		this.petUrl = petUrl;
	}

	
	
	
}
