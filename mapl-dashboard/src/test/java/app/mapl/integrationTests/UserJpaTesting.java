package app.mapl.integrationTests;


import app.mapl.models.dto.UserDto;
import app.mapl.services.UsersService;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static junit.framework.TestCase.assertEquals;

@DataJpaTest
@TestMethodOrder(OrderAnnotation.class)
public class UserJpaTesting {
	static UserDto u  ;
	static String dynamicUsername;
	UsersService usersService;// = new UsersServiceImpl();
	@BeforeAll
	public static void setup() {
		dynamicUsername = Integer.toString((int) Math.floor((Math.random()*31))); // should constrain this back into String form and unique
		  u =   UserDto.builder()
				.userId(Integer.parseInt(dynamicUsername))
				.username("user0")
				.lastName("Smith")
				.firstName("Tom")
				.userType(3)
				.organizationCode("CD")
				.dashboardCode("dashboardCd")
				.email("user4@cryptomaven.xyz")
				.cusUrl("http://www.dailytech.net/photoPath")
				.contactType(1)
				.isActive(1)
				.id("id")
				.build();
		System.out.println("setup: "+ dynamicUsername);
	}
	@Test
	@Order(1)
	public void add_User() throws InterruptedException {

		Assertions.assertEquals(UsersService.createUserCli(u), null);
		System.out.println("added: " + dynamicUsername);
	}
	@Test
	@Order(2)
	public void delete_user() throws InterruptedException {

		System.out.println(		dynamicUsername + " now deleting ; . . . .");
		System.out.println(		"Thread.sleep(2000); . . . .");
		Thread.sleep(2000);
		System.out.println(		"Thread.sleep(1000); . . . .");
		Assertions.assertEquals(UsersService.deleteUserCli(u.getEmail()), null);
		System.out.println("deleted: " + dynamicUsername);
	}
}
