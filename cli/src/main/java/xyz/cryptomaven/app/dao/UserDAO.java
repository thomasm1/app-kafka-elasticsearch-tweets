package xyz.cryptomaven.app.dao;

import java.util.List;
 
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.models.UserCarbuy;

public interface UserDAO {
	public boolean createUser(User u);

	public User getUser(int id);

	public User getUser(String username);

	public List<User> getUsers();

	public List<User> getLocalUsers();

	public boolean updateUser(User change);

	public boolean deleteUser(String username);

	public List<String> getUsersWithCars();

	public User getUserByPassword(String username, String password);


	// PRE-POP
	public boolean createUserPrePop(User u);


	public void saveLocalUserCarbuy(UserCarbuy userCarbuy);
}

