package app.mapl.consoles;

import app.mapl.dto.UserDto;
import app.mapl.service.UsersServiceJPA;
import jakarta.persistence.*;
import lombok.*;

import java.util.Scanner;

import static app.mapl.util.Utilities._earlyQuit;
import static app.mapl.util.constants.Cmds.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UserProfileTool {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email;
    private String dashboardCode;
    private String organizationCode;


    public static void editProfile(UserDto user) {
        System.out.println("editProfile " + user);
        String pw = user.getPassword() != null ? user.getPassword() : "";
        String fn = user.getFirstName() != null ? user.getFirstName() : "";
        String ln = user.getLastName() != null ? user.getLastName() : "";
        int userType = 0 != 0 ? user.getUserType() : 2;
        String email = user.getEmail() != null ? user.getEmail() : "";
        String organizationCode = (user.getOrganizationCode() != null) ? user.getOrganizationCode() : "";

        String dashboardCode = user.getDashboardCode() != null ? user.getDashboardCode() : "";


        System.out.println(user + pw + ln + fn + userType + organizationCode + email +  dashboardCode );
        editLoop(user, pw, ln, fn, userType, organizationCode, email,  dashboardCode);
    }

    private static void editLoop(UserDto user, String pw, String ln, String fn, int userType, String organizationCode, String email, String dashboardCode) {
    }

    static void editLoop(UserDto user, String pw, String ln, String fn, int userType, String organizationCode, String email, String imageUrl, String dashboardCode, int isActive, int contactType) {
        Scanner scan = new Scanner(System.in);

        System.out.println(WELCOME_PROFILE);
        System.out.println("1: " + EDIT_PW);
        System.out.println("2: " + EDIT_LNAME);
        System.out.println("3: " + EDIT_FNAME);
        System.out.println("4: " + EDIT_GROUP);
        System.out.println("5: " + EDIT_USERTYPE);
        System.out.println("6: " + EDIT_ORGANIZATIONCODE);
        System.out.println("7: " + EDIT_EMAIL);
        System.out.println("8: " + EDIT_URL);
        System.out.println("9: " + "Edit DashboardCode");
        System.out.println("10: " + "Edit UserGroup");
        System.out.println("11: " + "isActive");
        System.out.println("12: " + "ContactType");
        System.out.println("13: " + "ID");
        System.out.println("0: " + ": Finished, go back");
        int Choice = scan.nextInt();
        System.out.printf("'%S' %n", "Enter your edit");

        switch (Choice) {
            case 1:
                System.out.println("Current pw: " + pw);
                pw = scan.next();
                _earlyQuit(new String[]{pw});
                break;
            case 2:
                System.out.println("Current ln: " + ln);
                ln = scan.next();
                _earlyQuit(new String[]{ln});
                break;
            case 3:
                System.out.println("Current fn: " + fn);
                fn = scan.next();
                _earlyQuit(new String[]{fn});
                break;
            case 4:
                System.out.println("Current userType: " + userType);
                userType = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(userType)});
                break;
            case 5:
                System.out.println("Current organizationCode: " + organizationCode);
                organizationCode = scan.next();
                _earlyQuit(new String[]{organizationCode});
                break;
            case 6:
                System.out.println("Current email: " + email);
                email = scan.next();
                _earlyQuit(new String[]{email});
                break;
            case 7:
                System.out.println("Current url: " + imageUrl);
                imageUrl = scan.next();
                _earlyQuit(new String[]{imageUrl});
                break;
            case 8:
                System.out.println("Current dashboardCode: " + dashboardCode);
                dashboardCode = scan.next();
                _earlyQuit(new String[]{dashboardCode});
                break;
            case 11:
                System.out.println("Current isActive: " + isActive);
                isActive = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(isActive)});
                break;
            case 12:
                System.out.println("Current contactType: " + contactType);
                contactType = scan.nextInt();
                _earlyQuit(new String[]{String.valueOf(contactType)});
                break;
            case 0:
                System.out.println("saveProfile" + user + pw + ln + fn + userType + organizationCode + email + imageUrl + dashboardCode + isActive + contactType);
                saveProfile(user, pw, ln, fn, userType, organizationCode, email, imageUrl, dashboardCode, isActive, contactType);

                UserDashboard.console(user.getEmail());
                break;
        }
        editLoop(user, pw, ln, fn, userType, organizationCode, email, imageUrl, dashboardCode, isActive, contactType);

        System.out.println("\nThank you, *" + fn + " " + ln);
        System.out.println(" Continue to dashboard?  'yes'/'no':");

        String response = scan.next();
        UserDashboard.UserLogin.decideDashboard(response, user.getEmail());
        scan.close();

    }

    static void saveProfile(UserDto user, String pw, String ln, String fn, int userType, String organizationCode, String email, String imageUrl, String dashboardCode, int isActive, int contactType) {

        user.setPassword(pw);
        UserDto userDto = new UserDto();
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(fn);
        userDto.setLastName(ln);
        userDto.setUserType(userType);
        userDto.setOrganizationCode(organizationCode);
        userDto.setEmail(email);



        UsersServiceJPA usersService = new UsersServiceJPA();
        System.out.println("Successfully Updated: " + usersService.updateUser(user) + "\nChanges: " + user);
    }

}
