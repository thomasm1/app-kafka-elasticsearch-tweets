package app.mapl.integrationTests;

 
import app.mapl.dto.UserDto;
import app.mapl.service.UsersServiceJPA;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTesting {
	private static UsersServiceJPA usersServiceJPA = new UsersServiceJPA();
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
		UserDto u = new UserDto( Integer.valueOf(dynamicUsername), "username", "password", "lastName", "firstName", 0, "phone", "email", "cusUrl", "dashboardCode", 0, 0, null);
		assertEquals(usersServiceJPA.createUser(u), u);
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
		assertTrue(usersServiceJPA.deleteUser(String.valueOf(usersServiceJPA.getUserByEmail("random_user27@gmail.com"))));
		System.out.println("deleted: " + dynamicUsername);
	}
}
