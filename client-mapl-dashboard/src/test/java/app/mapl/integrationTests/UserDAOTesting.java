package app.mapl.integrationTests;

 
import app.mapl.models.auth.UserRequest;
import app.mapl.service.UsersServiceJPA;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
@TestMethodOrder(OrderAnnotation.class)
public class UserDAOTesting {
	private static UsersServiceJPA usersServiceJPA = new UsersServiceJPA( );
	static String dynamicUsername;

	@BeforeAll
	public static void setup() {
		dynamicUsername = "random_user" + Double.toString(Math.floor((Math.random()*31))); // should constrain this back into String form and unique
		log.info("setup: "+ dynamicUsername);
	}
	@Test
	@Order(1)
	public void add_User() throws InterruptedException {
//		dynamicUsername = "random_user" + Double.toString(Math.floor((Math.random()*31))); // should constrain this back into String form and unique
		UserRequest u = UserRequest.builder()
				.email("user-"+Integer.valueOf(dynamicUsername)+"@gmail.com")
				.lastName("lastName")
				.firstName("firstName")
				.password("password")
				.build();
		assertEquals(usersServiceJPA.saveUser(u), u);
		log.info("added: " + dynamicUsername);
	}
	@Test

	@Order(2)
	public void delete_user() throws InterruptedException {
		log.info(	 " now deleting ; . . . .");
		log.info(		"Thread.sleep(2000); . . . .");
		Thread.sleep(2000);
		log.info(		"Thread.sleep(1000); . . . .");
		Thread.sleep(1000);
		assertTrue(usersServiceJPA.deleteUser(String.valueOf(usersServiceJPA.getUserByEmail("random_user27@gmail.com"))));
		log.info("deleted: " + dynamicUsername);
	}
}
