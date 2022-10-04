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
	
	// PRE-POP
//	public boolean createUserPrePop(User u);
 
	
} 