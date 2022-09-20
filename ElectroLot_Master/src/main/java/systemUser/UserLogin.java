package systemUser;


import models.User;
import service.UserService; 

import java.util.Scanner;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class UserLogin {

	public static void login() throws SQLException {

		String adminUsername = "admin";
		String adminPassword = "pass";

		String tempUsername = "cust";
		String tempPassword = "pass";
		try {
			System.out.println("Welcome, please enter your username:");
			Scanner scanner = new Scanner(System.in);
			String un = scanner.next();

			System.out.println("and your password:");
			String pw = scanner.next();

			User login = UserService.getUser(un);

			if (un.contentEquals(adminUsername) && pw.contentEquals(adminPassword)) {
				System.out.println("Welcome Administrator, *" + un + "*\n    ... now preparing your Dashboard");
				AdminDashboard.loginDashboard(un); //
			} else if ((un.contentEquals(tempUsername) && pw.contentEquals(tempPassword))
					| (un.contentEquals(login.getUsername()) && pw.contentEquals(login.getPassword()))) {
				System.out.println(
						"...grreat, password checks out! *" + un + "* #1, now logging you into your Dashboard");
				CarsDashboard.loginDashboard(un); //
			} else {
				System.out.println("Oops, typo time, please try again");
				try {
					login();
				} catch (Exception e) {
					UserMain.frontConsole();
				}
			}
			scanner.close();

		} catch (

		InputMismatchException e) {

			System.out.println("Oops, must choose 1 or 2... ");
		}
	}

}
