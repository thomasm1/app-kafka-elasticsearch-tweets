package service;

import java.util.List;

import dao.UserDAO;
import dao.UserDAOimpl;
//import db.DB;
import models.User;

public class UserService {
	// DB.users.put(c.getUserID(), c);
	public static UserDAO userdaoImpl = new UserDAOimpl(); // Interface Dao Ref-type, & userImpl is object

	public static boolean createUser(User change) {
		return userdaoImpl.createUser(change);
	};

	public static User getUser(String id) {
		return userdaoImpl.getUser(id);
	};

	public static List<User> getAllUsers() {
		return userdaoImpl.getAllUsers();
	};

	public static boolean updateUser(User change) {
		return userdaoImpl.updateUser(change);
	}

	public static UserDAO getUserdao() {
		return userdaoImpl;
	}

	public static boolean deleteUser(String username) {
		return userdaoImpl.deleteUser(username);

	}
}
