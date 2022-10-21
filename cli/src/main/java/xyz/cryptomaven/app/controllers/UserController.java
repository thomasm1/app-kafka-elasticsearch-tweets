package xyz.cryptomaven.app.controllers;

import xyz.cryptomaven.app.models.Car;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.dataLoader.UserManager;
 

// Like Singleton Managers, Controllers return singletons
public class UserController {
	private static UserController instance = new UserController();
	private UserController() {}
	public static UserController getInstance() {
		return instance;
	}
	public void saveUserCar(User user, Car car) {
		UserManager.getInstance().saveUserCar(user, car);
	}

}
