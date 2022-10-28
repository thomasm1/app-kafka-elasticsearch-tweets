package xyz.cryptomaven.app.integrationTests;

import org.junit.jupiter.api.*;
import xyz.cryptomaven.app.consoles.AdminDashboard;
import xyz.cryptomaven.app.consoles.UserDashboard;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.service.UserService;

import java.sql.SQLException;

class UserDaoLoginTest {  // INTE
	String adminUsername = "admin", adminPassword = "pass";
	// VALIDATION #1 - LOOK UP AND GET Target INPUT DB USER
	String tempUsername = "cust", tempPassword = "pass";
	String un = "joshallen", pw = "allen";

	// MOCKITO Service
	User login = UserService.getUser(un);

	@BeforeAll
	static void setUpBeforeClass_Username() throws Exception {

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}


	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void checkUserNameAndPassword() throws SQLException {
//			VALIDATION #2 - Check targeted DB User against logged-in Username & password
		if (un.contentEquals(adminUsername) && pw.contentEquals(adminPassword)) {
			System.out.println("Welcome Administrator, *" + un + "*\n    ... now preparing your Dashboard");
			AdminDashboard.loginDashboard(un, login.getFirstName()); //

		} else if ((un.contentEquals(tempUsername) && pw.contentEquals(tempPassword))
//			VALIDATION #2 - Check targeted DB User against logged-in Username & password
				| (un.contentEquals(login.getUsername()) && pw.contentEquals(login.getPassword()))) {
			System.out.println(
					"...grreat, password checks out! *" + un + "* #1, now logging you into your Dashboard");
			String name = (login.getFirstName() != null) ? login.getFirstName() : un;
// USER LOGIN
			UserDashboard.loginDashboard(un); //
		}
	}

	@Test
	void checkAdminNameAndPassword() throws SQLException {
//			VALIDATION #2 - Check targeted DB User against logged-in Username & password
		if (un.contentEquals(adminUsername) && pw.contentEquals(adminPassword)) {
			System.out.println("Welcome Administrator, *" + un + "*\n    ... now preparing your Dashboard");
			AdminDashboard.loginDashboard(un, login.getFirstName()); //

		} else if ((un.contentEquals(tempUsername) && pw.contentEquals(tempPassword))
//			VALIDATION #2 - Check targeted DB User against logged-in Username & password
				| (un.contentEquals(login.getUsername()) && pw.contentEquals(login.getPassword()))) {
			System.out.println(
					"...grreat, password checks out! *" + un + "* #1, now logging you into your Dashboard");
			String name = (login.getFirstName() != null) ? login.getFirstName() : un;
// USER LOGIN
			UserDashboard.loginDashboard(un); //
//		fail("Not yet implemented");
		}
	}



}