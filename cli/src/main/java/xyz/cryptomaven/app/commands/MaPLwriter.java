package xyz.cryptomaven.app.commands;

public class MaPLwriter extends MaPL {
    ReceiverConsole device = new ReceiverConsole();
    Integer cmdId = 18;
    String suggestion = "May I print something to the screen?";
    String commandName = "PRINT_SOMETHING_TO_THE_SCREEN";

    String text = "this is MaPLwriter";
    String cmd1 = "nslookup -type=text thomasmaestas.net";
    String cmd2 = "nslookup -type=mx " +
            "thomasmaestas.net";
    String cmd3 = "nslookup -type=ns thomasmaestas.net";
    String[] cmds = new String[] { text, cmd1, cmd2, cmd3 };


    public String[] getCmds() {
        return cmds;
    }

    public void setCmds(String[] cmds) {
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
    public void register(String cmdName, MaPLwriter cmd) {
    }

    @Override
    public void register(Integer cmdName, MaPLwriter cmd) {

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
        device.write(new String[] {"manually written", cmd1, String.valueOf( cmdId )});
    }

    public void execute() {
       try {
           device.write(getCmds());
       } catch (NullPointerException e) {
           System.out.println(e.getMessage());;
       }
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
