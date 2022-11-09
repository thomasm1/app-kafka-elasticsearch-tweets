package xyz.cryptomaven.app.commands;

import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.util.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;

public class MaPLInvoker implements IMaPL {
    private String suggestRegEx = "HOW |MAY |CAN |SHALL |I |AM |YOU |YOUR |MY |WANT |ABOUT |READY|'s|[!?.,:]+|SO ";
    private static  int duplicate = 0;
    MaPL mw = new MaPLwriter();
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; //  DEFAULT DRIVER
    private static final String SRC_DATA_STARTUP_TEXT_TXT = "src/data/STARTUP_TEXT.txt"; // DEFAULT INSTRUCTION SOURCE
    private Map<String, String> instructionMap = new TreeMap<>(); // STARTUP INSTRUCTION SET   "11=Run Websites Health Check"
    private Map<Integer,MaPL> maplCommands = new HashMap<>();

    public Map<Integer, MaPL> getMaplCommands() {
        return maplCommands;
    }

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
        maplCommands.put( mapl.

                getCmdId(), mapl );

        System.out.println(mapl.getCmdId() + ": "+mapl.getCommandName());
        return maplCommands;
    }

    private String suggToCmd(String sugg) {
        String[] sArr = sugg.toUpperCase().replaceAll(suggestRegEx," ").stripLeading()
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
                for(Map.Entry<String, String> commandPair : instructionMap.entrySet())
                    maplCommands = this.registerCmds(commandPair.getKey(), commandPair.getValue());
                System.out.println("maplCommands #1: " +maplCommands);
                this.register(mw.getCmdId(),mw); // manually added classes; check for duplicates later
                System.out.println("maplCommands #2: " +maplCommands);
                System.out.println("SCANNERTEXT objects loaded; MaPLwriter '18' manually loaded. Leaving MaPLInvoker now.\n");

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
            getClassProps(m);
            m.execute();
        } else {
            System.out.println("CMD not recognized\n");
        }
    }

    private void getClassProps(IMaPL m) {
        System.out.println("\nm.getClass(): "+m.getClass());
        System.out.println("getSuggestion: "+((MaPL) m).getSuggestion());
        System.out.println("getCommandName: "+ ((MaPL) m).getCommandName());
        System.out.println("m.getCmds(): " + Arrays.toString(m.getCmds()));
        Utilities.getReflectionInfo(m);
           }

    @Override
    public void execute() {
        System.out.println("... MaPLInvoker execute()");
    }
    //    private Map<String, Map<Integer,MaPL>> commandsMapping = new HashMap<>();
//    public Map<String, Map<Integer, MaPL>> getCommandsMapping() {
//        return commandsMapping;
//    }
    /**
     * @return string of Mapl-specific commands
     */
    @Override
    public String[] getCmds() {
        return new String[0];
    }
}
