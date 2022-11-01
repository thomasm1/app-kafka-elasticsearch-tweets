package xyz.cryptomaven.app.systemUser;

import xyz.cryptomaven.app.consoles.UserDashboard;
import xyz.cryptomaven.app.models.User;
import xyz.cryptomaven.app.service.UserService;

import java.util.Scanner;

import static xyz.cryptomaven.app.constants.Cmds.*;
import static xyz.cryptomaven.app.util.Utilities._earlyQuit; // RETURNS TO MainConsole

public class UserProfile {

    public static void editProfile(User user) {
        System.out.println("editProfile "  + user);
        String pw = user.getPassword() != null ? user.getPassword() : "";
        String fn = user.getFirstName() != null ? user.getFirstName() : "";
        String ln = user.getLastName() != null ? user.getLastName() : "";
        int userType = 0 != 0 ? user.getUserType() : 0;
        int groups = 0 != 0 ? user.getGroups() : 0;
        String email = user.getEmail() != null ? user.getEmail() : "";
        String phone = (user.getPhone() != null) ? user.getPhone() : "";
        String url = user.getCusUrl() != null ? user.getCusUrl() : "";

        editLoop(user, pw, fn, ln, userType, groups, email, phone, url);
    }
     static void editLoop(User user, String pw, String fn, String ln, int userType, int groups, String email, String phone, String url) {
        Scanner scan = new Scanner(System.in);

        System.out.println(WELCOME_PROFILE);
        System.out.println("1: " + EDIT_PW);
        System.out.println("2: " + EDIT_FNAME);
        System.out.println("3: " + EDIT_LNAME);
        System.out.println("4: " + EDIT_USERTYPE);
        System.out.println("5: " + EDIT_GROUP);
        System.out.println("6: " + EDIT_EMAIL);
        System.out.println("7: " + EDIT_PHONE);
        System.out.println("8: " + EDIT_URL);
        System.out.println("0: " + ": Finished, go back");
        int Choice = scan.nextInt();
        System.out.printf("'%S' %n", "Enter your edit");

        switch (Choice) {
            case 1:
                System.out.println("Current pw: "+ pw);
                pw = scan.next();
                _earlyQuit(new String[]{pw});
                break;
            case 2:
                System.out.println("Current fn: "+ fn);
                fn = scan.next();
                _earlyQuit(new String[]{fn});
                break;
            case 3:
                System.out.println("Current ln: "+ ln);
                ln = scan.next();
                _earlyQuit(new String[]{ln});
                break;
            case 4:
                System.out.println("Current userType: "+ userType);
                userType = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(userType)});
                break;
            case 5:
                System.out.println("Current groups: "+ groups);
                groups = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(groups)});
                break;
            case 6:
                System.out.println("Current email: "+ email);
                email = scan.next();
                _earlyQuit(new String[]{email});
                break;
            case 7:
                System.out.println("Current phone: "+ phone);
                phone = scan.next();
                _earlyQuit(new String[]{phone});
                break;
            case 8:
                System.out.println("Current url: "+ url);
                url = scan.next();
               _earlyQuit(new String[]{url});
                break;
            case 0:
                saveProfile(user, pw, fn, ln, userType, groups, email, phone, url);
                UserDashboard.dashboardChoice(user.getUsername());
                break;
        }
        editLoop(user, pw, fn, ln, userType, groups, email, phone, url);

        System.out.println("\nThank you, *" + fn + " "+ ln);
        System.out.println(" Continue to dashboard?  'yes'/'no':");

        String response = scan.next();
        UserLogin.decideDashboard(response, user.getUsername());
        scan.close();

    }

     static void saveProfile(User user, String pw, String fn, String ln, int userType, int groups, String email, String phone, String url) {
//(username VARCHAR2, password VARCHAR2, lastName varchar2, firstName varchar2, usertype NUMBER,
//                          groups NUMBER, email VARCHAR2, phone VARCHAR2, cusURl VARCHAR2)
        user.setPassword(pw);
        user.setFirstName(fn);
        user.setLastName(ln);
        user.setUserType(userType);
        user.setGroups(groups);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCusUrl(url);
        System.out.println("Successfully Updated: " + UserService.updateUser(user) + "\nChanges: " + user);
    }
}
