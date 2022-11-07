package xyz.cryptomaven.app.consoles;

import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.sql.SQLException;
import java.util.*;

import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.systemUser.UserLogin;
import xyz.cryptomaven.app.systemUser.UserRegister;
import xyz.cryptomaven.app.util.Utilities;

import static xyz.cryptomaven.app.service.CarService.carlotViewAll; // 3 DB
import static xyz.cryptomaven.app.cli.CliLoader.runDownloaderJob; //4 download
import static xyz.cryptomaven.app.cli.CliLoader.cliDataLoader; // 5 browse offline lot
import static xyz.cryptomaven.app.cli.CliLoader.startBrowsingBuying; // 6 auto user
import static xyz.cryptomaven.app.consoles.GeoDashboard.mainNavigator; // 7 Local
import xyz.cryptomaven.app.models.MaPL;

import xyz.cryptomaven.app.logger.CliLogger;
import xyz.cryptomaven.app.logger.LogCustom;

public class MainDashboard {
    private static final int MAIN_OPTIONS_COUNT = 7;

    public static void mainUser(String[] args) throws SQLException, ClassNotFoundException, IOException {
        try {
            /// #1  Loading Recursive Console Scanner accepting Integer Input
            mainConsole();
        } catch (Exception e) {
            System.out.println("oops!  mainConsole fail"+ e.getMessage());

        }
    }

    private static void frontConsoleMenu() {
        System.out.println("\n1.) Log in \n"
                + "2.) Register  \n"
                + "3.) Browse the lot from Oracle Database\n"
                + "4.) Load Test Data =  cliDataLoader(); \n"
                + "5.) Play Navigation Game [Offline] \n"
                + "6.) Download from Web \n"
                + "7.) Set in Motion Automated USER [Offline]\n"
                + MAIN_OPTIONS_COUNT+".) Make MaPL request\n"
                + "Stop Application, press '0'.\n");
    }

    public static void mainConsole() {
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
                            carlotViewAll(); // Browse the lot from Oracle Database\n"
                            break;
                        }
                        case 4: {
                            System.out.println("\n Ok, Initiating Local Offline Data Loader....");
                            cliDataLoader();  // Local Offline Automated USER
                            break;
                        }
                        case 5: {
                            System.out.println("\n Ok, #4 ...");
                            mainNavigator(new String[]{}); //{"any", "options"});
                            break;
                        }
                        case 6: {
                            System.out.println("\n   #5, runDownloaderJob();...");
                            runDownloaderJob();
                            break;
                        }
                        case MAIN_OPTIONS_COUNT: {
                            System.out.println("\n   #6 startBrowsingBuying();");
                            startBrowsingBuying();
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

            } catch (SQLException e) {
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

        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException, Inputs! must choose 1,2,3,4... ");
            mainConsole();
            // RECURSE
        }
    }




}
