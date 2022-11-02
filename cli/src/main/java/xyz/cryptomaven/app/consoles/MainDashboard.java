package xyz.cryptomaven.app.consoles;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.*;

import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.logger.CliLogger;
import xyz.cryptomaven.app.logger.LogCustom;
import xyz.cryptomaven.app.models.Car;
import xyz.cryptomaven.app.models.MaPL;
import xyz.cryptomaven.app.service.CarService;
import xyz.cryptomaven.app.systemUser.UserLogin;
import xyz.cryptomaven.app.systemUser.UserRegister;
import xyz.cryptomaven.app.util.Utilities;

import static xyz.cryptomaven.app.service.CarService.carlotViewAll; // 3 DB
import static xyz.cryptomaven.app.cli.CliLoader.runDownloaderJob; //4 download
import static xyz.cryptomaven.app.cli.CliLoader.cliDataLoader; // 5 browse offline lot
import static xyz.cryptomaven.app.cli.CliLoader.startBrowsingBuying; // 6 auto user
import static xyz.cryptomaven.app.consoles.GeoDashboard.mainNavigator; // 7 Local

import xyz.cryptomaven.app.logger.LogCustom;
public class MainDashboard {
    private static final int MAIN_OPTIONS_COUNT = 8;
    private static final String SRC_DATA_STARTUP_TEXT_TXT = "src/data/STARTUP_TEXT.txt";
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private Map<String, String> dataMap = new HashMap<>();
    private MaPL sessionMaPL = new MaPL();

    public static void mainUser(String[] args) throws SQLException, ClassNotFoundException, IOException {
        LogCustom.logger();
        System.out.println(CliLogger.getInstance());
        /// #0  Load STARTUP_TEXT.txt User State, Oracle JDBC Driver
        MainDashboard m = new MainDashboard();
        m.consoleValidation();

        /// #2  Loading Recursive Console Scanner accepting Integer Input
        try {
            mainConsole();
        } catch (Exception e) {
            System.out.println("oops!  mainConsole fail"+ e.getMessage());

        }
    }

    private static void frontConsoleMenu() {
        System.out.println("\n1.) Log in \n"
                + "2.) Register  \n"
                + "3.) Browse the lot from Oracle Database\n"
                + "4.) Download from Web\n"
                + "5.) Browse the lot [Offline]\n"
                + "6.) Set in Motion Automated USER [Offline]\n"
                + MAIN_OPTIONS_COUNT+".) Play Navigation Game [Offline] \n"
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
                            carlotViewAll();
                            break;
                        }
                        case 4: {
                            System.out.println("\n Ok, Initiating Local Offline Data Loader....");
                            // Local Offline Data Loader
                            cliDataLoader();
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
                        case 7: {
                            System.out.println("\n   #6 start() Test Data...");
                            startBrowsingBuying();
                            break;
                        }
                        case MAIN_OPTIONS_COUNT: {
                            System.out.println("\n   #7 openMaPL();...");
                            openMaPL();
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

    private static void openMaPL() {
        System.out.println(Cmds.WELCOME_TO_MY_PERSONAL_LIBRARIAN_MY_NAME_IS_MA_PL);
        MaPL m = new MaPL();
        m.getMapleState();
    }

    protected static File readStartupFile(String path) {
        String fileFullPath = (path != null) ? path : String.valueOf(SRC_DATA_STARTUP_TEXT_TXT);
        Path absolutePath = FileSystems.getDefault().getPath(fileFullPath);
        System.out.println("Loading from "+absolutePath);
        File textFile = new File(fileFullPath);
        return textFile;
    }

    public void consoleValidation() {
        System.out.println(Utilities.startupTime());
        File startFile = readStartupFile(null);  //  Checking  local input
        try (Scanner scanText = new Scanner(startFile)) {
            int TEXT_VERSION = scanText.nextInt(); //LINE_1
            String SQL_DRIVER = scanText.nextLine();  //LINE_2
            System.out.println("\n    #=== Doc version': " + TEXT_VERSION + "SQL_DRIVER: "+SQL_DRIVER + Cmds.BR);
            try {
                System.out.println(Class.forName(DRIVER));
            } catch (ClassNotFoundException e) {
                System.out.println(Cmds.OOPS_JDBC);
            }
            System.out.println(Cmds.NOW_LOGGING);
            String APP_TITLE = scanText.nextLine(); //LINE_3
            System.out.println(APP_TITLE);
            String AUTHOR = scanText.nextLine(); //LINE_4
            System.out.println(AUTHOR);
            int counter = 10; //Miscellaneous Data Starting at LINE 10:  KEY IS LINE NUMBER
            while(scanText.hasNext()) {
                String scanData = scanText.nextLine();
                if ((!scanData.startsWith("-|")) && scanText.hasNext()) {
                    dataMap.put(String.valueOf( counter++), scanData);
                }
            }
            System.out.println(dataMap.entrySet());
            sessionMaPL.registerCmds(dataMap);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
