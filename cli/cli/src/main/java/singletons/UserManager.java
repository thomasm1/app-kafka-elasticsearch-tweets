package singletons;

import models.User;
 
import db.DataStore;
public class UserManager {

	private static UserManager instance = new UserManager();
	private static User userdao = new User();
	private UserManager() {
	}

	public static UserManager getInstance() {

		return instance;
	}

	public User createUser(int userId, long id, String lastName, String firstName, String userName, String password,
			int userType, int gender, String email, String phone, String cusUrl) {
		
		User user = new User();
		user.setUserId(userId);
		user.setId(id);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setUsername(userName);
		user.setPassword(password);
		user.setUserType(userType); 
		user.setGender(gender);
		user.setEmail(email);
		user.setPhone(phone);
		user.setCusUrl(cusUrl);
		
		return user;

	}
	public User[] getUsers() { 
			return DataStore.getUsers(); 
	}
}
