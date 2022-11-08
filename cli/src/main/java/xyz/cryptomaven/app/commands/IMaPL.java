package xyz.cryptomaven.app.commands;

import java.util.Map;

public interface IMaPL {
    
    String DRIVER = null;
    String SRC_DATA_STARTUP_TEXT_TXT = null;
    

    default void register(String cmdName, MaPL cmd) {}
    default void registerCmds(Map<String, String> dataMap) {}

    void register(Integer cmdName, MaPL cmd);

    void getMapleState();

    void register(String cmdName, MaPLwriter cmd);

    void register(Integer cmdName, MaPLwriter cmd);

//    void execute(String cmdName);

    void execute(int cmdId);

    void execute();
}
