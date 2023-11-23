
package app.mapl.consoles;

import app.mapl.commands.*;
import app.mapl.dto.UserDto;
import app.mapl.models.Coin;
import app.mapl.repositories.UsersRepository;
import app.mapl.service.*;
import app.mapl.util.constants.Cmds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


@Component
public class AdminDashboard {
    private static final Logger log;

    static {
      log =  LoggerFactory.getLogger(AdminDashboard.class);

    }

    public static final int OPTION_COUNT_MAX = 7;
    private static final int MIN_OPTIONS = 0;
    private UsersRepository usersRepository;
    private CoinsService coinsService;

    private UsersServiceImpl usersService;
 
    public AdminDashboard() {};

    public AdminDashboard(CoinsServiceJPA coinsService ) {
        this.coinsService = coinsService;
    }
    public AdminDashboard(CoinsServiceJPA coinsService, UsersServiceImpl usersService ) {
        this.coinsService = coinsService;
        this.usersService = usersService; 
    }

    private static void frontConsoleMenu() {
        System.out.println("*--------- -------*\n" +
                "Welcome to your Admin dashboard\n " + " ... What's Next? \n"
                + Cmds.ONE + "  navigate User Lot\n"
                + Cmds.TWO + "navigate Coin Lot\n"
                + Cmds.THREE + "navigate Addresses\n"
                + Cmds.FOUR + "Remove Unpurchased Coin\n"
                + Cmds.FIVE + "View and/or Accept Offers\n"
                + Cmds.SIX + "get Users With Coins\n"
                + OPTION_COUNT_MAX + ".) open MaPL Control(); \n"
                + Cmds.ZERO + "Logout");
    }

    // RECURSIVE LOOP, breaks out at option 0
    public static void console()   {

        frontConsoleMenu();
        try (Scanner scan = new Scanner(System.in)) {

            AdminDashboard adminDashboard = new AdminDashboard( new CoinsServiceJPA() );
            int val = scan.nextInt();
            if (val < MIN_OPTIONS && val > OPTION_COUNT_MAX) {
                System.out.println("Please enter digits " + MIN_OPTIONS + "-" + OPTION_COUNT_MAX);
                console();
            } else {
                switch (val) {
                    case 0: {
                        System.out.println("At your service, back to MainDashboard ...\n");
                        MainDashboard.console();
                        break;
                    }
                    case 1: {
                        System.out.println("navigateUserLot");
                        System.out.println( adminDashboard.usersService.getUsers());;
                        System.out.println(Cmds.ADMIN_PERKS);
                        adminDashboard.navigateUserLot();
                        console();
                        break;
                    }
                    case 2: {
                        System.out.println("Entering Wallet View..."); 

                        adminDashboard.navigateWallet();
                        console();
                        break;

                    }
                    case 3: {
                      System.out.println("Entering Addresses View...");
                        adminDashboard.navigateAddressLot();
                        console();
                        break;
                    }
                    case 4: {
                        CoinsServiceJPA coinsService = new CoinsServiceJPA();

                        System.out.println(coinsService.getAllCoins());
                        scan.nextLine();
                        System.out.println("Removing a coin? \nLet me get my notepad ...");
                        System.out.println("\nCoin ID to be removed?");
                        while (true) {
                            try {
                                val = scan.nextInt();
                                Coin uCoin = coinsService.getCoinCLI(val);
                                scan.nextLine();
                                System.out.println("1.) Remove coin #" + uCoin.getCoinId() + "? Type \"y\" or \"yes\"."
                                        + "\n\n2.)To permanently delete from records?\n" + "If so, type \"delete\" \n");

                                String decide = scan.next();
                                if ((decide.contentEquals("y")) | (decide.contentEquals("yes"))) {
                                    Coin removeCoin = new Coin(uCoin.getCoinId(), uCoin.getCoinToken(), uCoin.getCoinSymbol(),
                                            uCoin.getPriceTotal(), 2); // 2 = remove unpurchased
                                    try {
                                        coinsService.updateCoinCLI(removeCoin);
                                        System.out.println(removeCoin.toString() + "\n" + " ...\n..#" + uCoin.getCoinId()
                                                + " Successfully removed!!\n");

                                    } catch (Exception e) {
                                        System.out.println("Oops, something went wrong, try again please\n");
                                    }
                                } else if (decide.contentEquals("delete")) {// delete & unpurchased
                                    try {
                                        int deleted = uCoin.getCoinId();
                                        coinsService.deleteCoin(deleted);
                                        System.out.println("\n" + "\n...#" + deleted + " Permanently deleted!\n");

                                    } catch (Exception e) {
                                        System.out.println("Oops, something went wrong, try again please\n");
                                    }
                                } else {
                                    System.out.println("Not implemented, returning to dashboard");
                                    console();
                                }
                            } catch (Exception e) {
                                System.out.println("I could not find that coin ...\nTry again. Here's the current lot:");
                                List<Coin> coinList = coinsService.getAllCoinsCLI();
                                System.out.println(coinList);
                                console();
                            }
                            console();
                        }
                    }
                    case 5: {
                        System.out.println("OfferService.getAllOffers()");
                        console();
                        break;
                    }
                    case 6: {
//                        UsersServiceImpl u = new UsersServiceImpl();
//
//                        console();
                        break;
                    }
                    case OPTION_COUNT_MAX: {
                        System.out.println("Opening MaPLControl...");
                        MaPLAdminInvoker newMaPLInvokerl = new MaPLAdminInvoker(""); // create new MaPLInvoker

                        NavigateRunner open = new NavigateRunner(newMaPLInvokerl); // open MaPLControl

                        open.runNavigate();
                        console();
                        break;
                    }
                } // end switch
            }
        } catch (InputMismatchException e ) {
            // go round again. Read past the end of line in the input first
            System.out.println("Please enter digits 0 to 5");
            console();
        }
    }

