package dao;

import java.util.List;
 
import models.User; 

public interface UserDAO { 
	public boolean createUser(User u); 
	public User getUser(int id); 
	public User getUser(String username); 
	public List<User> getAllUsers(); 
	public boolean updateUser(User change);
	public boolean deleteUser(String username);
	public List<User> getUsersWithCars();
	public  List<User> getUsers();
	public User getUserByPassword(String username, String password);
	
	// PRE-POP
//	public boolean createUserPrePop(User u);
 
	
} 