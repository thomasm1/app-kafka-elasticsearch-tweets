package dao;

import java.util.List;

import models.UserAdmin;

public interface UserAdminDao {
	public boolean addUserAdmin(UserAdmin u); 
	public UserAdmin getUserAdmin(int id); 
	public UserAdmin getUserAdmin(String username); 
	public List<UserAdmin> listUserAdmin(); 
	public boolean updateUserAdmin(UserAdmin change);
	public boolean deleteUserAdmin(String username);
	 
}
