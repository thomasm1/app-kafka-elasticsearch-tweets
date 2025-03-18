
package app.mapl.consoles;
 
import app.mapl.models.dto.ChainDto;
import app.mapl.models.dto.UserDto;
import app.mapl.repositories.UsersRepository;
import app.mapl.services.ChainsService;
import app.mapl.services.ChainsServiceImpl;
import app.mapl.services.UsersServiceImpl;
import app.mapl.util.constants.Cmds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Scanner;


@Component
public class AdminDashboard {
    private static final Logger log;

    static {
      log =  LoggerFactory.getLogger(AdminDashboard.class); }

    public static final int OPTION_COUNT_MAX = 7;
    private static final int MIN_OPTIONS = 0;
    private UsersRepository usersRepository;
    private ChainsService chainsService;

    private UsersServiceImpl usersService;
 
    public AdminDashboard() {};

    public AdminDashboard(ChainsServiceImpl chainsService ) {
        this.chainsService = chainsService;
    }
    public AdminDashboard(ChainsServiceImpl chainsService, UsersServiceImpl usersService ) {
        this.chainsService = chainsService;
        this.usersService = usersService; 
    }

    private static void frontConsoleMenu() {
        System.out.println("*--------- -------*\n" +
                "Welcome to your Admin dashboard\n " + " ... What's Next? \n"
                + Cmds.ONE + "  navigate User Lot\n"
                + Cmds.TWO + "navigate Chain Lot\n"
                + Cmds.THREE + "navigate Addresses\n"
                + Cmds.FOUR + "Remove Unpurchased Chain\n"
                + Cmds.FIVE + "View and/or Accept Offers\n"
                + Cmds.SIX + "get Users With Chains\n"
                + OPTION_COUNT_MAX + ".) open MaPL Control(); \n"
                + Cmds.ZERO + "Logout");
    }

    // RECURSIVE LOOP, breaks out at option 0
    public static void console()   {

        frontConsoleMenu();
        try (Scanner scan = new Scanner(System.in)) {

            AdminDashboard adminDashboard = new AdminDashboard(  new ChainsServiceImpl() , new UsersServiceImpl() );
            int val = scan.nextInt();
            if (val < MIN_OPTIONS && val > OPTION_COUNT_MAX) {
                System.out.println("Please enter digits " + MIN_OPTIONS + "-" + OPTION_COUNT_MAX);
                console();
            } else {
                switch (val) {
                    case 0: {
                        System.out.println("At your service, back to MainDashboard ...\n");
                        MainDashboard.mainConsole();
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

                        scan.nextLine();
                        System.out.println("Removing a chain? \nLet me get my notepad ...");
                        System.out.println("\nChain ID to be removed?");


                            console();
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
                                int role = scan.nextInt();
                                System.out.println("Umkay, user's username is *" + username + "*,\n password is *" + password
                                        + "*,\n first name is *" + firstName + "*,\n last name is *" + lastName
                                        + "*,\n email is *" + email + "*,\n and role is *" + role + "*\n");
                                System.out.println("   Everything look right? (y) or (no)\n");
                                while (true) {
                                    String decide = scan.next();
                                    if (decide.contentEquals("y")) {
                                        UserDto createdUser   =   UserDto.builder()
                                                .username(email)
                                                .lastName(lastName)
                                                .firstName(firstName)
                                                .userType(role)
                                                .organizationCode("CD")
                                                .dashboardCode("dashboardCd")
                                                .email("user4@cryptomaven.xyz")
                                                .cusUrl("http://www.dailytech.net/photoPath")
                                                .contactType(1)
                                                .isActive(1)
                                                .id("id")
                                                .build();
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
        System.out.println("2.) Add Chain to Wallet");
        System.out.println("3.) Remove Chain from Wallet");
        System.out.println("4.) Update Chain in Wallet");
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
                        System.out.println(chainsService.getAllChains());
                        System.out.println("==========================");
                        System.out.println();
                        break;
                    }
                    case 2: {

                         
                        System.out.println("Adding a chain? Let me get my notepad ...");
                        System.out.println("Chain ID?");
                        while (true) {
                            try {
                                scan.nextInt();
                                scan.nextLine();
                                System.out.println("Chain name?");
                                String name = scan.nextLine();
                                System.out.println("Chain Symbol?");
                                String symbol = scan.nextLine();
                                System.out.println("Chain id");
                                int id = scan.nextInt();  
                                if (id < 0) {
                                    System.out.println("id must be >0, please.");  
                                    scan.nextLine();
                                }
                                System.out.println("Umkay,chain's chainToken is *" + name + "*,\n chainSymbol is *" + symbol
                                        + "*,\n and id at *$" + id + "*\n");
                                System.out.println("   Everything look right? (y) or (no)\n");
                                while (true) {
                                    String decide = scan.next();
                                    if (decide.contentEquals("y")) {
                                        ChainDto createdChain = ChainDto.builder()
                                                .id(1)
                                                .name("ethereum")
                                                .symbol("eth")
                                                .description("erc-20")
                                                .longDescription("erc-20 native token")
                                                .iconUrl("ethereum.org")
                                                .category("token")
                                                .chainListIcon("chainlisticon")
                                                .rpcUrl("rpc://this.net")
                                                .chainId(345)
                                                .blockExplorerUrl("etherscan.io")
                                                .build();
                                        chainsService.createChainCLI(createdChain);
                                        System.out.println(
                                                "This " + createdChain.getChainToken() + " has been Successfully added!!\n");
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
                        System.out.println("Remove Chain from Wallet");
                        break;
                    }
                    case 4: {
                        System.out.println("Update Chain in Wallet");
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
