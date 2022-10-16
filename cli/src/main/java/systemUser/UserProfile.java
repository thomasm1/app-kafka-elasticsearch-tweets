package systemUser;

import constants.Cmds;
import constants.Gender;
import constants.UserType;
import models.User;
import service.UserService;

import java.sql.SQLException;
import java.util.Scanner;

public class UserProfile {

	public static void editProfile() throws SQLException {
		String pw ="";
		String fName ="";
		String lName ="";
		int gender = 0;
		String email ="";
		String phone ="";
		String url ="";

		Scanner scan = new Scanner(System.in);

		System.out.println(Cmds.WELCOME_PROFILE );
		System.out.println(Cmds.ONE+ Cmds.EDIT_PW);
		System.out.println(Cmds.TWO+ Cmds.EDIT_FNAME);
		System.out.println(Cmds.THREE+ Cmds.EDIT_LNAME);
		System.out.println(Cmds.FOUR + Cmds.EDIT_GENDER);
		System.out.println(Cmds.FIVE+ Cmds.EDIT_EMAIL);
		System.out.println(Cmds.SIX+ Cmds.EDIT_PHONE);
		System.out.println(Cmds.SEVEN+ Cmds.EDIT_URL);
		int Choice = scan.nextInt();
		System.out.printf("'%S' %n", "Enter your edit");

		switch(Choice) {
			case 1:
				  pw = scan.next();
				break;
			case 2:
				  fName = scan.next();
				break;
			case 3:
				  lName = scan.next();
				break;
			case 4:
				String genderStr = scan.next();
				  gender = genderStr == "m"? 1:(genderStr=="f"? 2: 3);
				break;
			case 5:
				  email = scan.next();
				break;
			case 6:
				  phone = scan.next();
				break;
			case 7:
				  url = scan.next();
				break;
		}


//(username VARCHAR2, password VARCHAR2, lastName varchar2, firstName varchar2, usertype NUMBER, gender NUMBER, email VARCHAR2, phone VARCHAR2, cusURl VARCHAR2)
		User change = new User( pw, lName, fName, gender, email, phone ,url );
		System.out.println("Successfully registered: "+ UserService.updateUser(change));
		System.out.println("changed: "+ change);

		System.out.println("\nThank you,   Continue to dashboard? yes, 'y':");
		String yes = scan.next();  
		if (yes.contentEquals("y")) { 
			try {
				System.out.println("...sounds good, now logging you into your Dashboard");
				UserDashboard.loginDashboard(change.getUsername(), change.getPassword());
			} catch (Exception e) {
				System.out.println("Oops, changes not implemented, now returing to your dashboard");
			MainDashboard.console();
			}
		} else {
			MainDashboard.console();
		}

		scan.close();

		
	}
}
