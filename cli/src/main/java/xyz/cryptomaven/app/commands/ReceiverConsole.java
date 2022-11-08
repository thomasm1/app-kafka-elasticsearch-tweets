package xyz.cryptomaven.app.commands;

public class ReceiverConsole {
    public void write(String[] args) {
        for (String s : args) {
            System.out.println( s+" ");
        }
    }
}
