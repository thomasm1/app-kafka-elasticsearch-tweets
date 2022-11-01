package xyz.cryptomaven.app.models;

import java.util.Map;

public class MaPL implements IMaPL {

    @Override
    public void register(String cmdName, MaPL cmd) {
        IMaPL.super.register(cmdName, cmd);
    }

    public void registerCmds(Map<String, String> dataMap) {

    }

    @Override
    public void execute(String cmdName) {

    }

    public void execute() {
    }

    public void getMapleState() {
    }

}
