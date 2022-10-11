package dao;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.JDBCConnection;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import dao.UserDAO;
import db.DataStore;
import models.Bookmark;
import models.Car;
//import db.DB;
import models.User;
import models.UserCarbuy;

public class UserDAOimpl implements UserDAO { // can't make static! so use the service layer!
	public static Connection conn = JDBCConnection.getConnection();

	public boolean createUser(User u) {
//		DB.users.put(u.getUserID(), c);
//		return true;
		// USER is autoincrement
		String sql = "CALL add_new_users(?,?,?, ?,?,?, ?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getLastName());
			cs.setString(4, u.getFirstName());
			cs.setString(5, Integer.toString(u.getUserType()));
			cs.setString(6, Integer.toString(u.getGender()));
			cs.setString(7, u.getEmail());
			cs.setString(8, u.getPhone());
			cs.setString(9, u.getCusUrl());

			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double Check create DB's  customer's list");
			e.printStackTrace();
		}
		return false;

	}

	/// SQL ERROR HERE? 
	public User getUserByPassword(String username, String password) {
		try {
			String sql = "SELECT users.username  FROM users WHERE users.username = ? AND users.password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password); 
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new User(rs.getInt("userid"), rs.getString("username"), rs.getString("password")
//						,rs.getString("lastname"), rs.getString("firstName"), rs.getInt("userType"), rs.getInt("gender"),
//						rs.getString("email"), rs.getString("phone"), rs.getString("cusUrl")
						);
			}

		} catch (Exception e) {
			System.out.println("SQL issue with getting getUserByPassword(username):\n" + e);
			e.printStackTrace();
		}
		return null;

	}

	/// GET
	/// /////////////////////////////////////////////////////////////////////////////
	public User getUser(String username) {
//		return DB.users.get(id);
		try {
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new User(rs.getInt("userid"), rs.getString("username"), rs.getString("password"),
						rs.getString("lastname"), rs.getString("firstName"), rs.getInt("userType"), rs.getInt("gender"),
						rs.getString("email"), rs.getString("phone"), rs.getString("cusUrl"));
			}

		} catch (Exception e) {
			System.out.println("SQL issue with getting USER(username):\n" + e);
			e.printStackTrace();
		}
		return null;
	}

	public User getUser(int id) {
//		return null;
		try {
			String sql = "SELECT * FROM users WHERE userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new User(rs.getInt("userid"), rs.getString("username"), rs.getString("password"),
						rs.getString("lastname"), rs.getString("firstName"), rs.getInt("userType"), rs.getInt("gender"),
						rs.getString("email"), rs.getString("phone"), rs.getString("cusUrl"));
			}

		} catch (Exception e) {
			System.out.println("SQL issue with getting USER: \n" + e);
			e.printStackTrace();
		}
		return null;
	};

	public List<User> getUsersWithCars() {
		String sql = "SELECT users.userid, users.username FROM users,electrolot WHERE users.username = electrolot.username";
		List<User> usersWithCars = new ArrayList<User>(); 
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usersWithCars.add(new User(rs.getInt("userid"), rs.getString("username")));
			}
			return usersWithCars;
		} catch (Exception e) {
			System.out.println("SQL issue with getting getUsersWithCars():\n" + e);
			e.printStackTrace();
		}
		return null;

	}

//	@Override
	public User[] getUsers() {
		return DataStore.getUsers();
	}

	public List<User> getAllUsers() {
		String sql = "SELECT * FROM users";
		List<User> userArr = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userArr.add(new User(rs.getInt("userid"), rs.getString("username"), rs.getString("password"),
						rs.getString("lastname"), rs.getString("firstName"), rs.getInt("userType"), rs.getInt("gender"),
						rs.getString("email"), rs.getString("phone"), rs.getString("cusUrl")));
			}
			return userArr;
		} catch (SQLException e) {
			System.out.println("SQL issue with getting All USER:\n " + e);
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateUser(User change) { // using USERNAME
//		DB.users.replace(change.getUserID(), change);
//		return true;
		String sql = "UPDATE users SET password=?, lastname=?, firstname=?, usertype=?, gender=?, email=?, phone=?, cusurl=? WHERE username = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
//					ps.setString(6, Integer.toString(change.getUserID()));
			ps.setString(1, change.getPassword());
			ps.setString(2, change.getLastName());
			ps.setString(3, change.getFirstName());
			ps.setString(4, Integer.toString(change.getUserType()));
			ps.setString(5, Integer.toString(change.getGender()));
			ps.setString(6, change.getEmail());
			ps.setString(7, change.getPhone());
			ps.setString(8, change.getCusUrl());
			ps.setString(9, change.getUsername());
			ps.executeQuery();

			return true;
		} catch (SQLException e) {
			System.out.println("SQL issue with updating USER:\n " + e);
			e.printStackTrace();
		}
		return false;

	}

	public boolean deleteUser(String u) {
//		DB.users.remove(id);
		String sql = "DELETE users WHERE username = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, u);

//		int var = 1;
//		System.out.println(var);
//		System.out.println("never delete ... ");

			return true;
		} catch (Exception e) {
			System.out.println("doublecheck deletions: \n" + e);
			e.printStackTrace();
		}
		return false;
	}

	public void saveUserCarbuy(UserCarbuy userCarbuy) {
		DataStore.add(userCarbuy);

	}

}