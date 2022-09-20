package dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import util.JDBCConnection;

import java.util.ArrayList;
import java.util.List;
import dao.UserDAO;

//import db.DB;
import models.User; 

public class UserDAOimpl implements UserDAO {  // can't make static! so use the service layer!
	public static Connection conn = JDBCConnection.getConnection();

	public boolean createUser(User u) {
//		DB.users.put(u.getUserID(), c);
//		return true;
		String sql = "CALL add_new_user( ?,?, ?,?,?)";
		try {
			CallableStatement cs = conn.prepareCall(sql); 
			cs.setString(1, u.getUsername()); 
			cs.setString(2, u.getPassword()); 
			cs.setString(3, u.getFullName());  
			cs.setString(4, Integer.toString(u.isCust()));
			cs.setString(5, Integer.toString(u.isOwner()));

			cs.execute();
			return true;

		} catch (SQLException e) {
			System.out.println("Double Check create DB's  customer's list");
			e.printStackTrace();
		}
		return false;
	
	}
	
	public User getUser (String username) {
//		return DB.users.get(id);
		try {
			String sql = "SELECT * FROM usertable WHERE username = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) 
			{
				return new User(rs.getInt("userid"), 
						rs.getString("username"),  
						rs.getString("password"),  
						rs.getString("fullname"),   
						rs.getInt("iscust"), 
						rs.getInt("isowner"));
			}

		} catch (Exception e) {
			System.out.println("SQL issue with getting USER(username):\n" +e);
			e.printStackTrace();
		}
		return null;
	}
	public User getUser(int id) {
//		return null;
		try {
			String sql = "SELECT * FROM usertable WHERE userid = ?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, Integer.toString(id));
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				return new User(rs.getInt("userid"), 
						rs.getString("username"),  
						rs.getString("password"),  
						rs.getString("fullname"),   
						rs.getInt("iscust"), 
						rs.getInt("isowner"));
		 
			}

		} 
		catch (Exception e) {
System.out.println("SQL issue with getting USER: \n"+e);
e.printStackTrace();
}
		return null;
	}; 
	
	public List<User> getAllUsers() {
//		List<User> userList = new ArrayList<User>();
//		Set<Integer> keys = DB.users.keySet();
//		for(Integer k: keys)
//			userList.add(DB.users.get(k));
//		return userList;
		String sql = "SELECT * FROM usertable";
		List<User> userArr = new ArrayList<User>();
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			// preparedStatements are safe from SQL injection & sanitize inputs
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				userArr.add(new User(rs.getInt("userid"), 
						rs.getString("username"),  
						rs.getString("password"),  
						rs.getString("fullname"),   
						rs.getInt("iscust"), 
						rs.getInt("isowner")));
			}
			return userArr;
		} catch (SQLException e) {
			System.out.println("SQL issue with getting All USER:\n "+e);
			e.printStackTrace();
		}
		return null;
	}
	public boolean updateUser(User change) { // using USERNAME
//		DB.users.replace(change.getUserID(), change);
//		return true;
		String sql = "UPDATE usertable SET password=?, fullname=?, iscust=?, isowner=? WHERE username = ?";
				try {
					PreparedStatement ps = conn.prepareStatement(sql); 
//					ps.setString(6, Integer.toString(change.getUserID()));
					ps.setString(1, change.getPassword());
					ps.setString(2, change.getFullName());
					ps.setString(3, Integer.toString(change.isCust()));
					ps.setString(4, Integer.toString(change.isOwner())); 
					ps.setString(5, change.getUsername());
					ps.executeQuery();
				
					return true;
				} catch (SQLException e) {
					System.out.println("SQL issue with updating USER:\n "+e);
					e.printStackTrace();
				}
				return false;

	}
	public boolean deleteUser(String u) {
//		DB.users.remove(id);
		String sql = "DELETE usertable WHERE username = ?";
		
	try {
		PreparedStatement ps = conn.prepareStatement(sql); 
		ps.setString(1, u);
		
//		int var = 1;
//		System.out.println(var);
//		System.out.println("never delete ... ");
		
		return true;
	} catch (Exception e) {
 System.out.println("doublecheck deletions: \n"+e);
	e.printStackTrace();
	}
	return false;
	}
 
}  