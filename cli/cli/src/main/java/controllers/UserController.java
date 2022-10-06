package controllers;

import models.Car;
import models.User;
import singletons.CarManager;
import singletons.UserManager; 
 

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
