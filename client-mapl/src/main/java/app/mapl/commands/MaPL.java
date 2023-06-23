package app.mapl.commands;

import app.mapl.consoles.AdminDashboard;
import app.mapl.util.Utilities;
import app.mapl.util.constants.Cmds;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.*;
import java.util.stream.Collectors;

import static app.mapl.commands.MaPLUserInvoker.readStartupFile;

public class MaPL implements IMaPL {

    static  String STARTUP_TEXT = "Welcome to the MaPL console. Please enter a command.";


    String suggestRegEx = "HOW |MAY |CAN |SHALL |I |AM |YOU |YOUR |MY |WANT |ABOUT |READY|'s|[!?.,:]+|SO ";
    static  int duplicate = 0;

    static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; //  DEFAULT DRIVER
    Map<String, String> instructionMap = new TreeMap<>(); // STARTUP INSTRUCTION SET   "11=Run Websites Health Check"
    Map<Integer,MaPL> maplCommands = new HashMap<>();
    static Map<Integer, String> sessionHistory = new LinkedHashMap<>();
    Integer cmdId = 0;
    String suggestion;
    String commandName;
    String text = "maple";
    String cmd1 = "cmd1";
    String cmd2 = "cmd2";
    String cmd3 = "cmd3";
    String[] cmds = {text, cmd1, cmd2, cmd3};

    static void showHistory() {
        System.out.println("CMD HISTORY = ");
        // print history of each time a command invoked
        for(Map.Entry<Integer, String> key: sessionHistory.entrySet()) {
            System.out.print("key: "+key.getKey() + ", command: "+ key.getValue() + " || ");
        }
    }
    public void openMaPLControl() throws SQLException {
        System.out.println(Cmds.WELCOME_TO_MY_PERSONAL_LIBRARIAN_MY_NAME_IS_MA_PL);
        MaPLInvoker mc = new MaPLInvoker();
        mc.getMapleState();
        sessionMaPL(mc);
    }


    static void sessionMaPL(MaPLInvoker mapleInvokerSession) throws SQLException {
        // LOAD UP THE COMMANDS FROM THE DB ADMIN TABLE
        System.out.println(mapleInvokerSession.getMaplCommands());
        while (true) {
            try (Scanner scan = new Scanner(System.in)) {
                System.out.println("______________Session MaPL: AdminDashboard______________");
                System.out.println("What next? - enter number; 0 to quit()");
                int nextCommand = scan.nextInt();
                if (nextCommand == 0)
                    AdminDashboard.console();

                mapleInvokerSession.execute(nextCommand);
                System.out.println("Invoked command executed.\n");
                sessionMaPL(mapleInvokerSession);
            }
        }
    }

    static Map<Integer, String> replayLast(int numberOfCommands) {

        List<Integer> arrayKeys = new ArrayList<Integer>(sessionHistory.keySet());
        Integer lastPosition = arrayKeys.size();
        Integer lastKey = arrayKeys.get(lastPosition-1);
        Integer firstKey = arrayKeys.get(lastPosition-1-numberOfCommands);

        Map<Integer, String> subMap = sessionHistory.entrySet().stream()
                .filter(x -> x.getKey() >= firstKey)
                .filter(x -> x.getKey() <= lastKey)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Set<Integer> set = subMap.keySet();
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()) {
            Integer key = itr.next();
            System.out.println("Replay of "+numberOfCommands+"; Key: "+key+"\t\t"+"value: "+subMap.get(key));
        }
        return subMap;
    }

    public void getMapleState() {
    }

    /**
     * @param startupText
     */
    @Override
    public void getMapleState(String startupText) {
        /// #0  Load STARTUP_TEXT.txt User State, Oracle JDBC Driver
        System.out.println(Utilities.startupTime());
        if (startupText == null) {
            startupText = SRC_DATA_STARTUP_TEXT_TXT;
        }
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
            for(Map.Entry<String, String> commandPair : instructionMap.entrySet())
                maplCommands = this.registerCmds(commandPair.getKey(), commandPair.getValue());
            System.out.println("maplCommands #1: " +maplCommands);
//            this.register(mw.getCmdId(),mw); // manually added classes; check for duplicates later
            System.out.println("maplCommands #2: " +maplCommands);
            System.out.println("SCANNERTEXT objects loaded; MaPLwriter '18' manually loaded. Leaving MaPLInvoker now.\n");

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }


    }

    public String[] getCmds() {
        return new String[]{Arrays.toString(cmds)};
    }

    public void setCmd(String[] cmds) {
        this.cmds = cmds;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getCmdId() {
        return cmdId;
    }

    public void setCmdId(Integer cmdId) {
        this.cmdId = cmdId;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public void register(String cmdName, MaPL cmd) {
        IMaPL.super.register(cmdName, cmd);
    }

    @Override
    public void register(Integer cmdName, MaPL cmd) {

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
        String[] sArr = sugg.toUpperCase().replaceAll(suggestRegEx," ").stripLeading()
                .split("\\s+");
        String newString = String.join("_",sArr);
        return newString;
    }
//    @Override
//    public void execute(String cmdName) {
//    }

    /**
     * @param cmdId
     */
    @Override
    public void execute(int cmdId) {
        System.out.println("... MaPL execute(), cmdId: " + cmdId);
    }

    public void execute() {
        MaPLInvoker.showHistory();
        System.out.println("... MaPL execute()");
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

}
