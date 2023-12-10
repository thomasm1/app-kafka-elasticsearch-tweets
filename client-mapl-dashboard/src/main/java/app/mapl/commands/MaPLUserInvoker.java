package app.mapl.commands;

import app.mapl.models.User;
import app.mapl.repositories.UsersRepository;
import app.mapl.util.Utilities;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class MaPLUserInvoker extends MaPL {

    private UsersRepository usersRepository;
    @Autowired
    private User u = new User();

    static String STARTUP_TEXT = SRC_DATA_STARTUP_TEXT_TXT;


    public MaPLUserInvoker() {
        System.out.println("MaPLInvoker.getMapleState() = "  );

    };
    public MaPLUserInvoker(String startupText) {
        if (startupText.equals("")) {
            startupText = SRC_DATA_STARTUP_TEXT_TXT;
        }
        System.out.println("SRC_DATA_STARTUP_TEXT_TXT MaPLInvoker.getMapleState() = "+startupText  );

    };

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


    /**
     *
     */
    @Override
    public void getMapleState() {
        //  implement pre-registered commands to MaPL instance tasks
        usersRepository.findAll().forEach(System.out::println);

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