    public static void adminConsole() {
    }

    private void navigateAddressLot()  {
        System.out.println("NavigateAddressLot()");
        System.out.println("1.) View AddressLot");
        System.out.println("2.) Add Address to AddressLot");
        System.out.println("3.) Remove Address from AddressLot");
        System.out.println("4.) Update Address in AddressLot");
        System.out.println("5.) Return to Admin Dashboard");
        System.out.println("6.) Exit MaPL");

        System.out.println("Enter a number to navigate: ");

//        TODO: implement AddressLot navigation logic WITHOUT DUPLICATING CODE
        try (Scanner scan = new Scanner(System.in)) {
            int val = scan.nextInt();
            if (val < MIN_OPTIONS && val > OPTION_COUNT_MAX) {
                System.out.println("Please enter digits " + MIN_OPTIONS + "-" + OPTION_COUNT_MAX);
                console();
            } else {
                switch (val) {
                    case 1: {
                        System.out.println("View AddressLot");
                        break;
                    }
                    case 2: {
                        System.out.println("Add Address to AddressLot");
                        break;
                    }
                    case 3: {
                        System.out.println("Remove Address from AddressLot");
                        break;
                    }
                    case 4: {
                        System.out.println("Update Address in AddressLot");
                        break;
                    }
                    case 5: {
                        System.out.println("Return to Admin Dashboard");
                        console();
                        break;
                    }
                    case OPTION_COUNT_MAX: {
                        System.out.println("Opening MaPLControl...");
                        MaPLAdminInvoker newMaPLInvokerl = new MaPLAdminInvoker(""); // create new MaPLInvoker

                        NavigateRunner open = new NavigateRunner(newMaPLInvokerl); // open MaPLControl

                        open.runNavigate();
                        console();
                        break;
                    }
                } // end switch
            }
        } catch (InputMismatchException e) {
        }
    }

    private void navigateUserLot()   {

        System.out.println("1.) View UserLot");
        System.out.println("2.) Add User to UserLot");
        System.out.println("3.) Remove User from UserLot");
        System.out.println("4.) Update User in UserLot");
        System.out.println("5.) Return to Admin Dashboard");
        System.out.println("6.) Exit MaPL");

        System.out.println("Enter a number to navigate: ");

        try (Scanner scan = new Scanner(System.in)) {
            int val = scan.nextInt();
            if (val < MIN_OPTIONS && val > OPTION_COUNT_MAX) {
                System.out.println("Please enter digits " + MIN_OPTIONS + "-" + OPTION_COUNT_MAX);
                console();
            } else {
                switch (val) {
                    case 1: {
                        System.out.println("View UserLot");
                        System.out.println(this.usersService.getUsers());
                        console();
                        break;
                    }
                    case 2: {
                        scan.nextLine();
                        System.out.println("Adding a user? Let me get my notepad ...");
                        System.out.println("User ID?");
                        while (true) {
                            try {
                                scan.nextInt();
                                scan.nextLine();
                                System.out.println("User Username?");
                                String username = scan.nextLine();
                                System.out.println("User Password?");
                                String password = scan.nextLine();
                                System.out.println("User First Name?");
                                String firstName = scan.nextLine();
                                System.out.println("User Last Name?");
                                String lastName = scan.nextLine();
                                System.out.println("User Email?");
                                String email = scan.nextLine();
                                System.out.println("User Role?");
                                String role = scan.nextLine();
                                System.out.println("Umkay, user's username is *" + username + "*,\n password is *" + password
                                        + "*,\n first name is *" + firstName + "*,\n last name is *" + lastName
                                        + "*,\n email is *" + email + "*,\n and role is *" + role + "*\n");
                                System.out.println("   Everything look right? (y) or (no)\n");
                                while (true) {
                                    String decide = scan.next();
                                    if (decide.contentEquals("y")) {
                                        UserDto createdUser =  new UserDto();
                                        createdUser.setUsername(username);
                                        createdUser.setPassword(password);
                                        createdUser.setFirstName(firstName);
                                        createdUser.setLastName(lastName);
                                        createdUser.setEmail(email);
                                        this.usersService.createUser(createdUser);
                                    } else if (decide.contentEquals("no")) {
                                        System.out.println("Okay, let's try again");
                                        console();
                                    } else {
                                        System.out.println("I didn't understand that, try again");
                                        console();
                                    }
                                }
                            } catch (InputMismatchException e) {
                                System.out.println("Please enter digits 0 to 5");
                                console();
                            }
                        console();
                        break;
                        }
                    }
                    case 3: {
                        System.out.println("Remove User from UserLot");
                        console();
                        break;
                    }
                    case 4: {
                        System.out.println("Update User in UserLot");
                        console();
                        break;
                    }
                    case 5: {
                        System.out.println("Return to Admin Dashboard");
                        console();
                        break;
                    }
                    case 6: {
                        System.out.println("Exit MaPL");
                        System.exit(0);
                        break;
                    }
                } // end switch

            }       // end else
            }   // end tr
    }   // end method



