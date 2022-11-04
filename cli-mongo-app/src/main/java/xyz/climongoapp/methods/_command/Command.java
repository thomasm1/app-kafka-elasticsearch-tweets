package xyz.climongoapp.methods._command;

public interface Command {
    default void register(String cmdName, Command cmd) {

    }
    void execute(String cmdName);
    public void execute();
}
