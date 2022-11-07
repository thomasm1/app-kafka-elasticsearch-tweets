package xyz.cryptomaven.app.controllers;

import xyz.cryptomaven.app.constants.Cmds;
import xyz.cryptomaven.app.logger.LogCustom;
import xyz.cryptomaven.app.models.IMaPL;
import xyz.cryptomaven.app.models.MaPL;
import xyz.cryptomaven.app.util.Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MaPLControl implements IMaPL {

    private static final String SRC_DATA_STARTUP_TEXT_TXT = "src/data/STARTUP_TEXT.txt";
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";

//    opening, immutable DATA
    private Map<String, String> dataMap = new TreeMap<>();
    private Map<String, String> commandsMap = new HashMap<>();
    private MaPL  sessionMaPL = new MaPL();

    public Map<String, MaPL> maplCommands = new HashMap<String, MaPL>();

    @Override
    public void register(String cmdName, MaPL cmd) {
        // IMaPL.super.register(cmdName, cmd);
        // TODO implement registered commands to MaPL instance tasks
        maplCommands.put(cmdName, cmd);
    }
    public void registerCmds(String commandID, String command) {
        //   map datamap values [commands] to registered commands
        commandsMap.put( commandID, command );


    }
    @Override
    public void getMapleState() {
        /// #0  Load STARTUP_TEXT.txt User State, Oracle JDBC Driver
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
                String APP_TITLE = scanText.nextLine(); //LINE_3
                System.out.println("'3':APP_TITLE="+APP_TITLE );
                dataMap.put("3",APP_TITLE);

                String AUTHOR = scanText.nextLine(); //LINE_4
                dataMap.put("4",AUTHOR);
                System.out.println("'4':AUTHOR="+AUTHOR);
                int counter = 10; //Miscellaneous Data Starting at LINE 10:  KEY IS LINE NUMBER
                while(scanText.hasNext()) {
                    String scanData = scanText.nextLine();
                    if ((!scanData.startsWith("-|")) && scanText.hasNext()) {
                        // DataMap is static mapping
                        dataMap.put(String.valueOf(counter++), scanData);

                    }
                }
                System.out.println(dataMap.entrySet());
                // REGISTER COMMANDS INTO MaPLControl Instance
                for(Map.Entry<String, String> commandPair : dataMap.entrySet())
                    this.registerCmds(commandPair.getKey(), commandPair.getValue());

            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
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
            MaPL m = maplCommands.get(cmdName);
            m.execute();
        } else {
            System.out.println("CMD not recognized");
        }

    }

    @Override
    public void execute() {

    }
}