    private void navigateWallet()  {
        System.out.println("NavigateLot()");

        System.out.println("1.) View Wallet");
        System.out.println("2.) Add Coin to Wallet");
        System.out.println("3.) Remove Coin from Wallet");
        System.out.println("4.) Update Coin in Wallet");
        System.out.println("5.) Return to Admin Dashboard");
        System.out.println("6.) Exit MaPL");

        System.out.println("Enter a number to navigate: ");

        try (Scanner scan = new Scanner(System.in)) {
            int val = scan.nextInt();
            if (val < MIN_OPTIONS && val > OPTION_COUNT_MAX) {
                System.out.println("Please enter digits " + MIN_OPTIONS + "-" + OPTION_COUNT_MAX);
                console();
            } else {
                switch (val) {
                    case 1: {
                        System.out.println("View Wallet");
                        CoinsServiceJPA coinsService = new CoinsServiceJPA();
                        System.out.println(coinsService.getAllCoins());
                        System.out.println("==========================");
                        System.out.println();
                        break;
                    }
                    case 2: {

                        CoinsServiceJPA coinsService = new CoinsServiceJPA();

                        scan.nextLine();
                        System.out.println("Adding a coin? Let me get my notepad ...");
                        System.out.println("Coin ID?");
                        while (true) {
                            try {
                                scan.nextInt();
                                scan.nextLine();
                                System.out.println("Coin TOKEN?");
                                String coinToken = scan.nextLine();
                                System.out.println("Coin Symbol?");
                                String coinSymbol = scan.nextLine();
                                System.out.println("Coin Amoun?");
                                double price = scan.nextDouble();
                                scan.nextLine();
                                if (price > 0) {
                                    System.out.println("price must be >0, please."); 
                                    price = scan.nextDouble();
                                    scan.nextLine();
                                }
                                System.out.println("Umkay,coin's coinToken is *" + coinToken + "*,\n coinSymbol is *" + coinSymbol
                                        + "*,\n and price at *$" + price + "*\n");
                                System.out.println("   Everything look right? (y) or (no)\n");
                                while (true) {
                                    String decide = scan.next();
                                    if (decide.contentEquals("y")) {
                                        Coin createdCoin = new Coin(999, coinToken, coinSymbol, price, 0); //CoinId overwritten later

                                        coinsService.createCoinCLI(createdCoin);
                                        System.out.println(
                                                "This " + createdCoin.getCoinToken() + " has been Successfully added!!\n");
                                        console();
                                    } else {
                                        console();
                                    }
                                }
                            } catch (Exception e) {
                                System.out.println(Cmds.OOPS_TRY_AGAIN);
                            }
                        console();
                        break;
                        }
                    }
                    case 3: {
                        System.out.println("Remove Coin from Wallet");
                        break;
                    }
                    case 4: {
                        System.out.println("Update Coin in Wallet");
                        break;
                    }
                    case 5: {
                        System.out.println("Return to Admin Dashboard");
                        break;
                    }
                    case 6: {
                        System.out.println("Exit MaPL");
                        break;
                    }
                }
            }
        } catch (InputMismatchException e ) {
            // go round again. Read past the end of line in the input first
            System.out.println("Please enter digits 0 to 5");
            console();
        }
    }

}
