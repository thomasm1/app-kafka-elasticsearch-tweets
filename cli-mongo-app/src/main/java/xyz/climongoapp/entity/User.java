package xyz.climongoapp.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "User")
public class User {

	@Id
	private String id;

	private String name;

	@Field(name = "mail")
	private String email;

	@DBRef
	private Groups Groups;

	@DBRef
	private List<Car> cars;
	
	@Transient
	private double percentage;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Groups getGroups() {
		return Groups;
	}

	public void setGroups(Groups Groups) {
		this.Groups = Groups;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	public double getPercentage() {
		if (cars != null && cars.size() > 0) {
			int total = 0;
			for (Car Car : cars) {
				total += Car.getMarksObtained();
			}
			return total/cars.size();
		}
		return 0.00;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

}
