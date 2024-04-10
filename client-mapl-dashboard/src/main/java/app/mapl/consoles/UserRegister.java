package app.mapl.consoles;

import app.mapl.dto.UserDto;
import app.mapl.service.UsersServiceJPA;
import app.mapl.util.constants.Cmds;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.Scanner;

@Component
public class UserRegister {

	UsersServiceJPA usersService;

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
//(username VARCHAR2, password VARCHAR2, lastName varchar2, firstName varchar2,  groups NUMBER,  usertype NUMBER,email VARCHAR2, organizationCode VARCHAR2, cusURl VARCHAR2)
//		User newUserser = new User(un, pw, ln, fn, 4, 2, un+"@cryptomaven.xyz", "999-999-9999" ,"http://www.dailytech.net",
//				"dashboardCode",
//				"userGroup",
//				0,
//				1,
//				"id" );
		UserDto newUser =  new UserDto();
//		newUser.setUserid((int) Math.round(Math.random()*100));
		regBegin(un, pw, fn, ln, newUser);
		UserRegister userRegister = new UserRegister();
		userRegister.registerThis(un, pw, fn, ln);


		System.out.println("\nThank you, *" + fn + " "+ ln);
		System.out.println(" Continue to dashboard?  'yes'/'no':");
		String response = scan.next();

		UserDashboard.UserLogin.decideDashboard(response, un);
		scan.close();


	}
	void registerThis(String un, String pw, String fn, String ln ) {
		UserDto newUserDto =  new UserDto();
		newUserDto.setUserId((int) Math.round(Math.random()*100));//not saved
		regBegin(un, pw, fn, ln, newUserDto);
		usersService.createUser(newUserDto);

	}

	private static void regBegin(String un, String pw, String fn, String ln, UserDto newUserDto) {

		newUserDto.setPassword(pw);
		newUserDto.setLastName(ln);
		newUserDto.setFirstName(fn);
		newUserDto.setUserType(2);	// 2 = customer
		newUserDto.setEmail(un);
		newUserDto.setOrganizationCode("999-999-9999");
		newUserDto.setDashboardCode("dashboardCode");
	}

}
