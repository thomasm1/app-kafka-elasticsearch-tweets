package service;

import java.util.List;

import dao.UserDAO;
import dao.UserDAOimpl;
//import db.DB;
import models.User;

public class UserService {
	// DB.users.put(c.getUserID(), c);
	public static UserDAO userdaoImpl = new UserDAOimpl(); // Interface Dao Ref-type, & userImpl is object

	public static boolean createUser(User user) {
		System.out.println("Passing User Service userdao.createUser(u); ...");
		return userdaoImpl.createUser(user);
	};

	public static User getUser(String id) {
		System.out.println("Passing User Service getUser(String id) {...");
		return userdaoImpl.getUser(id);
	};
	public static List<User> getUsers() {
		System.out.println("Passing User Service userdao.getAllUsers() { ...");
		return userdaoImpl.getAllUsers();
	};
	public static List<User> getAllUsers() {
		System.out.println("Passing User Service userdao.getAllUsers() { ...");
		return userdaoImpl.getAllUsers();
	};

	public static boolean updateUser(User change) {
		System.out.println("Passing User Service userdao.updateUser(User change) {..");
		return userdaoImpl.updateUser(change);
	}

	public static UserDAO getUserdao() {
		System.out.println("Passing User Service userdao.getUserdao() {..");
		return userdaoImpl;
	}

	public static List<User> getUsersWithCars() {
		System.out.println("Passing User Service userdao.getUsersWithCars() {...");
		return userdaoImpl.getUsersWithCars();
	}

	public static User getUserByPassword(String username, String password) {
		System.out.println("Passing User Service userdao.getUserByPassword(String username, String password)...");
		return userdaoImpl.getUserByPassword(username, password);
	}
	public static boolean deleteUser(String username) {
		System.out.println("Passing User Service userdao.deleteUser(String username) { ...");
		return userdaoImpl.deleteUser(username);
	}
}
