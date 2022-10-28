package xyz.cryptomaven.app.systemUser;

import java.sql.SQLException;
import java.util.Scanner;

import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.service.UserService;
import xyz.cryptomaven.app.consoles.MainDashboard;
import xyz.cryptomaven.app.consoles.UserDashboard;

public class UserRegister {

	public static void register() throws SQLException {
	
		System.out.print(Cmds.WELCOME_REGISTER);
		System.out.print(Cmds.REGISTER_UNAME);
		Scanner scan = new Scanner(System.in);
		String un = scan.next();

		System.out.println(Cmds.REGISTER_PW); 
		String pw = scan.next();

		System.out.println(Cmds.REGISTER_FNAME); 
		String fn = scan.next();   

		System.out.println(Cmds.REGISTER_LNAME); 
		String ln = scan.next();  
		//  "ADD_NEW_USERS" 
//(username VARCHAR2, password VARCHAR2, lastName varchar2, firstName varchar2, usertype NUMBER, groups NUMBER, email VARCHAR2, phone VARCHAR2, cusURl VARCHAR2)
		User newUser = new User(un, pw, ln, fn, 4, 2, un+"@cryptomaven.xyz", "999-999-9999" ,"http://www.dailytech.net" );

		System.out.println("Successfully registered: "+ UserService.createUser(newUser));
		System.out.println("New User: "+newUser);

		System.out.println("\nThank you, *" + fn + " "+ ln);
		System.out.println(" Continue to dashboard?  'yes'/'no':");
		String response = scan.next();

		UserLogin.decideDashboard(response, un);
		scan.close();

		
	}


}
