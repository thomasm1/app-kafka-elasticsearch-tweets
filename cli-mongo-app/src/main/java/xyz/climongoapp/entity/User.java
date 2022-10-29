package xyz.climongoapp.entity;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "User")
public class User {

	@Id
	private int id;

	@Field(name="name")
	private String userName;

	private String lastName;

	private String firstName;

	private String email;

	private String password;

	@DBRef
	private Groups Groups;

	@DBRef
	private List<Car> cars;

	@Transient
	private double percentage;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	public String renderFullName(String[] strArr) {
		this.firstName = strArr[0];
		this.lastName = strArr[1];
		String[] conc = new String[]{this.firstName, this.lastName };
		String fullName = "";
//         return Arrays.stream(conc).reduce(String::concat).orElse("");
		for(String userName: conc) {
			fullName += userName+" ";
		}
		// localCacheService.storeUserFullName(fullName);
		return fullName.trim();
	}

}
