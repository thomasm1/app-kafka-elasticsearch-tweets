package xyz.cryptomaven.app.commands;

public   class MaPL implements IMaPL {

    Integer cmdId = 0;
    String suggestion;
    String commandName;

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

    }

    public void execute() {
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

    public String[] getCmds() {
        return new String[] {"maple","--Maple abstract class"};
    }
}
