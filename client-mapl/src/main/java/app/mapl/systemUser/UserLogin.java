package app.mapl.systemUser;


import app.mapl.consoles.AdminDashboard;
import app.mapl.models.User;
import app.mapl.service.UserService;
import app.mapl.consoles.MainDashboard;
import app.mapl.consoles.UserDashboard;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.InputMismatchException;

import static app.mapl.util.Utilities._earlyQuit; //RETURNS TO MainConsole

public class UserLogin {

    public static final String ADMIN = "admin";
    public static final String ADMIN_PASSWORD = "pass";

    public static void login() throws SQLException {

        try {
            System.out.println("Welcome, please enter your username: [admin: admin; default: joshallen]");
            System.out.println(" 'quit' to go back");
            Scanner scanner = new Scanner(System.in);
            String un = scanner.next();
            _earlyQuit(new String[]{un});
            System.out.println("and your password: [admin: pass; default: allen");
            String pw = scanner.next();
            _earlyQuit(new String[]{pw});

            //  admin   hardcoded backdoor
            if (hardCodedAdminNameAndPassword(un, pw)) {
//                User login = UserService.getUser(un);
                AdminDashboard.adminConsole(); //
            }

            // VALIDATION #1 - LOOK UP AND GET Targeted DB USER
            if (checkDbUsernameAndPassword(un, pw)) {
                decideDashboard("yes", un);
            } else {
                System.out.println("Oops, typo time, please try again");
                try {
                    login(); // login input clears for next attempt
                } catch (InputMismatchException e) {
                    e.getMessage();
                    MainDashboard.mainConsole();
                }
            }
            scanner.close();
        } catch (

                InputMismatchException e) {
            System.out.println("Oops, must choose 1 or 2... ");
        }
    }

    static void decideDashboard(String resp, String userName) {
		if (resp.matches("y|yes|true")) {
            try {
                System.out.println("...sounds good, *" + userName + "*, now logging you into your Dashboard");
                UserDashboard.dashboardChoice(userName);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                MainDashboard.mainConsole();
            }
        } else {
            MainDashboard.mainConsole();
        }
    }

    static boolean checkDbUsernameAndPassword(String un, String pw)  {
        User login = UserService.getUser(un); // returns null if not in DB
//	    VALIDATION #2 - Check targeted DB User against logged-in Username & password
        if (login != null && (un.contentEquals(
                login.getUserName()) && pw.contentEquals(
                login.getPassword()
        ))) {
            System.out.println(
                    "...grreat, password checks out! *" + un + "* #1, now logging you into your Dashboard");
            String name = (login.getFirstName() != null) ? login.getFirstName() : un;
            return true;
        }
        return false;
    }

    static boolean hardCodedAdminNameAndPassword(String un, String pw) {
        if (un.contentEquals(ADMIN) && pw.contentEquals(ADMIN_PASSWORD)) {
            System.out.println("Welcome Internal Administrator, *" + un + "*\n  " +
                    "  ... now preparing your Dashboard");
            return true;
        } else {
            return false;
        }
    }

}
