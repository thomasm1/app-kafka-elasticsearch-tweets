package xyz.cryptomaven.app.models;

import java.util.Map;

public interface IMaPL {
    
    String DRIVER = null;
    String SRC_DATA_STARTUP_TEXT_TXT = null;
    

    default void register(String cmdName, MaPL cmd) {}
    default void registerCmds(Map<String, String> dataMap) {}

    void register(Integer cmdName, MaPL cmd);

    void getMapleState();

    void execute(String cmdName);

    void execute();
}
