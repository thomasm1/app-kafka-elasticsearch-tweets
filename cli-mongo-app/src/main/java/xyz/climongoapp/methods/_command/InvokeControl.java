package xyz.climongoapp.methods._command;

import java.util.HashMap;
import java.util.Map;

public class  InvokeControl implements Command {
    private Command command;

    public Map commands = new HashMap<String, Command>();

    public void register(String cmdName, Command cmd) {
    commands.put(cmdName, cmd);
    }
    @Override
    public void execute(String cmdName) {
        if(commands.containsKey(cmdName)) {
            Command c = (Command) commands.get(cmdName);
            c.execute();
        } else {
            System.out.println("CMD not recognized");
        }
    }

    public void pressButton() {
        command.execute();
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    @Override
    public void execute() {

    }
}
