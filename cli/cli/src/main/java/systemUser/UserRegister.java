package systemUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import models.User;
import service.UserService;
//import models.Pokemon;
//import service.PokemonService;

import java.util.InputMismatchException;

public class UserRegister {

	public static void register() throws SQLException {
	
		System.out.println("Welcome to Registration, \nplease type your username below:");
		Scanner scan = new Scanner(System.in);
		String un = scan.next();

		System.out.println("now, please type an alpha-numeric password:"); 
		String pw = scan.next();

		System.out.println(" first name:\n"); 
		String fn = scan.next();   

		System.out.println(" ,  last name:\n"); 
		String ln = scan.next();  
		
		User newUser = new User(un, pw, ln, fn, 0, 0);
		System.out.println("Successfully registered: "+ UserService.createUser(newUser));
		System.out.println(newUser);

		System.out.println("\nThank you, *" + fn + " "+ ln+"*, Continue to dashboard? yes, 'y':");  
		String yes = scan.next();  
		if (yes.contentEquals("y")) { 
			try {
				System.out.println("...sounds good, *"+ fn + "*, now logging you into your Dashboard");
				CarsDashboard.loginDashboard(un, fn); 
			} catch (Exception e) {
				CarsDashboard.loginDashboard(un, fn);  
			}
		} else {
			UserMain.frontConsole();
		}

		scan.close();

		
	}
}
