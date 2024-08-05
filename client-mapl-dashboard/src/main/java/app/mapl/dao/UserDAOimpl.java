package app.mapl.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import app.mapl.dataLoader.BookmarkManager;
import app.mapl.models.*;
import app.mapl.util.JDBCConnection;

import java.util.ArrayList;
import java.util.List;
//import db.DB;



public class UserDAOimpl implements UserDAO { // can't make static! so use the service layer!
	public static Connection conn = JDBCConnection.getConnection();

	@Override
	public boolean createUser(User u) {
//		DB.users.put(u.getUserID(), c);
		// USER is autoincrement
		String sql = "CALL add_new_users(?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, u.getUsername());
			cs.setString(2, u.getPassword());
			cs.setString(3, u.getLastName());
			cs.setString(4, u.getFirstName());
			cs.setString(5, Integer.toString(u.getGroups()));
			cs.setString(6, Integer.toString(u.getUserType()));
			cs.setString(7, u.getOrganizationCode());
			cs.setString(8, u.getEmail());
			cs.setString(9, u.getCusUrl());
			cs.setString(10, u.getPhotoPath());
			cs.setString(11, u.getDashboardCode());
			cs.setString(12, Integer.toString(u.getIsActive()));
			cs.setString(13, Integer.toString(u.getContactType()));
			cs.setString(14, u.getId());

			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double Check create DB's  customer's list");
			e.printStackTrace();
		}
		return false;

	}

	/// SQL ERROR HERE? 
	@Override
	public User getUserByPassword(String username, String password) {
		try {
			String sql = "SELECT users.username  FROM users WHERE users.username = ? AND users.password = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, password); 
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new User(rs.getInt("userid"),
						rs.getString("username"),
						rs.getString("password")
//						,rs.getString("lastname"), rs.getString("firstName"), rs.getInt("userType"), rs.getInt("groups"),
//						rs.getString("email"), rs.getString("organizationCode"), rs.getString("cusUrl")
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
	@Override
	public User getUser(String username) {
//		return DB.users.get(id);
		try {
			String sql = "SELECT * FROM users WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new User(rs.getInt("userid"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("lastname"),
						rs.getString("firstName"),
						rs.getInt("groups"),
						rs.getInt("userType"),
						rs.getString("organizationCode"),
						rs.getString("email"),
						rs.getString("cusUrl"),
						rs.getString("photoPath"),
						rs.getString("dashboardCode"),
						rs.getInt("isActive"),
						rs.getInt("contactType"),
						rs.getString("id"),
						(List<Address>) rs.getObject("user")
				);
			}

		} catch (Exception e) {
			System.out.println("SQL issue with getting USER(username):\n" + e);
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUser(int userid) {
//		return null;
		try {
			String sql = "SELECT * FROM users WHERE userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(userid));
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				return new User(rs.getInt("userid"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("lastname"),
						rs.getString("firstName"),
						rs.getInt("groups"),
						rs.getInt("userType"),
						rs.getString("organizationCode"),
						rs.getString("email"),
						rs.getString("cusUrl"),
						rs.getString("photoPath"),
						rs.getString("dashboardCode"),
						rs.getInt("isActive"),
						rs.getInt("contactType"),
						rs.getString("id"),
						(List<Address>) rs.getObject("user")
				);
			}


		} catch (Exception e) {
			System.out.println("SQL issue with getting USER: \n" + e);
			e.printStackTrace();
		}
		return null;
	};

	@Override
	public List<String> getUsersWithCoins() {
		String sql = "SELECT DISTINCT users.userid, users.username FROM users,electrolot WHERE users.username = electrolot.username";
		List<String> usersWithCoins = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql); 
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				usersWithCoins.add(rs.getString("username"));
			}
			return usersWithCoins;
		} catch (Exception e) {
			System.out.println("SQL issue with getting getUsersWithCoins():\n" + e);
			e.printStackTrace();
		}
		return null;
	}

	public List<User> getUsers() {
		String sql = "SELECT * FROM users";
		List<User> userArr = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userArr.add(new User(rs.getInt("userid"),
						rs.getString("username"),
						rs.getString("password"),
						rs.getString("lastname"),
						rs.getString("firstName"),
						rs.getInt("userType"),
						rs.getInt("groups"),
						rs.getString("email"),
						rs.getString("organizationCode"),
						rs.getString("cusUrl"),
						rs.getString("photoPath"),
						rs.getString("dashboardCode"),
						rs.getInt("isActive"),
						rs.getInt("contactType"),
						rs.getString("id"),
						(List<Address>) rs.getObject("user")
				));
			}
			return userArr;
		} catch (SQLException e) {
			System.out.println("SQL issue with getting All USER:\n " + e);
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateUser(User change) { // using USERNAME
//											 	1			2			3			4			5		6		7			8			9			10			11			12		13					14
//		String sql = "UPDATE users SET password=?, lastname=?, firstname=?, groups=?, usertype=?,  organizationCode=?, email=?, cusurl=?, photopath=?, dashboardCode=?, isActive=?, contactType=?, id=?  WHERE username = ?";
		String sql = "CALL UPDATE_USER(?,?,?, ?,?,?, ?,?,?, ?,?,?, ?,?)";
		try {
//			PreparedStatement ps = conn.prepareStatement(sql);
//		    ps.setString(6, Integer.toString(change.getUserID()));

			CallableStatement cs = conn.prepareCall(sql);
			cs.setString(1, change.getPassword());
			cs.setString(2, change.getLastName());
			cs.setString(3, change.getFirstName());
			cs.setString(4, Integer.toString(change.getGroups()));
			cs.setString(5, Integer.toString(change.getUserType()));
			cs.setString(6, change.getOrganizationCode());
			cs.setString(7, change.getEmail());
			cs.setString(8, change.getCusUrl());
			cs.setString(9, change.getPhotoPath());
			cs.setString(10, change.getDashboardCode());
			cs.setString(11, Integer.toString(change.getIsActive()));
			cs.setString(12, Integer.toString(change.getContactType()));
			cs.setString(13, change.getId());
			cs.setString(14, change.getUsername());
//			ps.executeQuery();
			cs.execute();

			return true;
		} catch (SQLException e) {
			System.out.println("SQL issue with updating USER:\n " + e);
			e.printStackTrace();
		}
		return false;

	}

	public boolean deleteUser(String username) {
//		DB.users.remove(id);
		String sql = "DELETE users WHERE username = ?;";
//		String sql = "CALL DELETE_USER(?)";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

//			CallableStatement cs = conn.prepareCall(sql);
//			cs.setString(1,username);
			return true;
		} catch (Exception e) {
			System.out.println("doublecheck deletions: \n" + e);
			e.printStackTrace();
		}
		return false;
	}


	///////////////////////// //	OFFLINE TESTDATA
	@Override
	public boolean createUserPrePop(User u) {
		return false;
	}

	/**
	 * @param userCoinbuy
	 */
	@Override
	public void saveUserCoinbuy(UserCoinbuy userCoinbuy) {

		BookmarkManager.TestDataStore.add(userCoinbuy);
	}

	@Override
	public  List<User> getLocalUsers() {
		return BookmarkManager.TestDataStore.getUsers();
	}


    public void createLocalGroups(Groups groups) {
		BookmarkManager.TestDataStore.add(groups);
    }


	public void saveLocalUserCoinbuy(User user, Coin coin) {
		BookmarkManager.TestDataStore.saveLocalUserCoinbuy(user, coin);
	}

	public void saveLocalUserCoinbuy(UserCoinbuy userCoinbuy) {
		BookmarkManager.TestDataStore.add(userCoinbuy);
	}

	public List<Coin> getLocalUserCoinbuysByUser(User user) {
		List<Coin> listOfCoinsOwnedByUser = new ArrayList<>();
		List<UserCoinbuy> allUserCoins = new ArrayList<>();
		for(UserCoinbuy userCoinbuy: allUserCoins ) {
			if (userCoinbuy.getUser()==user) {
				listOfCoinsOwnedByUser.add(userCoinbuy.getCoin());
			}
		}
		return listOfCoinsOwnedByUser;
	}
}