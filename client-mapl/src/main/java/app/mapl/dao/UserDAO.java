package app.mapl.dao;


import app.mapl.models.User;

import java.util.List;

public interface UserDAO {
	public User createUser(User u);

	public User getUser(int id);

	public User getUser(String username);

	public List<User> getUsers();

	public List<User> getLocalUsers();

	public User updateUser(User change);

	public boolean deleteUser(String username);

	public List<String> getUsersWithCoins();

	public User getUserByPassword(String username, String password);


	// PRE-POP
	public User createUserPrePop(User u);

    User getUserbyEmail(String un);
}


