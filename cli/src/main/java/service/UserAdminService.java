package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import dao.UserAdminDao;
import dao.UserAdminDaoImpl; 
//import db.DB;
import models.UserAdmin; 

public class UserAdminService { 
	
	public static UserAdminDao userdao = new UserAdminDaoImpl();

	public static boolean addUserAdmin(UserAdmin u) { 
//		 DB.users.put(u.getUserAdminId(), u);
//		return null;
			System.out.println("Passing UserAdminService userdao.addUserAdmin(u); ...");
		 return userdao.addUserAdmin(u);
	}
	
	public static UserAdmin getUserAdmin(int id) {
//		return DB.users.get(id);
		System.out.println("Passing UserAdminService userdao.getUserAdmin(id);  ...");
		return userdao.getUserAdmin(id); 
		
	}  
	public static UserAdmin getUserAdmin(String username) {
//		return DB.users.get(username);
		System.out.println("Passing UserAdminService userdao.getUserAdmin(username); ...");
		return userdao.getUserAdmin(username);
		
	} 
	public static  List<UserAdmin> listUserAdmin() {  
//		List<UserAdmin> userList = new ArrayList<UserAdmin>();
//		Set<Integer> keys = DB.users.keySet();
//		for(Integer k: keys)
//			userList.add(DB.users.get(k));
//		return userList;
		System.out.println("Passing UserAdminService userdao.listUserAdmin(); ...");
		return userdao.listUserAdmin();
	}

	public static boolean updateUserAdmin(UserAdmin change) {
		System.out.println("Passing UService UPDATE...");
		return userdao.updateUserAdmin(change); 
	}
	
	public static boolean deleteUserAdmin(String userName) {
		System.out.println("Passing UserAdminService userdao.deleteUserAdmin(userName); ...");
		return userdao.deleteUserAdmin(userName); 
	}

	

}
