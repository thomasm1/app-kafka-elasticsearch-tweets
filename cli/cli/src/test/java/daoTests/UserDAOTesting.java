package daoTests;

 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import models.User;
import service.UserService;

public class UserDAOTesting {
	private String dynamicUsername;

	@Test
	public void add_User() {
		dynamicUsername = "x1userdname" + Double.toString(Math.random()*31); // should constrain this back into String form and unique
		User u = new User(dynamicUsername, "passWdordX", "lastName", "firstName", 0, 0);
		assertTrue(UserService.createUser(u));
		assertTrue(UserService.deleteUser(UserService.getUser("dynamicUsername").getUsername()));
	}
}
