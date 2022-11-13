package xyz.climongoapp.methods.cryptography;

import java.util.Arrays;

public class MaPLblock {

    Integer cmdId = 50;
    String suggestion = "May I start a genesis block?";
    String commandName = "START_A_GENESIS_BLOCK";
    String text = "GENESIS_BLOCK";
    String cmd1 = "GENESIS";
    String cmd2 = "_BLOCK";
    String cmd3 = "thomasmaestas.net";
    String[] cmds = new String[]{text, cmd1, cmd2, cmd3};

    private int previousHash;
    private String[] transactions;
    private int blockHash;

    public MaPLblock(int previousHash, String[] transactions) {
        this.previousHash = previousHash;
        this.transactions = transactions;
        this.blockHash = Arrays.hashCode(
                new Object[]{Arrays.hashCode(transactions), previousHash}
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
}

