package serviceTests; 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import models.User;
import service.UserService;

public class UserServiceTest {      // *NOTE: change PK usernames before sending to DB

//        Setup User  p1; get
//		  User  p2; update
//		  User p3; delete

	@org.junit.BeforeClass // setup   
	public static void setupClass() { // static! (not needed with TestNG @BeforeClass
		System.out.println("Class/Static setup "); 
	}

	@org.junit.Before
	public void setup() {
		System.out.println("Method/Instance setup ");
	}

    @org.junit.Test   
	public void add_new_user() {
		User u = new User(999, "x1445549", "passWordX", null, 0, 0);    // PASSES
		assertTrue(UserService.createUser(u));
		UserService.deleteUser(UserService.getUser("x1445549").getUsername());		
	}

    @org.junit.Test   
   	public void get_user() {
   		User u = new User(99, "x455491", "passWordX", null, 0, 0);   // PASSES
		UserService.createUser(u); // leave ou
   		assertEquals("passWordX", u.getPassword());
		UserService.deleteUser(UserService.getUser("x455491").getUsername());	
   	} 
    
    @org.junit.Test   
   	public void update_user() {
   		User u = new User(99, "x455491", "passWordX", null, 0, 0);   // PASSES
		UserService.createUser(u); // leave ou
   		User uUpdated = new User(99, "x455491", "UPDATESpassWordX", null, 1, 1);   // PASSES
   		assertTrue(UserService.updateUser(uUpdated));
		UserService.deleteUser(UserService.getUser("x455491").getUsername());
   	} 

	@org.junit.Test   
   	public void delete_user() {										  // PASSES
   		User u = new User("x114451", "passWordX", null, 0, 0);
   		UserService.createUser(u); 
   		assertTrue(UserService.deleteUser(u.getUsername())); 

   	}
    
	@org.junit.After
	public void tearDown() {
		System.out.println("After Class executing ...");
	} // teardown

	@org.junit.AfterClass   // static! (not needed with TestNG @BeforeClass
	public static void tearDownClass() {
		System.out.println("After Class executing ...");
	} // teardown
	
//////Teardown delete p1;
////		 delete p2;
////		 delete user from add_user test


}