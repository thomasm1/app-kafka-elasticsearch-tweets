package singletons;

import models.*;
import dao.UserDAOimpl;

import java.util.List;

public class UserManager {

	private static UserManager instance = new UserManager();
	private static UserDAOimpl userDAOimpl = new UserDAOimpl();
	private UserManager() {
	}

	public static UserManager getInstance() {

		return instance;
	}

	public User createUser(int userId, long id, String lastName, String firstName, String userName, String password,
			int userType, int group, String email, String phone, String cusUrl) {
		
		User user = new User();
		user.setUserId(userId);
		user.setId(id);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setUsername(userName);
		user.setPassword(password);
		user.setUserType(userType); 
		user.setGroup(group);
		user.setEmail(email);
		user.setPhone(phone);
		user.setCusUrl(cusUrl);
		
		return user;

	}
	public List<User>  getUsers() {// THis is just relaying the call to the DaoImpl
			return userDAOimpl.getUsers(); 
	}

	public void saveUserCar(User user, Car car) {
		UserCarbuy userCarbuy = new UserCarbuy();
		userCarbuy.setUser(user);
		userCarbuy.setCar(car);
		userDAOimpl.saveUserCarbuy(userCarbuy);
		
	}

    public Group createGroup(int id, int id2, String name_group) {
		Group group = new Group();
		group.setGroupId(id);
		group.setGroupHeadId(id2);
		group.setGroupName(name_group);
		userDAOimpl.createGroup(group);
		return group;
	}
}
