package serviceTests; 

import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


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
		User u = new User("user4", "password", "Smith", "Tom", UserType.CHIEF_EDITOR, Gender.MALE, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");    // PASSES
		assertTrue(UserService.createUser(u));
		UserService.deleteUser(UserService.getUser("user4").getUsername());		
	}

    @Test   
   	public void get_user() {
   		String expected = "passWordX";
		User u = new User("user4", "password", "Smith", "Tom", UserType.CHIEF_EDITOR, Gender.MALE, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");   // PASSES
		UserService.createUser(u);  
   		assertEquals(expected, u.getPassword());
		UserService.deleteUser(UserService.getUser("user4").getUsername());	
   	} 

    @Test   
   	public void update_user() {
   		User u = new User("user4", "password", "Smith", "Tom", UserType.CHIEF_EDITOR, Gender.MALE, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");   // PASSES
		UserService.createUser(u); // leave ou
   		User uUpdated = new User("user4", "password", "Smith", "Tom", UserType.CHIEF_EDITOR, Gender.MALE, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");   // PASSES
   		assertTrue(UserService.updateUser(uUpdated));
		UserService.deleteUser(UserService.getUser("user4").getUsername());
   	} 

    @Test   
   	public void delete_user() {										  // PASSES
   		User u = new User("user4", "password", "Smith", "Tom", UserType.CHIEF_EDITOR, Gender.MALE, "user4@cryptomaven.xyz",  "5055087707" ,"http://www.dailytech.net");
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