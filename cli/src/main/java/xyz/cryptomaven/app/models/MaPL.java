package xyz.cryptomaven.app.models;

import java.util.Map;

public class MaPL implements IMaPL {

    @Override
    public void register(String cmdName, MaPL cmd) {
        IMaPL.super.register(cmdName, cmd);
    }

    public void registerCmds(String key, String value) {
    }

    @Override
    public void execute(String cmdName) {

    }

    public void execute() {
    }

    public void getMapleState() {
    }
}
