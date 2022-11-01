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
import xyz.cryptomaven.app.logger.LogCustom;
import xyz.cryptomaven.app.models.Car;
import xyz.cryptomaven.app.models.MaPL;
import xyz.cryptomaven.app.service.CarService;
import xyz.cryptomaven.app.systemUser.UserLogin;
import xyz.cryptomaven.app.systemUser.UserRegister;

import static xyz.cryptomaven.app.cli.CliLoader.runDownloaderJob;
import static xyz.cryptomaven.app.cli.CliLoader.startBrowsingBuying;

public class MainDashboard {
    public Map<String, String> dataMap = new HashMap<>(); //k, v
    public MaPL sessionMaPL = new MaPL();

    public static void mainUser(String[] args) throws SQLException, ClassNotFoundException, IOException {

        LogCustom.logger();

        /// #0  Load STARTUP_TEXT.txt User State, Oracle JDBC Driver
        MainDashboard m = new MainDashboard();
        m.consoleValidation();

        /// #2  Loading Scanner accepting Integer Input
        try {
            console();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("oops!! #3 scanner fail");
        }
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
                        case 7: {
                            System.out.println("\n   #6 start(); Test Data...");
                            openMaPL();
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

    private static void openMaPL() {
        System.out.println("Welcome to My Personal Librarian, my name is MaPL.");
        MaPL m = new MaPL();
        m.getMapleState();

    }

    static String startupTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
		System.out.println(formatter.format(date));
        return formatter.format(date);
    }

    public static void carlotView() {
        List<Car> carList = CarService.getAllCarsCust(); // Customer view of carlot.
        System.out.println(carList);
    }

    protected static File checkLocalfiles(String path) {
        String fileFullPath = (path != null) ? path : String.valueOf("src/data/STARTUP_TEXT.txt");
        Path absolutePath = FileSystems.getDefault().getPath(fileFullPath);
        System.out.println("Loading from "+absolutePath);
        File textFile = new File(fileFullPath);
        return textFile;
    }

    public void consoleValidation() {
        System.out.println(startupTime());
        File file = checkLocalfiles(null);  //  Checking  local input
        try (Scanner scanText = new Scanner(file)) {
            int TEXT_VERSION = scanText.nextInt(); //LINE_1
              System.out.println("\n    #=== 'src/data/scannertext.txt version': " + TEXT_VERSION + "\n");
            String SQL_DRIVER = scanText.nextLine();  //LINE_2
            try {
                System.out.println("#=== 'SQL_DRIVER': " + Class.forName(SQL_DRIVER) + "\n");
            } catch (ClassNotFoundException e) {
                System.out.println(e.getMessage());
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
            System.out.println(dataMap.values());
            sessionMaPL.registerCmds(dataMap);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
}
