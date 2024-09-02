package app.mapl.consoles;

import java.io.*;
import java.sql.SQLException;
import java.util.*;

import app.mapl.systemUser.UserLogin;
import app.mapl.systemUser.UserRegister;
import org.springframework.stereotype.Component;

//import static app.mapl.service.CoinService.coinMarketViewAll; // 3 DB
import static app.mapl.consoles.GeoDashboard.mainNavigator; // 7 Local

@Component
public class MainDashboard {
    private static final int MAIN_OPTIONS_COUNT = 7;

//    public static void mainUser(String[] args) throws SQLException, ClassNotFoundException, IOException {
//        try {
//            /// #1  Loading Recursive Console Scanner accepting Integer Input
//            mainConsole();
//        } catch (Exception e) {
//            System.out.println("oops!  mainConsole fail"+ e.getMessage());
//
//        }
//    }

    private static void frontConsoleMenu() {
        System.out.println("\n1.) Log in \n"
                + "2.) Register  \n"
                + "3.) Browse the lot from Oracle Database\n"
                + "4.) Load Test Data =  cliDataLoader(); \n"
                + "5.) Play Navigation Game [Offline] \n"
                + "6.) Download from Web \n"
                + MAIN_OPTIONS_COUNT+") Set in Motion Automated USER [Offline]\n"
                + "Stop Application, press '0'.\n");
    }

    public static void mainConsole(String[] ...args) {

        System.out.println("Now Loading frontConsoleMenu()");
        frontConsoleMenu();
        try (Scanner newScan = new Scanner(System.in)) {;
            boolean hasNextInt = newScan.hasNextInt();
            int val = newScan.nextInt();
            try {
                if (val < 0 | val > MAIN_OPTIONS_COUNT | !hasNextInt) {
                    System.out.println("Please enter valid choices: 0-"+MAIN_OPTIONS_COUNT);
                    // RECURSE
                    mainConsole();
                } else {
                    switch (val) {
                        case 1: {
                            UserLogin.login();
                            break;
                        }
                        case 2: {
                            UserRegister.register();
                            break;
                        }
                        case 3: {
                            System.out.println("\n Ok, Accessing DB ...please enjoy your browsing....");
                            coinMarketViewAll(); // Browse the lot from Oracle Database\n"
                            break;
                        }
                        case 4: {
                            System.out.println("\n Ok, Initiating Local Offline Data Loader....");
                            break;
                        }
                        case 5: {
                            System.out.println("\n Ok, #4 ...");
                            mainNavigator(new String[]{}); //{"any", "options"});
                            break;
                        }
                        case 6: {
                            System.out.println("\n   #5, runDownloaderJob();...");
                            break;
                        }
                        case MAIN_OPTIONS_COUNT: {
                            System.out.println("\n   #6 startBrowsingBuying();");
                            break;
                        }
                        case 0: {
                            System.out.println("\n   Come Back *Soon* !\n");
                            System.out.println("\n =======================!\n");
                            System.exit(0); // SUCCESSFUL TERMINATION
                            break;
                        }
                    }
                    mainConsole();// After stack return & Break, back to console
                }

            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException, Inputs! must choose 1,2,3,4... ");
                mainConsole();
            }  catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                mainConsole();// RECURSE
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
                mainConsole();  // RECURSE
            } catch (ClassNotFoundException e) {
                System.out.println("Oops, ClassNotFoundException " + e.getMessage());
                mainConsole();   // RECURSE
            }
            mainConsole();

        }
    }

    private static void coinMarketViewAll() {
    }


}
