package xyz.cryptomaven.app.commands;

import java.util.Arrays;

public   class MaPL implements IMaPL {

    Integer cmdId = 0;
    String suggestion;
    String commandName;
    String text = "maple";
    String cmd1 = "cmd1";
    String cmd2 = "cmd2";
    String cmd3 = "cmd3";
    String[] cmds = { text, cmd1, cmd2, cmd3 };


    public String[] getCmds() {
        return new String[] {Arrays.toString(cmds)};
    }
    public void setCmd(String[] cmds) {
        this.cmds = cmds;
    }

    public String getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(String suggestion) {
        this.suggestion = suggestion;
    }

    public Integer getCmdId() {
        return cmdId;
    }

    public void setCmdId(Integer cmdId) {
        this.cmdId = cmdId;
    }

    public String getCommandName() {
        return commandName;
    }

    public void setCommandName(String commandName) {
        this.commandName = commandName;
    }

    @Override
    public void register(String cmdName, MaPL cmd) {
        IMaPL.super.register(cmdName, cmd);
    }

    @Override
    public void register(Integer cmdName, MaPL cmd) {

    }

    public void registerCmds(String key, String value) {
    }

//    @Override
//    public void execute(String cmdName) {
//    }

    /**
     * @param cmdId
     */
    @Override
    public void execute(int cmdId) {
        System.out.println("... MaPL execute(), cmdId: " + cmdId);
    }

    public void execute() {
        MaPLInvoker.showHistory();
        System.out.println("... MaPL execute()");
    }

    public void getMapleState() {
    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(String cmdName, MaPLwriter cmd) {

    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPLwriter cmd) {

    }

}
