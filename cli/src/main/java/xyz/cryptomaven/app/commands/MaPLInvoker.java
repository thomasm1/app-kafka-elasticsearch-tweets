package xyz.cryptomaven.app.commands;

import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.util.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

/**
 * COMMAND INVOKER
 * [10=Can I run any tests on any of your websites?, 11=Check google weather api?, 12=Check local and network ports? , 13=Here is your annual state weekly day. Want to update?, 14=Can I look something up for you in your database?, 15=Let's see I can look it up in aws s3 documents?, 16=How about test aws Oracle?, 17=How about check up on blockchain?, 18=May I print something to the screen?, 19=I know nothing of the outside world.  So all I know are my electroLots. Do you want to buy one?, 20=About my world I have but one source of truth a that is standard.in , 21=I have in my world one knowledge domain. I have , ${class} Oracle db that I can inquire from. Shall I connect a new DB?, 22=I also have the methods and values you have taught me., 23=I am ready to open up your workstation layout. Ready [1], 24=, 25=Can I run any tests? , 26=How about I Web3 connect to blockchain. May I start Ganache? , 27=May I start Truffle? , 28=Can I start Geth now?, 29=Shall I open an API to CryptoMavenAPI? , 3=CryptoMaven's <<MaPL>> My Personal Librarian, 4=Thomas Maestas]
 * 10: RUN_ANY_TESTS_ON_ANY_OF_YOUR_WEBSITES
 * 11: CHECK_GOOGLE_WEATHER_API
 * 12: CHECK_LOCAL_AND_NETWORK_PORTS
 * 13: HERE_IS_YOUR_ANNUAL_STATE_WEEKLY_DAY_WANT_TO_UPDATE
 * 14: LOOK_SOMETHING_UP_FOR_IN_YOUR_DATABASE
 * 15: LET'S_SEE_LOOK_IT_UP_IN_AWS_S3_DOCUMENTS
 * 16: TEST_AWS_ORACLE
 * 17: CHECK_UP_ON_BLOCKCHAIN
 * 18: PRINT_SOMETHING_TO_THE_SCREEN
 * 19: KNOW_NOTHING_OF_THE_OUTSIDE_WORLD_ALL_KNOW_ARE_ELECTROLOTS_DO_WANT_TO_BUY_ONE
 * 20: WORLD_HAVE_BUT_ONE_SOURCE_OF_TRUTH_A_THAT_IS_STANDARD_IN
 * 21: HAVE_IN_WORLD_ONE_KNOWLEDGE_DOMAIN_HAVE_${CLASS}_ORACLE_DB_THAT_INQUIRE_FROM_CONNECT_A_NEW_DB
 * 22: AL_HAVE_THE_METHODS_AND_VALUES_HAVE_TAUGHT_ME
 * 23: TO_OPEN_UP_YOUR_WORKSTATION_LAYOUT_[1]
 * 24:
 * 25: RUN_ANY_TESTS
 * 26: WEB3_CONNECT_TO_BLOCKCHAIN_START_GANACHE
 * 27: START_TRUFFLE
 * 28: START_GETH_NOW
 * 29: OPEN_AN_AP_TO_CRYPTOMAVENAPI
 *
 * 3: CRYPTOMAVEN'S_<<MAPL>>_PERSONAL_LIBRARIAN
 */

public class MaPLInvoker implements IMaPL {
    private static  int duplicate = 0;
    MaPL mw = new MaPLwriter();
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; //  DEFAULT DRIVER
    private static final String SRC_DATA_STARTUP_TEXT_TXT = "src/data/STARTUP_TEXT.txt"; // DEFAULT INSTRUCTION SOURCE
    private Map<String, String> instructionMap = new TreeMap<>(); // STARTUP INSTRUCTION SET   "11=Run Websites Health Check"
    private Map<Integer,MaPL> maplCommands = new HashMap<>();

//    private Map<String, Map<Integer,MaPL>> commandsMapping = new HashMap<>();
//    public Map<String, Map<Integer, MaPL>> getCommandsMapping() {
//        return commandsMapping;
//    }


    @Override
    public void register(Integer cmdName, MaPL cmd) {
        // IMaPL.super.register(
        // cmdName, cmd)
        //  implement & register commands to MaPL instance tasks
        maplCommands.put(cmdName, cmd);
    }

