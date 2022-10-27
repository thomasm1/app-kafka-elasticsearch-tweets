package xyz.cryptomaven.app.systemUser;


import xyz.cryptomaven.app.consoles.AdminDashboard;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.service.UserService;
import xyz.cryptomaven.app.consoles.MainDashboard;
import xyz.cryptomaven.app.consoles.UserDashboard;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.InputMismatchException;

public class UserLogin {

    public static void login() throws SQLException {

        try {
            System.out.println("Welcome, please enter your username: [admin: admin; default: joshallen]");
            Scanner scanner = new Scanner(System.in);
            String un = scanner.next();

            System.out.println("and your password: [admin: pass; default: allen");
            String pw = scanner.next();

            //  admin   hardcoded backdoor
            if (hardCodedAdminNameAndPassword(un, pw)) {
                User login = UserService.getUser(un);
                AdminDashboard.loginDashboard(un, login.getFirstName()); //
            }

            // VALIDATION #1 - LOOK UP AND GET Targeted DB USER
            if (checkDbUsernameAndPassword(un, pw)) {
                User login = UserService.getUser(un);
                UserDashboard.loginDashboard(un, login.getFirstName()); //
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

    public static boolean checkDbUsernameAndPassword(String un, String pw) throws SQLException {
        User login = UserService.getUser(un);
//	    VALIDATION #2 - Check targeted DB User against logged-in Username & password
        if (un.contentEquals(
                login.getUsername()) && pw.contentEquals(
                login.getPassword()
        )) {
            System.out.println(
                    "...grreat, password checks out! *" + un + "* #1, now logging you into your Dashboard");
            String name = (login.getFirstName() != null) ? login.getFirstName() : un;
            return true;
        }
        return false;
    }

    public static boolean hardCodedAdminNameAndPassword(String un, String pw) {
        String adminUsername = "admin";
        String adminPassword = "pass";
        if (un.contentEquals(adminUsername) && pw.contentEquals(adminPassword)) {
            System.out.println("Welcome Internal Administrator, *" + un + "*\n  " +
                    "  ... now preparing your Dashboard");
            return true;
        } else {
            return false;
        }
    }

}
