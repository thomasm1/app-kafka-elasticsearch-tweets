package xyz.cryptomaven.app.commands;

public class ReceiverConsole {
    public void write(String[] args) {
        System.out.print("ReceiverConsole Device: ");
        for (String s : args) {
            System.out.println( s+" ");
        }
    }
}
