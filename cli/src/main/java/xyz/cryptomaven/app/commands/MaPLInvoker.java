package xyz.cryptomaven.app.commands;

import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.util.Utilities;
import xyz.cryptomaven.app.commands.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

/**
 * COMMAND INVOKER
 *[10=Thomas Maestas,
 * 101=Can I add two numbers? ${num1},${num2}
 * 11=Can I run any tests on any of your websites, ${user.fname} … ?,
 * 12=Check google weather api, ${user.fname} … ? , *
 * 13=Check local and network ports? ,
 * 14=Here is your annual state weekly day. Want to update?,
 * 15=Can I look something up for you in your database?,
 * 16=Let’s see I can look it up in aws s3 documents?,
 * 17=How about aws Oracle?, 18=How about blockchain?, 19=,
 * 20=I know nothing of the outside world.  So all I know are my electroLots. Do you want to buy one, ${user.fname} … ?,
 * 21=About my world I have but one source of truth a that is standard.in ,
 * 22=I have in my world one knowledge domain. I have , ${class} Oracle db that I can inquire from. Shall I connect a new DB?,
 * 23=I also have the methods and values you have taught me.,
 * 24=I am ready to open up your workstation layout. Ready [1], * 25=, * 26=Can I run any tests? ,
 * 27=How about I Web3 connect to blockchain. May I start Ganache? , * 28=May I start Truffle? ,
 * 29=Running Geth now? , 3=oracle.jdbc.driver.OracleDriver,
 * 30=Shall I open an API to CryptoMavenAPI? , 4=CryptoMaven - My Personal Librarian]
 */

public class MaPLInvoker implements IMaPL {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; //  DEFAULT DRIVER
    private static final String SRC_DATA_STARTUP_TEXT_TXT = "src/data/STARTUP_TEXT.txt"; // DEFAULT INSTRUCTION SOURCE
    private Map<String, String> instructionMap = new TreeMap<>(); // STARTUP INSTRUCTION SET   "11=Run Websites Health Check"
    private Map<Integer,IMaPL> maplCommands = new HashMap<>();

    private Map<String, Map<Integer,MaPL>> commandsMapping = new HashMap<>();


    @Override
    public void register(Integer cmdName, MaPL cmd) {
        // IMaPL.super.register(cmdName, cmd)
        //  implement & register commands to MaPL instance tasks
        maplCommands.put(cmdName, cmd);
    }

    public void registerCmds(String commandID, String suggestion) {
        //  implement pre-registered commands to MaPL instance tasks
        MaPL mapl = new MaPL(); // Concrete Command
        mapl.setCmdId( Integer.valueOf(commandID) );
        mapl.setSuggestion(suggestion);
        mapl.setCommandName( suggToCmd(suggestion) );
        maplCommands.put( mapl.getCmdId(), mapl );

        System.out.println(mapl.getCmdId() + ": "+mapl.getCommandName());
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
                    this.registerCmds(commandPair.getKey(), commandPair.getValue());

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
    @Override
    public void execute(String cmdName) {
        if(maplCommands.containsKey(cmdName)) {
           IMaPL m = maplCommands.get(cmdName);
            m.execute();
        } else {
            System.out.println("CMD not recognized");
        }
    }
    @Override
    public void execute(int cmdId) {
        if(maplCommands.containsKey(cmdId)) {
            IMaPL m = maplCommands.get(cmdId);
            System.out.println(m.getClass());
//            if (((MaPL) m).getCmdId() == //IMaPL.class())

        } else {
            System.out.println("CMD not recognized");
        }
    }
    @Override
    public void execute() {

    }
}
