package xyz.cryptomaven.app;

 
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.service.UserService;

public class UserDAOTesting {
	private String dynamicUsername;

	@Test
	public void add_User() {
		dynamicUsername = "Random-User-" + Double.toString(Math.random()*31); // should constrain this back into String form and unique
		User u = new User( "user0", "password", "Smith", "Tom",  6, 1, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
		assertTrue(UserService.createUser(u));
		assertTrue(UserService.deleteUser(UserService.getUser("user0").getUsername()));
	}
}
