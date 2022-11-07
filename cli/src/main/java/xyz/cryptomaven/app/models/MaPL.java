package xyz.cryptomaven.app.models;

public class MaPL implements IMaPL {

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

    @Override
    public void execute(String cmdName) {

    }

    public void execute() {
    }

    public void getMapleState() {
    }
}
