package app.mapl.consoles;
 
import app.mapl.models.Chain;
import app.mapl.models.dto.ChainDto;
import app.mapl.repositories.UsersRepository;
import app.mapl.service.ChainsService;
import app.mapl.service.ChainsServiceImpl;
import app.mapl.service.UsersService;
import app.mapl.service.UsersServiceImpl;
import app.mapl.systemUser.UserProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

import static app.mapl.util.constants.Cmds.*;


@Component
public class UserDashboard {

    private static final Logger log;

    static {
        log =  LoggerFactory.getLogger(AdminDashboard.class);

    }

    public static final int OPTION_COUNT_MAX = 7;
    private static final int MIN_OPTIONS = 0;
    private UsersRepository usersRepository;
    private ChainsService chainService;

    private UsersServiceImpl usersService;

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
     * @param username
     */
    public static void console(String username) {


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

                            System.out.println(COINMARKET_TITLE);
                             System.out.println("4: " + PRESS_DIGIT);
                            System.out.println();
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 2: {

                        try {

                            System.out.println(COINMARKET_TITLE);
//                            System.out.println(chainList);
                            System.out.println("4: " + PRESS_DIGIT);
                            System.out.println();
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 3: {
//                        ChainsServiceImpl chainService = new ChainsServiceImpl();
                        try {
//                            List<Chain> chainList = chainService.getAllChainsCustCLI();
//                            System.out.println(chainList);
//                            scan.nextLine();
//                            System.out.println("Which chain #?");
//                            int id = scan.nextInt();
//                            scan.nextLine();
//                            ChainDto newest = chainService.getChain(id);
//                            System.out.println(newest);
//                            System.out.println("\n Chain #" + id +    NICE + PRESS_DIGIT + FOUR);
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 4: {

                        try {
//                            List<Chain> chainList = chainService.getAllChainsCustCLI();
                            System.out.println("e-Chains Lot:");
//                            System.out.println(chainList);
                            System.out.println("\nOk, type in the Chain ID to begin.\n"
                                    + " ...change your mind? press 'no' (or any letter)");
                            val = scan.nextInt();

//                            Chain newest = chainService.getChainCLI(val);


                            scan.nextLine();
                            System.out.println("\nHow much, $xxxx.xx can you put down?  ");
                            double down = scan.nextDouble();
                          
                            scan.nextLine();
                            System.out.println(HOW_MANY_MONTHS);
                            int mos = scan.nextInt();
//				Offer offering = new Offer(777, username, val, down, mos, "PENDING");
//				 /////////////////////////////////////////////////////////////////
//				System.out.println(OfferService.createOffer(offering));
                            System.out.println(NICE + " $" + down + " down, over *" + mos + "* months\n"
                                    + "We'll let you know in less than 24 hours!!\n");
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 5: {
                        try {
//				List<Offer> offerList = OfferService.getAllOffersCust(username);
// 				for (Offer offer : offerList) {
//					System.out.println(offer);
//				}
                            System.out.println("Pressed 5");
//				 /////////////////////////////////////////////////////////////////
                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case 6: {
                        try {
//                            UserProfile.editProfile(UsersService.getUserCli(username).orElseThrow());

                        } catch (Exception e) {
                            console(username);
                        }
                        console(username);
                    }
                    case MENU_LAST: {
                        System.out.println("Opening MaPLControl...");
//                        MaPLUserInvoker newMaPLInvokerl = new MaPLUserInvoker(); // create new MaPLInvoker
//
//                        NavigateRunner open = new NavigateRunner( newMaPLInvokerl); // open MaPLControl
//                        open.runNavigate();
                        console("UserDashboard");
                        break;
                    }
                    case 0: {
                        System.out.println(GOOD_BYE);
                        MainDashboard.mainConsole();
                        break;
                    }
                }
            }
            console(username);
        }

    }

}
