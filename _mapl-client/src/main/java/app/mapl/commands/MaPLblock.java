package app.mapl.commands;

import java.util.Arrays;
import java.util.Map;

public class MaPLblock extends MaPL {
    ReceiverConsole device = new ReceiverConsole();
    Integer cmdId = 50;
    String suggestion = "May I start a genesis block?";
    String commandName = "START_A_GENESIS_BLOCK";
    String text = "GENESIS_BLOCK";
    String cmd1 = "GENESIS";
    String cmd2 = "_BLOCK";
    String cmd3 = "thomasmaestas.net";
    String[] cmds = new String[] { text, cmd1, cmd2, cmd3 };

    private int previousHash;
    private String[] transactions;
    private int blockHash;

    public MaPLblock(int previousHash, String[] transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.blockHash = Arrays.hashCode(
                new Object[] {Arrays.hashCode(transactions), previousHash}
        );
    }
    public int getPreviousHash() {
        return previousHash;
    }
    public String[] getTransactions() {
        return transactions;
    }
    public int getBlockHash() {
        return blockHash;
    }

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

    public void register(String cmdName, MaPLblock cmd) {
    }

    public void register(Integer cmdName, MaPLblock cmd) {

    }

    public Map<Integer, MaPL> registerCmds(String key, String value) {
        return null;
    }

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
           System.out.println(e.getMessage());
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
