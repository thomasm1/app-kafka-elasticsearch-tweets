package serviceTests; 

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import constants.Gender;
import constants.UserType;
import models.User;
import service.UserService;

public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB

//        Setup User  p1; get
//		  User  p2; update
//		  User p3; delete

	@BeforeAll // setup   
	public static void setupClass() { // static! (not needed with TestNG @BeforeClass
		System.out.println("Class/Static setup "); 
	}

	@BeforeEach
	public void setup() {
		System.out.println("Method/Instance setup ");
	}

    @Test   
	public void add_new_user() {
		User u = new User(999, 0, "x1445549", "passWordX", null, null, 0, 0, null, null, null);    // PASSES
		assertTrue(UserService.createUser(u));
		UserService.deleteUser(UserService.getUser("x1445549").getUsername());		
	}

    @Test   
   	public void get_user() {
   		User u = new User(99, 0, "x455491", "passWordX", null, null, 0, 0, null, null, null);   // PASSES
		UserService.createUser(u); // leave ou
   		assertEquals("passWordX", u.getPassword());
		UserService.deleteUser(UserService.getUser("x455491").getUsername());	
   	} 

    @Test   
   	public void update_user() {
   		User u = new User(99, 0, "x455491", "passWordX", null, null, 0, 0, null, null, null);   // PASSES
		UserService.createUser(u); // leave ou
   		User uUpdated = new User(99, 0, "x455491", "UPDATESpassWordX", null, null, 1, 1, null, null, null);   // PASSES
   		assertTrue(UserService.updateUser(uUpdated));
		UserService.deleteUser(UserService.getUser("x455491").getUsername());
   	} 

    @Test   
   	public void delete_user() {										  // PASSES
   		User u = new User(500, 1000,	"Smith", "Tom", "user0", "password",  UserType.USER, Gender.MALE, "user0@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
   		UserService.createUser(u); 
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