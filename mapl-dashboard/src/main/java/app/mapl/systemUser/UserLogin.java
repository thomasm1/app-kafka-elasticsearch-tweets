package app.mapl.systemUser;


import app.mapl.consoles.MainDashboard;

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
                MainDashboard.mainConsole();
            }

            scanner.close();
        } catch (

                InputMismatchException e) {
            System.out.println("Oops, must choose 1 or 2... ");
        }
    }

    static void decideDashboard(String resp, String username) {
		if (resp.matches("y|yes|true")) {
            try {
                System.out.println("...sounds good, *" + username + "*, now logging you into your Dashboard");
                MainDashboard.mainConsole();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                MainDashboard.mainConsole();
            }
        } else {
            MainDashboard.mainConsole();
        }
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
