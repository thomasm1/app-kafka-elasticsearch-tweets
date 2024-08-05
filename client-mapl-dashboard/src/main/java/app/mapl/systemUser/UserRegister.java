package app.mapl.systemUser;

import java.sql.SQLException;
import java.util.Scanner;

import app.mapl.dto.UserDto;
import app.mapl.util.constants.Cmds;
import app.mapl.models.User;
import app.mapl.service.UsersServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserRegister {
	@Autowired
	static
	UsersServiceImpl userService;

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
//				"photoPath",
//				"dashboardCode",
//				0,
//				1,
//				"id" );
		UserDto newUser = new UserDto();
		newUser.setUserId((int) Math.round(Math.random()*100));
		newUser.setUsername(un);
//		newUser.setPassword(pw);
		newUser.setLastName(ln);
		newUser.setFirstName(fn);
		newUser.setUserType( 2);	// 2 = customer
		newUser.setEmail(un+"@cryptomaven.xyz");
		newUser.setOrganizationCode("999-999-9999");
		newUser.setCusUrl("http://www.dailytech.net");
		newUser.setDashboardCode("dashboardCode");
		newUser.setIsActive(0);
		newUser.setContactType(1);
		newUser.setId("id");
//		UserService  userService = new UsersServiceImpl();
		UserRegister userRegister = new UserRegister();
		userRegister.registerThis(un, pw, ln, fn);
		userService.createUser(newUser);

		System.out.println("\nThank you, *" + fn + " "+ ln);
		System.out.println(" Continue to dashboard?  'yes'/'no':");
		String response = scan.next();

		UserLogin.decideDashboard(response, un);
		scan.close();

		
	}
	User registerThis(String un, String pw, String ln, String fn) {
		User newUser =  new User();
		newUser.setUserId((int) Math.round(Math.random()*100));
		newUser.setUsername(un);
		newUser.setPassword(pw);
		newUser.setLastName(ln);
		newUser.setFirstName(fn);
		newUser.setGroups(4);	// 4 = user
		newUser.setUserType(2);	// 2 = customer
		newUser.setEmail(un+"@cryptomaven.xyz");
		newUser.setOrganizationCode("999-999-9999");
		newUser.setCusUrl("http://www.dailytech.net");
		newUser.setPhotoPath("photoPath");
		newUser.setDashboardCode("dashboardCode");
		newUser.setIsActive(0);
		newUser.setContactType(1);
		newUser.setId("1");

		return newUser;
	}

}
