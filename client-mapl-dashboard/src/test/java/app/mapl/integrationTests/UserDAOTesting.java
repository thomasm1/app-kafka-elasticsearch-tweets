package app.mapl.integrationTests;

 
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import app.mapl.models.User;

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
		User u = new User( dynamicUsername, "password", "Smith", "Tom",  6, 1, "user0@cryptomaven.xyz",
				"5055087707" ,
				"http://www.dailytech.net",
		"photoPath",
				"dashboardCode",
				0,
				1,
				"id"
				);
		assertTrue(UserService.createUser(u));
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
		assertTrue(UserService.deleteUser(UserService.getUser("random_user27.0").getUsername()));
		System.out.println("deleted: " + dynamicUsername);
	}
}
