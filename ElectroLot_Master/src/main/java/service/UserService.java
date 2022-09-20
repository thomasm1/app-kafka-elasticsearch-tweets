package service;

import java.util.List;

import dao.UserDAO;
import dao.UserDAOimpl;
//import db.DB;
import models.User;

public class UserService {
	// DB.users.put(c.getUserID(), c);
	public static UserDAO userdao = new UserDAOimpl();

	public static boolean createUser(User change) {
		return userdao.createUser(change);
	};

	public static User getUser(String id) {
		return userdao.getUser(id);
	};

	public static List<User> getAllUsers() {
		return userdao.getAllUsers();
	};

	public static boolean updateUser(User change) {
		return userdao.updateUser(change);
	}

	public static UserDAO getUserdao() {
		return userdao;
	}

	public static boolean deleteUser(String username) {
		return userdao.deleteUser(username);

	}
}
