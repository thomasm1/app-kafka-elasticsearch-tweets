package app.mapl.consoles;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

@Slf4j
@Component
@Primary
public class MainDashboard  {

    private static final int MAIN_OPTIONS_COUNT = 8;

    private static void frontConsoleMenu() {
        log.info("\n1.) Log in \n"
                + "2.) Register  \n"
                + "3.) Browse the lot from Oracle Database\n"
                + "4.) Load Test Data =  cliDataLoader(); \n"
                + "5.) Play Navigation Game [Offline] \n"
                + "6.) Download from Web \n"
                + "7.) Start Browsing and Buying \n"
                + MAIN_OPTIONS_COUNT + ") Set in Motion Automated USER [Offline]\n"
                + "Stop Application, press '0'.\n");
    }

    public static void console(String[]... args) {

        log.info("Now Loading frontConsoleMenu()");
        frontConsoleMenu();
        try (Scanner newScan = new Scanner(System.in)) {

            boolean hasNextInt = newScan.hasNextInt();
            int val = newScan.nextInt();
            try {
                // After stack return & Break, back to console
                if (val < 0 | val > MAIN_OPTIONS_COUNT | !hasNextInt) {
                    log.info("Please enter valid choices: 0-" + MAIN_OPTIONS_COUNT);


                    // RECURSE
                } else {
                    switch (val) {
                        case 1: {
                            UserDashboard.UserLogin.login();
                            break;
                        }
                        case 2: {
                            log.info("\n Initiating Local Oracle Database....USERS");

                            UserRegister.register();
                            break;
                        }
                        case 3: {
                            log.info("\n [disabled] , Initiating Local Oracle Database....");
//                            coinMarketViewAll();
                            break;
                        }
                        case 4: {
                            System.out.println("\n Ok,[disabled]  Initiating Local Offline User Details Loader....");
//                            UserDetailsCommanLineRunner cliDataLoader = new UserDetailsCommanLineRunner();
//                            cliDataLoader.run();  // Local Offline Automated USER
                            break;
                        }
                        case 5: {
                            System.out.println("\n Ok, #5 ...");
                             GeoDashboard.console(Arrays.toString(new String[]{"/data/locations/json/posts.json"})); //{"any", "options"
                            break;
                        }
                        case 6: {
                            System.out.println("\n   #6,[disabled]  runDownloaderJob();...");
//                            runDownloaderJob();
                            break;
                        }
                        case 7: {
                            System.out.println("\n   #7 [disabled] startBrowsingBuying();");
//                            startBrowsingBuying();
                            break;
                        }
                        case MAIN_OPTIONS_COUNT: {
                            System.out.println("\n   #8 () Opening MaPLControl...");

                            console( );
                            break;
                        }
                        case 0: {
                            System.out.println("\n   Come Back *Soon* !\n");
                            System.out.println("\n =======================!\n");
                            System.exit(0); // SUCCESSFUL TERMINATION
                            break;
                        }
                    }
                }
                console();

            } catch (InputMismatchException e) {
                System.out.println("InputMismatchException, Inputs! must choose 1,2,3,4... ");
                console();
            } catch (SQLException e) {
                System.out.println("SQLException: " + e.getMessage());
                console();// RECURSE
            } catch (IOException e) {
                System.out.println("IOException: " + e.getMessage());
                console();  // RECURSE
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            console();

        }
    }

}
