package systemUser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import constants.Cmds;
import constants.Gender;
import constants.UserType;
import models.User;
import service.UserService;
//import models.Pokemon;
//import service.PokemonService;

import java.util.InputMismatchException;

public class UserRegister {

	public static void register() throws SQLException {
	
		System.out.println(Cmds.WELCOME_REGISTER + Cmds.REGISTER_UNAME);
		Scanner scan = new Scanner(System.in);
		String un = scan.next();

		System.out.println(Cmds.REGISTER_PW); 
		String pw = scan.next();

		System.out.println(Cmds.REGISTER_FNAME); 
		String fn = scan.next();   

		System.out.println(Cmds.REGISTER_LNAME); 
		String ln = scan.next();  
		//  "ADD_NEW_USERS" 
//(username VARCHAR2, password VARCHAR2, lastName varchar2, firstName varchar2, usertype NUMBER, gender NUMBER, email VARCHAR2, phone VARCHAR2, cusURl VARCHAR2)
		User newUser = new User(un, pw, ln, fn, UserType.CUST, Gender.OTHER, un+"@cryptomaven.xyz", "999-999-9999" ,"http://www.dailytech.net" );
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