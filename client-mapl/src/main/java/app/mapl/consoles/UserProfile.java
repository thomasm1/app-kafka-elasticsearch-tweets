package app.mapl.consoles;

import app.mapl.dto.UserDto;
import app.mapl.mapper.UserMapper;
import app.mapl.repositories.UsersRepository;
import app.mapl.service.UsersServiceImpl;

import java.util.Scanner;

import static app.mapl.util.Utilities._earlyQuit;
import static app.mapl.util.constants.Cmds.*;

public class UserProfile {


    UsersRepository usersRepository;


    private UserMapper userMapper;

    public UserProfile(UsersRepository usersRepository, UserMapper userMapper) {
        this.usersRepository = usersRepository;
        this.userMapper = userMapper;
    }

    public static void editProfile(UserDto user) {
        System.out.println("editProfile "  + user);
        String pw = user.getPassword() != null ? user.getPassword() : "";
        String fn = user.getFirstName() != null ? user.getFirstName() : "";
        String ln = user.getLastName() != null ? user.getLastName() : "";
        int userType = 0 != 0 ? user.getUserType() : 2;
        String email = user.getEmail() != null ? user.getEmail() : "";
        String phone = (user.getPhone() != null) ? user.getPhone() : "";
        String cusurl = user.getCusUrl() != null ? user.getCusUrl() : "";
        String photoPath = user.getPhotoPath() != null ? user.getPhotoPath() : "";
        int isActive =  user.getIsActive() != 0 ? user.getIsActive() : 1;
        int contactType =  user.getContactType() != 0 ? user.getContactType() : 0;

        System.out.println(user+ pw+ ln+ fn + userType +  phone + email+ cusurl+ photoPath+  isActive+contactType );
        editLoop(user, pw, ln,fn, userType,  phone,email, cusurl, photoPath,  isActive,contactType );
    }
     static void editLoop(UserDto user, String pw, String ln,String fn, int userType,  String phone,String email,  String cusurl, String photoPath,
                          int isActive,  int contactType
     ) {
        Scanner scan = new Scanner(System.in);

        System.out.println(WELCOME_PROFILE);
        System.out.println("1: " + EDIT_PW);
        System.out.println("2: " + EDIT_LNAME);
         System.out.println("3: " + EDIT_FNAME);
        System.out.println("4: " + EDIT_GROUP);
         System.out.println("5: " + EDIT_USERTYPE);
        System.out.println("6: " + EDIT_PHONE);
         System.out.println("7: " + EDIT_EMAIL);
        System.out.println("8: " + EDIT_URL);
         System.out.println("9: " + "Edit PhotoPath");
         System.out.println("10: " + "Edit UserGroup");
         System.out.println("11: " + "isActive");
         System.out.println("12: " + "ContactType");
         System.out.println("13: " + "ID");
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
                System.out.println("Current ln: "+ ln);
                ln = scan.next();
                _earlyQuit(new String[]{ln});
                break;
            case 3:
                System.out.println("Current fn: "+ fn);
                fn = scan.next();
                _earlyQuit(new String[]{fn});
                break;
            case 4:
                System.out.println("Current userType: "+ userType);
                userType = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(userType)});
                break;
            case 5:
                System.out.println("Current phone: "+ phone);
                phone = scan.next();
                _earlyQuit(new String[]{phone});
                break;
            case 6:
                System.out.println("Current email: "+ email);
                email = scan.next();
                _earlyQuit(new String[]{email});
                break;
            case 7:
                System.out.println("Current url: "+ cusurl);
                cusurl = scan.next();
               _earlyQuit(new String[]{cusurl});
                break;
            case 8:
                System.out.println("Current photoPath: "+ photoPath);
                photoPath = scan.next();
                _earlyQuit(new String[]{photoPath});
                break;
            case 11:
                System.out.println("Current isActive: "+ isActive);
                isActive = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(isActive)});
                break;
            case 12:
                System.out.println("Current contactType: "+ contactType);
                contactType = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(contactType)});
                break;
            case 0:
                System.out.println("saveProfile"+  user+ pw+ ln+fn+  userType+  phone+email+ cusurl+ photoPath+   isActive+contactType );
                saveProfile(user, pw,  ln, fn,  userType, phone,  email, cusurl, photoPath, isActive,contactType );

                UserDashboard.console(user.getUsername());
                break;
        }
        editLoop(user, pw, ln, fn, userType,  phone, email, cusurl, photoPath, isActive, contactType );

        System.out.println("\nThank you, *" + fn + " "+ ln);
        System.out.println(" Continue to dashboard?  'yes'/'no':");

        String response = scan.next();
        UserLogin.decideDashboard(response, user.getUsername());
        scan.close();

    }

     static void saveProfile(UserDto user, String pw,  String ln, String fn,   int userType, String phone, String email,String cusurl, String photoPath,
                      int isActive,    int contactType ) {
//(username VARCHAR2, password VARCHAR2, lastName varchar2, firstName varchar2,   groups NUMBER, usertype NUMBER,
//                         email VARCHAR2, phone VARCHAR2, cusURl VARCHAR2)
        user.setPassword(pw);
        UserDto userDto = new UserDto();
        userDto.setUsername(user.getUsername());
//        user.setFirstName(fn);
//        user.setLastName(ln);
//         user.setGroups(groups);
//         user.setUserType(userType);
//        user.setEmail(email);
//        user.setPhone(phone);
//        user.setCusUrl(cusurl);
//        user.setPhotoPath(photoPath);
//        user.setUserGroup(userGroup);
//        user.setIsActive(isActive);
//        user.setContactType(contactType);
//        user.setId(id);

        UsersServiceImpl usersService = new UsersServiceImpl();
        System.out.println("Successfully Updated: " + usersService.updateUser(user) + "\nChanges: " + user);
    }

}
