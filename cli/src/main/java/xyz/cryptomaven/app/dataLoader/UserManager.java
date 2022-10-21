package xyz.cryptomaven.app.dataLoader;

import xyz.cryptomaven.app.dao.UserDAOimpl;
import xyz.cryptomaven.app.models.Car;
import xyz.cryptomaven.app.models.Groups;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.models.UserCarbuy;

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
						   int userType, int groups, String email, String phone, String cusUrl) {
		
		User user = new User();
		user.setUserId(userId);
		user.setId(id);
		user.setLastName(lastName);
		user.setFirstName(firstName);
		user.setUsername(userName);
		user.setPassword(password);
		user.setUserType(userType); 
		user.setGroups(groups);
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

    public Groups createGroups(int id, int id2, String name_groups) {
		Groups groups = new Groups();
		groups.setGroupsId(id);
		groups.setGroupsHeadId(id2);
		groups.setGroupsName(name_groups);
		userDAOimpl.createGroups(groups);
		return groups;
	}
}
