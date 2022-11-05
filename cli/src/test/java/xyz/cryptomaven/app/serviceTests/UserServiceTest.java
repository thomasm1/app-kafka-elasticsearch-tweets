package xyz.cryptomaven.app.serviceTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.service.UserService;

public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB

//        Setup
        User  p1; //  get
		  User  p2;// update
		  User p3; //delete
	int rand;
	User u = new User("user4" , "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net",
			"photoPath",
			"userGroup",
			0,
			1,
			"id");    // PASSES

	// UI Source

	String loggedUserName = "user4";
	String loggedInPW = "passWordX";
//DB

	@BeforeAll // setup   
	public static void setupClass() { // static! (not needed with TestNG @BeforeClass
	System.out.println("Class/Static setup ");
	}

	@BeforeEach
	public void setup() {
		int num = 7131;
		rand = (int) ((int) num * Math.random());
		System.out.println("Method/Instance setup "+rand);

	}
//TODO mockito Service INJECTION
    @Test   
	public void add_new_user() {
//
//		assertTrue(UserService.createUser(u));
//		UserService.deleteUser(UserService.getUser(u.getUserId()).getUserName());
//		System.out.println("just added and deleted"+u.getUserName());

	}

    @Test   
   	public void get_user() {
   		assertEquals(loggedInPW, u.getPassword());
		   //cleanup
		UserService.deleteUser(UserService.getUser(u.getUserId()).getUserName());
   	} 

    @Test   
   	public void update_user() {
		User uUpdated = new User("password", "Smith", "Tom", 3, 1, "5055087707" , "user4@cryptomaven.xyz", "http://www.dailytech.net","photoPath", 	"userGroup",
				0,
				1,
				"id");   // PASSES
   		assertTrue(UserService.updateUser(uUpdated));
//		   TODO - verify changes from db
   	} 

    @Test   
   	public void delete_user() {
		User u = new User("user4"+rand, "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net",
				"photoPath",
				"userGroup",
				0,
				1,
				"id");    // PASSES
		String x = u.getUserName()+rand;
		System.out.println("about to delete just  ..."+x);
		assertTrue(UserService.deleteUser(x));
		System.out.println("deleteed just now ..."+ x);

   	}
    
	@AfterEach
	public void tearDown() {

		System.out.println("After Class executing ...");
	} // teardown

	@AfterAll  // static! (not needed with TestNG @BeforeClass
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown
	
//////Teardown delete p1;
////		 delete p2;
////		 delete user from add_user test


}