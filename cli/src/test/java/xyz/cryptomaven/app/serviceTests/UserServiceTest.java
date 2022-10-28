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

	User u = new User("user4", "passwordX", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");    // PASSES
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
		UserService.createUser(u);
		System.out.println("Method/Instance setup ");
	}
//TODO mockito Service INJECTION
    @Test   
	public void add_new_user() {
		assertTrue(UserService.createUser(u));

	}

    @Test   
   	public void get_user() {
   		assertEquals(loggedInPW, u.getPassword());
		   //cleanup
		UserService.deleteUser(UserService.getUser(u.getUserId()).getUsername());
   	} 

    @Test   
   	public void update_user() {
		User uUpdated = new User("password", "Smith", "Tom", 3, 1, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");   // PASSES
   		assertTrue(UserService.updateUser(uUpdated));
//		   TODO - verify changes from db
   	} 

    @Test   
   	public void delete_user() {
   		assertTrue(UserService.deleteUser(u.getUsername())); 

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