package app.mapl.integrationTests;

 
import static app.mapl.service.UsersServiceImpl.userMapper;
import static org.junit.jupiter.api.Assertions.*;

import app.mapl.dto.UserDto;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import app.mapl.models.User;
import app.mapl.service.UsersServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTesting {

	static String dynamicUsername;

	@BeforeAll
	public static void setup() {
		dynamicUsername = "random_user" + Double.toString(Math.floor((Math.random()*31))); // should constrain this back into String form and unique
		System.out.println("setup: "+ dynamicUsername);
	}
	@Test
	@Order(1)
	public void add_User() throws InterruptedException {
//		dynamicUsername = "random_user" + Double.toString(Math.floor((Math.random()*31))); // should constrain this back into String form and unique
		UserDto u = new UserDto( Integer.valueOf(dynamicUsername), "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "photoPath", 0, 0, null);
		assertEquals(UsersServiceImpl.createUserCli(u), u);
		System.out.println("added: " + dynamicUsername);
	}
	@Test

	@Order(2)
	public void delete_user() throws InterruptedException {
		System.out.println(		dynamicUsername + " now deleting ; . . . .");
		System.out.println(		"Thread.sleep(2000); . . . .");
		Thread.sleep(2000);
		System.out.println(		"Thread.sleep(1000); . . . .");
		Thread.sleep(1000);
		assertTrue(UsersServiceImpl.deleteUserCli(String.valueOf(UsersServiceImpl.getUserCli("random_user27.0"))));
		System.out.println("deleted: " + dynamicUsername);
	}
}
