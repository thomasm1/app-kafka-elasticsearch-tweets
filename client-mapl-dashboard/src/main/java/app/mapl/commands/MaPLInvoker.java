package app.mapl.commands;

import app.mapl.util.Utilities;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class MaPLInvoker extends MaPL{
    public MaPLInvoker() {
        System.out.println("SRC_DATA_STARTUP_TEXT_TXT MaPLInvoker.getMapleState() = " );

        System.out.println("MaPLInvoker.getMapleState() = "  );

    };


    public MaPLInvoker(String startupText) {
        if (startupText == null) {
            startupText = SRC_DATA_STARTUP_TEXT_TXT;
        }
        System.out.println("SRC_DATA_STARTUP_TEXT_TXT MaPLInvok er.getMapleState() = "+startupText  );

    };

    private String suggestRegEx = "HOW |MAY |CAN |SHALL |I |AM |YOU |YOUR |MY |WANT |ABOUT |READY|'s|[!?.,:]+|SO ";
    private static  int duplicate = 0;
    MaPL mw = new MaPLwriter();
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver"; //  DEFAULT DRIVER
    private Map<String, String> instructionMap = new TreeMap<>(); // STARTUP INSTRUCTION SET   "11=Run Websites Health Check"
    private Map<Integer,MaPL> maplCommands = new HashMap<>();
    private static Map<Integer, String> sessionHistory = new LinkedHashMap<>();

    static void showHistory() {
        System.out.println("CMD HISTORY = ");
        // print history of each time a command invoked
        for(Map.Entry<Integer, String> key: sessionHistory.entrySet()) {
            System.out.print("key: "+key.getKey() + ", command: "+ key.getValue() + " || ");
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

    /**
     *
     */
    @Override
    public void getMapleState() {

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


    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(String cmdName, MaPLwriter cmd) {
    maplCommands.put(Integer.valueOf(cmdName), cmd);
    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPLwriter cmd) {

    }
    protected static void loadDefault() {
        readStartupFile(SRC_DATA_STARTUP_TEXT_TXT);
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
            sessionHistory.put((int) new Date().getTime(), ((MaPL) m).getCommandName());
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


//    public void setCommand(MaPLControl maPLControl) {
//    }
}
