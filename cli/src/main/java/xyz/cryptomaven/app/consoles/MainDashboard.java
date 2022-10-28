package xyz.cryptomaven.app.consoles;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.logger.LogCustom;
import xyz.cryptomaven.app.models.Car;
import xyz.cryptomaven.app.service.CarService;
import xyz.cryptomaven.app.systemUser.UserLogin;
import xyz.cryptomaven.app.systemUser.UserRegister;

import static xyz.cryptomaven.app.cli.CliLoader.runDownloaderJob;
import static xyz.cryptomaven.app.cli.CliLoader.startBrowsingBuying;

public class MainDashboard {

    public static void mainUser(String[] args) throws SQLException, ClassNotFoundException, IOException {

        LogCustom.logger();
        System.out.println("|||_________NEWTECH__________||| \n #0 log ...Logging by Log4j2.\n");/// #0 log

        /// #0 Validate and Load local User State
        /// #1 check for Oracle JDBC Driver
        System.out.println(startupTime());
        frontConsoleValidation();

        /// #2  Loading Scanner accepting Integer Input
        try {
            console();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("oops!! #3 scanner fail");
        }
    }

    public static void carlotView() {
        List<Car> carList = CarService.getAllCarsCust(); // Customer view of carlot.
        System.out.println(carList);
    }

    protected static File checkLocalfiles(String path) {
        String fileFullPath = (path != null) ? path : String.valueOf("src/data/scannertext.txt");
        File textFile = new File(fileFullPath);
        return textFile;
    }

    public static void frontConsoleValidation() throws IOException {
        try {
            System.out.println("1 ..Success Oracle JDBC Driver" + Class.forName("oracle.jdbc.driver.OracleDriver") + " \n");
        } catch (ClassNotFoundException e) {
            System.out.println(Cmds.OOPS_JDBC);
        }
        // ## Checking  local input
        File file = checkLocalfiles(null);
        Scanner scanText = new Scanner(file);
        int firstRowCheck = scanText.nextInt();
        System.out.println("\n    #=====Reading   \"src/scannertext.txt\" firstRowCheck ID: " + firstRowCheck + "=====#\n");
        scanText.close();
    }

    public static void frontConsoleMenu() {
        System.out.println("\n1.) Log in \n"
                + "2.) Register  \n"
                + "3.) Browse the lot\n"
                + "4.) to Play Navigation Game \n"
                + "5.) Background Web Loader\n"
                + "6.) Set in Motion Automated USER\n"
                + "Exit, press '0'.\n");
    }

    public static void console() {
        System.out.println("Now Loading frontConsoleMenu()");
        frontConsoleMenu();
        try {
            Scanner newScan = new Scanner(System.in);
            boolean hasNextInt = newScan.hasNextInt();
            int val = newScan.nextInt();
            try {
                if (val < 0 | val > 6 | !hasNextInt) {
                    System.out.println("Please enter valid choices: 0-3");
                    // RECURSE
                    console();
                } else {
                    switch (val) {
                        case 1: {
                            UserLogin.login();
                            carlotView();
                            break;
                        }
                        case 2: {
                            UserRegister.register();
                            carlotView();
                            break;
                        }
                        case 3: {
                            System.out.println("\n Ok, please enjoy your browsing....");
                            carlotView();
                            break;
                        }
                        case 4: {
                            System.out.println("\n Ok, #4 ...");
                            GeoDashboard.mainNavigator(new String[]{}); //{"any", "options"});
                            break;
                        }
                        case 5: {
                            System.out.println("\n   #5, runDownloaderJob();...");
                            runDownloaderJob();
                            break;
                        }
                        case 6: {
                            System.out.println("\n   #6 start(); Test Data...");
                            startBrowsingBuying();
                            break;
                        }
                        case 0: {
                            System.out.println("\n   Come Back *Soon* !\n");
                            System.out.println("\n =======================!\n");
                            System.exit(0);
                            break;
                        }
                    }
                    console();
                    // After returning & Break, back to console
                }

            } catch (SQLException e) {
                System.out.println("SQLException" + e);
                console();
                // RECURSE
            } catch (IOException e) {
                console();
                // RECURSE
            } catch (ClassNotFoundException e) {
                System.out.println("Oops, ClassNotFoundException " + e);
                console();
                // RECURSE
            }
            console();

        } catch (InputMismatchException e) {
            System.out.println("Oops, Inputs! must choose 1,2,3,4... " + e);
            console();
            // RECURSE
        }
    }

    static String startupTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
//		System.out.println(formatter.format(date));
        return formatter.format(date);
    }
}
