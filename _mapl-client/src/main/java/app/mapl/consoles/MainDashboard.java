package app.mapl.consoles;

import app.mapl.commands.*;
import app.mapl.util.constants.Cmds;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

@Component
@Primary
public class MainDashboard implements IMaPL {

    @Override
    public void openMaPLControl() throws SQLException {
        System.out.println(Cmds.WELCOME_TO_MY_PERSONAL_LIBRARIAN_MY_NAME_IS_MA_PL);
        MaPLInvoker mc = new MaPLInvoker();
        mc.getMapleState();

        sessionMaPL(mc);
    }

    private static void sessionMaPL(MaPLInvoker mapleInvokerSession) throws SQLException {
        // LOAD UP THE COMMANDS FROM THE DB ADMIN TABLE
        System.out.println(mapleInvokerSession.getMaplCommands());
        while (true) {
            try (Scanner scan = new Scanner(System.in)) {
                System.out.println("______________Session MaPL: MainDashboard");
                System.out.println("What next? - enter number; 0 to quit()");
                int nextCommand = scan.nextInt();
                if (nextCommand == 0)
                    console();

                mapleInvokerSession.execute(nextCommand);
                System.out.println("Invoked command executed.\n");
                sessionMaPL(mapleInvokerSession);
            }
        }
    }

    private static final int MAIN_OPTIONS_COUNT = 8;

    private static void frontConsoleMenu() {
        System.out.println("\n1.) Log in \n"
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

        System.out.println("Now Loading frontConsoleMenu()");
        frontConsoleMenu();
        try (Scanner newScan = new Scanner(System.in)) {

            boolean hasNextInt = newScan.hasNextInt();
            int val = newScan.nextInt();
            try {
                // After stack return & Break, back to console
                if (val < 0 | val > MAIN_OPTIONS_COUNT | !hasNextInt) {
                    System.out.println("Please enter valid choices: 0-" + MAIN_OPTIONS_COUNT);


                    // RECURSE
                } else {
                    switch (val) {
                        case 1: {
                            UserLogin.login();
                            break;
                        }
                        case 2: {
                            System.out.println("\n Initiating Local Oracle Database....USERS");

                            UserRegister.register();
                            break;
                        }
                        case 3: {
                            System.out.println("\n [disabled] , Initiating Local Oracle Database....");
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
                            MaPLAdminInvoker newMaPLInvokerl = new MaPLAdminInvoker(""); // create new MaPLInvoker

                            NavigateRunner openSession = new NavigateRunner( newMaPLInvokerl); // open MaPLControl
                            openSession.runNavigate(); // open MaPLControl
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


    /**
     * @return
     */
    @Override
    public String[] getCmds() {
        return new String[0];
    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPL cmd) {

    }

    /**
     *
     */
    @Override
    public void getMapleState() {

    }

    /**
     * @param startupText
     */
    @Override
    public void getMapleState(String startupText) {

    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(String cmdName, MaPLwriter cmd) {

    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPLwriter cmd) {

    }

    /**
     * @param cmdId
     */
    @Override
    public void execute(int cmdId) {

    }

    /**
     *
     */
    @Override
    public void execute() {

    }

    /**
     *
     */
    @Override
    public void up() {

    }

    /**
     *
     */
    @Override
    public void down() {

    }

    /**
     *
     */
    @Override
    public void left() {

    }

    /**
     *
     */
    @Override
    public void right() {

    }

    /**
     * @param o
     */
    @Override
    public void up(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void down(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void left(Object o) {

    }

    /**
     * @param o
     */
    @Override
    public void right(Object o) {

    }
}
