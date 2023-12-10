package app.mapl.consoles;


import app.mapl.consoles.AdminDashboard;
import app.mapl.consoles.MainDashboard;
import app.mapl.consoles.UserDashboard;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import static app.mapl.config.security.SecurityConfig.checkDbUsernameAndPassword;
import static app.mapl.config.security.SecurityConfig.hardCodedAdminNameAndPassword;
import static app.mapl.util.Utilities._earlyQuit;

@Component
public class UserLogin {


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
                AdminDashboard.console(); //
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
                    MainDashboard.console();
                }
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
                UserDashboard.console(username);
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                MainDashboard.console();
            }
        } else {
            MainDashboard.console();
        }
    }



}
