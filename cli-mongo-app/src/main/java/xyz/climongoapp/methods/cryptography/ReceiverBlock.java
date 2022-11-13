package xyz.climongoapp.methods.cryptography;

public class ReceiverBlock {

    public static void main(String[] args) {
        String[] genesisTransactions = { "B satoshi sent thomas 1 BTC", "thomas sent C 1 BTC"};
        MaPLblock genesisBlock = new MaPLblock(0, genesisTransactions);

        String[] block2Transactions = { "B satoshi sent thomas 2 BTC", "thomas sent C 1 BTC"};
        MaPLblock block2 = new MaPLblock(genesisBlock.getBlockHash(), block2Transactions);

        String[] block3Transactions = { "B satoshi sent thomas 2 BTC", "thomas sent C .5 BTC"};
        MaPLblock block3 = new MaPLblock(block2.getBlockHash(), block3Transactions);

        System.out.println("hash of genesis block");
        System.out.println(genesisBlock.getBlockHash());

        System.out.println("hash of block 2");
        System.out.println(block2.getBlockHash());

        System.out.println("hash of block 3");
        System.out.println(block3.getBlockHash());
    }

    public void write(String[] args) {
        System.out.print("ReceiverConsole Device: ");
        for (String s : args) {
            System.out.println( s+" ");
        }
    }

    public void writeHistory(String[] args) {
        System.out.print("ReceiverConsole Device: ");
        for (String s : args) {
            System.out.println( s+" ");
        }
    }
}
