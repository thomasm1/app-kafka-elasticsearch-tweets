package xyz.cryptomaven.app.commands;

public class MaPLwriter implements IMaPL {
    ReceiverConsole device;
    Integer cmdId = 18;
    String suggestion = "May I print something to the screen?";
    String commandName = "PRINT_SOMETHING_TO_THE_SCREEN";

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
    public void register(String cmdName, MaPLwriter cmd) {
    }

    @Override
    public void register(Integer cmdName, MaPLwriter cmd) {

    }

    public void registerCmds(String key, String value) {
    }

    @Override
    public void execute(String cmdName) {

    }

    /**
     * @param cmdId
     */
    @Override
    public void execute(int cmdId) {
        device.write(new String[] {String.valueOf( cmdId )});
    }

    public void execute() {

    }

    /**
     * @param cmdName
     * @param cmd
     */
    @Override
    public void register(Integer cmdName, MaPL cmd) {

    }

    public void getMapleState() {
    }
}
