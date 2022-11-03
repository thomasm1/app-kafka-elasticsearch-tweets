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
        int groups = 0 != 0 ? user.getGroups() : 0;
        int userType = 0 != 0 ? user.getUserType() : 0;
        String email = user.getEmail() != null ? user.getEmail() : "";
        String phone = (user.getPhone() != null) ? user.getPhone() : "";
        String url = user.getCusUrl() != null ? user.getCusUrl() : "";
        String photoPath = user.getPhotoPath() != null ? user.getPhotoPath() : "";
        String userGroup = user.getUserGroup() != null ? user.getUserGroup() : "";
        int isActive =  user.getIsActive() != 0 ? user.getIsActive() : 0;
        int contactType =  user.getContactType() != 0 ? user.getContactType() : 0;
        String id =  user.getId() != null ? user.getId() : "";

        editLoop(user, pw, fn, ln, userType, groups, email, phone, url, photoPath, userGroup, isActive,contactType,  id);
    }
     static void editLoop(User user, String pw, String fn, String ln, int userType, int groups, String email, String phone, String url,
          String photoPath,
                          String userGroup,
                          int isActive,
                          int contactType, // ContactType contactType
                          String id
     ) {
        Scanner scan = new Scanner(System.in);

        System.out.println(WELCOME_PROFILE);
        System.out.println("1: " + EDIT_PW);
        System.out.println("2: " + EDIT_FNAME);
        System.out.println("3: " + EDIT_LNAME);
        System.out.println("4: " + EDIT_GROUP);
         System.out.println("5: " + EDIT_USERTYPE);
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
            case 9:
                System.out.println("Current photoPath: "+ photoPath);
                photoPath = scan.next();
                _earlyQuit(new String[]{photoPath});
                break;
            case 10:
                System.out.println("Current userGroup: "+ userGroup);
                userGroup = scan.next();
                _earlyQuit(new String[]{userGroup});
                break;
            case 11:
                System.out.println("Current isActive: "+ String.valueOf(isActive));
                isActive = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(isActive)});
                break;
            case 12:
                System.out.println("Current contactType: "+ contactType);
                contactType = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(contactType)});
                break;
            case 13:
                System.out.println("Current id: "+ id);
                id = scan.next();
                _earlyQuit(new String[]{id});
                break;
            case 0:
                saveProfile(user, pw, fn, ln, groups, userType,  email, phone, url, photoPath, userGroup,isActive,contactType, id);
                UserDashboard.dashboardChoice(user.getUserName());
                break;
        }
        editLoop(user, pw, fn, ln,  groups, userType, email, phone, url, photoPath, userGroup, isActive,contactType,  id);

        System.out.println("\nThank you, *" + fn + " "+ ln);
        System.out.println(" Continue to dashboard?  'yes'/'no':");

        String response = scan.next();
        UserLogin.decideDashboard(response, user.getUserName());
        scan.close();

    }

     static void saveProfile(User user, String pw, String fn, String ln,  int groups, int userType,String email, String phone, String url,
                             String photoPath,
                             String userGroup,
                             int isActive,
                             int contactType, // ContactType contactType
                             String id) {
//(username VARCHAR2, password VARCHAR2, lastName varchar2, firstName varchar2,   groups NUMBER, usertype NUMBER,
//                         email VARCHAR2, phone VARCHAR2, cusURl VARCHAR2)
        user.setPassword(pw);
        user.setFirstName(fn);
        user.setLastName(ln);
         user.setGroups(groups);
         user.setUserType(userType);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCusUrl(url);
        user.setPhotoPath(photoPath);
        user.setUserGroup(userGroup);
        user.setIsActive(isActive);
        user.setContactType(contactType);
        user.setId(id);
        System.out.println("Successfully Updated: " + UserService.updateUser(user) + "\nChanges: " + user);
    }
}
