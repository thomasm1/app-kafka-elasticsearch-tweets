package app.mapl.consoles;

import app.mapl.models.Coin;
import app.mapl.service.CoinsServiceJPA;
import app.mapl.service.UsersServiceJPA;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import static app.mapl.util.Utilities._earlyQuit;
import static app.mapl.util.constants.Cmds.*;


@Component
@RequiredArgsConstructor
public class UserDashboard {

    static UsersServiceJPA usersServiceImpl;
    private static final int MENU_FIRST = 0;
    public static final int MENU_LAST = 7;


    // RECURSIVE LOOP, breaks out at option 0

    private static void frontConsoleMenu() {
        System.out.println("\n Welcome to your Dashboard! *b*, ");
        System.out.println(WHAT_TO_DO);

        System.out.println("4: " + MAKE_AN_OFFER);
        System.out.println("5: " + MAKE_INQUIRY_MY_OFFERS);
        System.out.println("6: " + EDIT_MY_PROFILE);
        System.out.println("0: " + LEAVE_MENU);
    }

    /**
     * @param email
     */
    public static void console(String email) {


        System.out.println("Now Loading frontConsoleMenu()");
        frontConsoleMenu();
        try (Scanner scan = new Scanner(System.in)) {
            int val = scan.nextInt();
            if (val < MENU_FIRST || val > MENU_LAST) {
                System.out.println(OOPS_OPTIONS);
                val = scan.nextInt();
                scan.nextLine();
            } else {
                switch (val) {
                    case 1: {
                        try {
                            CoinsServiceJPA coinService = new CoinsServiceJPA();

                            List<Coin> coinList = coinService.getAllCoinsCustCLI();
                            System.out.println(COINMARKET_TITLE);
                            System.out.println(coinList);
                            System.out.println("4: " + PRESS_DIGIT);
                            System.out.println();
                        } catch (Exception e) {
                            console(email);
                        }
                        console(email);
                    }
                    case 2: {
                        CoinsServiceJPA coinService = new CoinsServiceJPA();
                        try {
                            List<Coin> coinList = coinService.getAllCoinsCustCLI();
                            System.out.println(COINMARKET_TITLE);
                            System.out.println(coinList);
                            System.out.println("4: " + PRESS_DIGIT);
                            System.out.println();
                        } catch (Exception e) {
                            console(email);
                        }
                        console(email);
                    }
                    case 3: {
                        CoinsServiceJPA coinService = new CoinsServiceJPA();
                        try {
                            List<Coin> coinList = coinService.getAllCoinsCustCLI();
                            System.out.println(coinList);
                            scan.nextLine();
                            System.out.println("Which coin #?");
                            int id = scan.nextInt();
                            scan.nextLine();
                            Coin newest = coinService.getCoinCLI(id);
                            System.out.println(newest);
                            System.out.println("\n Coin #" + id +
                                    NICE + PRESS_DIGIT + FOUR);
                        } catch (Exception e) {
                            console(email);
                        }
                        console(email);
                    }
                    case 4: {
                        CoinsServiceJPA coinService = new CoinsServiceJPA();
                        try {
                            List<Coin> coinList = coinService.getAllCoinsCustCLI();
                            System.out.println("e-Coins Lot:");
                            System.out.println(coinList);
                            System.out.println("\nOk, type in the Coin ID to begin.\n"
                                    + " ...change your mind? press 'no' (or any letter)");
                            val = scan.nextInt();

                            Coin newest = coinService.getCoinCLI(val);
                            System.out.println("Voila, coin id #" + val + "\n");
                            System.out.println(newest);

                            scan.nextLine();
                            System.out.println("\nHow much, $xxxx.xx can you put down?  ");
                            double down = scan.nextDouble();
                            while (down > newest.getPriceTotal()) {
                                System.out.println("Oops, that's more than the coin price!");
                                down = scan.nextDouble();
                            }
                            scan.nextLine();
                            System.out.println(HOW_MANY_MONTHS);
                            int mos = scan.nextInt();
//				Offer offering = new Offer(777, email, val, down, mos, "PENDING");
//				 /////////////////////////////////////////////////////////////////
//				System.out.println(OfferService.createOffer(offering));
                            System.out.println(NICE + " $" + down + " down, over *" + mos + "* months\n"
                                    + "We'll let you know in less than 24 hours!!\n");
                        } catch (Exception e) {
                            console(email);
                        }
                        console(email);
                    }
                    case 5: {
                        try {
//				List<Offer> offerList = OfferService.getAllOffersCust(email);
// 				for (Offer offer : offerList) {
//					System.out.println(offer);
//				}
                            System.out.println("Pressed 5");
                        } catch (Exception e) {
                            console(email);
                        }
                        console(email);
                    }
                    case 6: {
                        try {
                            UserProfileTool.editProfile(usersServiceImpl.getUserByEmail(email).orElseThrow());

                        } catch (Exception e) {
                            console(email);
                        }
                        console(email);
                    }
                    case MENU_LAST: {
                        System.out.println("Opening MaPLControl...");
                        console("UserDashboard");
                        break;
                    }
                    case 0: {
                        System.out.println(GOOD_BYE);
                        MainDashboard.console();
                        break;
                    }
                }
            }
            console(email);
        }

    }

    @Data
    static class UserLogin {

        @Value("${spring.datasource.email}")
        private static String email;

        @Value("${spring.datasource.password}")
        private static String password_var;

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
                } else {
                    MainDashboard.console();
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

        private static boolean checkDbUsernameAndPassword(String un, String pw) {
            return false;
        }

        private static boolean hardCodedAdminNameAndPassword(String email, String pw) {
            return (email.equalsIgnoreCase(email) && pw.equalsIgnoreCase(password_var));
        }

        static void decideDashboard(String resp, String email) {
            if (resp.matches("y|yes|true")) {
                try {
                    System.out.println("...sounds good, *" + email + "*, now logging you into your Dashboard");
                    console(email);
                } catch (InputMismatchException e) {
                    System.out.println(e.getMessage());
                    MainDashboard.console();
                }
            } else {
                MainDashboard.console();
            }
        }

        public Object getEmail() {
        return email;
        }
    }
}
