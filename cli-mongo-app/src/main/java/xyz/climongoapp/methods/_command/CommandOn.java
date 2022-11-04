package xyz.climongoapp.methods._command;

public class CommandOn implements Command {
    ReceiverDevice device;

    public CommandOn(ReceiverDevice device) {
        this.device = device;
    }

    @Override
    public void execute(String cmdName) {

    }
    @Override
    public void execute() {
        device.on();
    }
}
