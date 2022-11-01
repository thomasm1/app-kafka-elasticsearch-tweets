package xyz.cryptomaven.app.models;

import org.apache.logging.log4j.core.tools.picocli.CommandLine;

import java.util.Map;

public interface IMaPL {

    default void register(String cmdName, MaPL cmd) {}
    default void registerCmds(Map<String, String> dataMap) {}
    void getMapleState();

    void execute(String cmdName);

    void execute();
}
