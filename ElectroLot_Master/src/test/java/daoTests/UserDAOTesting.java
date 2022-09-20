package daoTests;

//import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.User;
import service.UserService;

public class UserDAOTesting {
	private String dynamicUsername;

	@Test
	public void add_User() {
		dynamicUsername = "x1userdname" + Math.random(); // should constrain this back into String form and unique
		User u = new User(dynamicUsername, "passWdordX", "NEW FULL NAME", 0, 0);
		assertTrue(UserService.createUser(u));
		assertTrue(UserService.deleteUser(UserService.getUser("dynamicUsername").getUsername()));
	}
}
