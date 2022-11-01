package xyz.cryptomaven.app.controllers;

import xyz.cryptomaven.app.models.IMaPL;
import xyz.cryptomaven.app.models.MaPL;

import java.util.HashMap;
import java.util.Map;

public class MaPLControl implements IMaPL {
    private MaPL maplCommand;
    public Map<String, MaPL> maplCommands = new HashMap<String, MaPL>();

    @Override
    public void register(String cmdName, MaPL cmd) {
        //        IMaPL.super.register(cmdName, cmd);
        maplCommands.put(cmdName, cmd);
    }
    public void registerCmds(Map<String, String> dataMap) {
        // TODO map datamap values [commands] to register commands

        // TODO implement registered commands to MaPL instance tasks
    }
    @Override
    public void getMapleState() {

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
