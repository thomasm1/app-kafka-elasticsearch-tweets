package xyz.cryptomaven.app.service;

import xyz.cryptomaven.app.models.User;

import java.util.List;


public interface UsersService {

	public User createUser(User user);

	public User getUser(int id);
	public User getUser(String username );
	public List<User> getUsers();

	public User updateUser(User change);


	public List<String> getUsersWithCars();

	public User getUserByPassword(String username, String password);
	public boolean deleteUser(String username);

	boolean deleteUser(User user);
}