    public Map<Integer,MaPL> registerCmds(String commandID, String suggestion) {
        //  implement pre-registered commands to MaPL instance tasks
        MaPL mapl = new MaPL(); // Concrete Command
        mapl.setCmdId( Integer.valueOf(commandID) );
        mapl.setSuggestion(suggestion);
        mapl.setCommandName( suggToCmd(suggestion) );
        maplCommands.put( mapl.getCmdId(), mapl );

        System.out.println(mapl.getCmdId() + ": "+mapl.getCommandName());
        return maplCommands;
    }

    private String suggToCmd(String sugg) {
        String[] sArr = sugg.toUpperCase().replaceAll("HOW |MAY |CAN |SHALL |I |AM |YOU |MY |ABOUT |READY|'s|[!?.,:]+|SO "," ").stripLeading()
        .split("\\s+");
        String newString = String.join("_",sArr);
        return newString;
    }

    @Override
    public void getMapleState() {
        /// #0  Load STARTUP_TEXT.txt User State, Oracle JDBC Driver
            System.out.println(Utilities.startupTime());

            File startFile = readStartupFile(null);  //  Checking  local input
            try (Scanner scanText = new Scanner(startFile)) {
                int TEXT_VERSION = scanText.nextInt(); //LINE_1
                String SQL_DRIVER = scanText.nextLine();  //LINE_2
                System.out.println("\n'1': Doc version': " + TEXT_VERSION);
                try {
                    System.out.println( "'2': SQL_DRIVER: "+Class.forName(DRIVER));
                } catch (ClassNotFoundException e) {
                    System.out.println(Cmds.OOPS_JDBC);
                }
                scanText.nextLine();
                String APP_TITLE = scanText.nextLine(); //LINE_3
                System.out.println("'3': APP_TITLE="+APP_TITLE );
                instructionMap.put("3",APP_TITLE);

                String AUTHOR = scanText.nextLine(); //LINE_4
                instructionMap.put("4",AUTHOR);
                System.out.println("'4': AUTHOR="+AUTHOR);
                int counter = 10; //Miscellaneous Data Starting at LINE 10:  KEY IS LINE NUMBER
                while(scanText.hasNext()) {
                    String scanData = scanText.nextLine();
                    if ((!scanData.startsWith("-|")) && scanText.hasNext()) {
                        // instructionMap is static mapping
                        instructionMap.put(String.valueOf(counter++), scanData);
                    }
                }
                System.out.println(instructionMap.entrySet());

                // REGISTER COMMANDS Using MaPLIMvoker Instance
                //  map datamap values [suggested] to registered commands
                for(Map.Entry<String, String> commandPair : instructionMap.entrySet())
                    maplCommands = this.registerCmds(commandPair.getKey(), commandPair.getValue());

                this.register(mw.getCmdId(),mw); // check for duplicates later
                System.out.println(maplCommands);
                System.out.println("SCANNERTEXT objects loaded; MaPLwriter '18' manually loaded. Leaving MaPLInvoker now.");
                System.out.println(Arrays.toString(mw.getCmds()));

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
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

    protected static File readStartupFile(String path) {
        String fileFullPath = (path != null) ? path : String.valueOf(SRC_DATA_STARTUP_TEXT_TXT);
        Path absolutePath = FileSystems.getDefault().getPath(fileFullPath);
        System.out.println("Loading from "+absolutePath);
        File textFile = new File(fileFullPath);
        return textFile;
    }
//    @Override
//    public void execute(String cmdName) {
//        if(maplCommands.containsKey(cmdName)) {
//           IMaPL m = maplCommands.get(cmdName);
//            m.execute();
//        } else {
//            System.out.println("CMD not recognized");
//        }
//    }
    @Override
    public void execute(int cmdId) {
        if(maplCommands.containsKey(cmdId)) {
            IMaPL m = maplCommands.get(cmdId);
            System.out.println("getClass: "+m.getClass());
            System.out.println("getSuggestion: "+((MaPL) m).getSuggestion());
            System.out.println("getCommandName: "+((MaPL) m).getCommandName());
            System.out.println("getCmds: "+((MaPL) m).getCmds());

        } else {
            System.out.println("CMD not recognized");
        }
    }
    @Override
    public void execute() {

    }
}
