package app.mapl.commands;
//import app.mapl.commands.MaPLInvoker;

import java.sql.SQLException;
import java.util.Map;

public interface IMaPL {
    
    String DRIVER = null;
    String SRC_DATA_STARTUP_TEXT_TXT = null;
    default void openMaPLControl() throws SQLException {

    }
    static void sessionMaPL(MaPLInvoker mapleInvokerSession) throws Exception {

    }
    static Map<Integer, String> replayLast(int numberOfCommands) {
        return null;
    }
    static void showHistory() {

    }

    default void register(String cmdName, MaPL cmd) {}
    default void registerCmds(Map<String, String> dataMap) {}

    String[] getCmds();

    void register(Integer cmdName, MaPL cmd);

    void getMapleState();

    void getMapleState(String startupText);

    void register(String cmdName, MaPLwriter cmd);

    void register(Integer cmdName, MaPLwriter cmd);

//    void execute(String cmdName);

    void execute(int cmdId);

    void execute();
    void up();

    void down();

    void left();

    void right();
    void up(Object o);

    void down(Object o);

    void left(Object o);

    void right(Object o);

}
