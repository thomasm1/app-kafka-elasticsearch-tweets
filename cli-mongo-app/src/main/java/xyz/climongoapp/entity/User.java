package xyz.climongoapp.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "User")
public class User {
	private int userId;

	@Field(name="name")
	private String userName;

	private String password;

	private String lastName;
	private String firstName;

	private Integer userType;

	@Field(name="groups")
	@DBRef
	private Groups Groups;
	private String email;
	private String phone;
	private String cusUrl;
	private String photoPath;
	private String userGroup;
	private int isActive;
	private int contactType; // ContactType contactType
	@Id
	private String id;
//	alter table users add photopath varchar2(400);
//	alter table users add userGroup varchar2(100);
//	alter table users add isActive number(1);
//	alter table users add contacttype number(2);


	@DBRef
	private List<Car> cars;

	@Transient
	private double percentage;

//	{
//		"userGroup": "5",
//			"lastName": "lastname",
//			"photoPath": "assets/images/a.png",
//			"email": "thomasm1.maestas@gmail.com",
//			"uid": "43uxxxid",
//			"isActive": true,
//			"lastname": "das;lkfj",
//			"firstname": "a;lsdfkj",
//			"contactType": "email",
//			"username": "myUserName",
//			"dateOfBirth": "2020/09/03",
//			"id": "1",
//			"phone": 5550005555
//	},

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
