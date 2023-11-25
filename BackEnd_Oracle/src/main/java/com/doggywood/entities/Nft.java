package com.doggywood.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Nft {

	@Id
	@GeneratedValue
	@Column(name = "P_ID")
	private int id;
	
	@Column(name = "C_ID")
	private int custId;
	
	@Column(name = "P_NAME")
	private String nftName;
	
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
	
	@Column(name = "NFT_URL")
	private String nftUrl;

	public Nft(int id, int custId, String nftName, String birthDate, int weight, String color, int type, String breed,
			   int neuter, String description, String nftUrl) {
		super();
		this.id = id;
		this.custId = custId;
		this.nftName = nftName;
		this.birthDate = birthDate;
		this.weight = weight;
		this.color = color;
		this.type = type;
		this.breed = breed;
		this.neuter = neuter;
		this.description = description;
		this.nftUrl = nftUrl;
	}

	public Nft(int custId, String nftName, String birthDate, int weight, String color, int type, String breed, int neuter,
			   String description, String nftUrl) {
		super();
		this.custId = custId;
		this.nftName = nftName;
		this.birthDate = birthDate;
		this.weight = weight;
		this.color = color;
		this.type = type;
		this.breed = breed;
		this.neuter = neuter;
		this.description = description;
		this.nftUrl = nftUrl;
	}

	public Nft() {
		super();
	}

	@Override
	public String toString() {
		return "Nft [id=" + id + ", custId=" + custId + ", nftName=" + nftName + ", birthDate=" + birthDate + ", weight="
				+ weight + ", color=" + color + ", type=" + type + ", breed=" + breed + ", neuter=" + neuter
				+ ", description=" + description + ", nftUrl=" + nftUrl + ", getClass()=" + getClass() + ", hashCode()="
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

	public String getNftName() {
		return nftName;
	}

	public void setNftName(String nftName) {
		this.nftName = nftName;
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

	public String getNftUrl() {
		return nftUrl;
	}

	public void setNftUrl(String nftUrl) {
		this.nftUrl = nftUrl;
	}

	
	
	
}
