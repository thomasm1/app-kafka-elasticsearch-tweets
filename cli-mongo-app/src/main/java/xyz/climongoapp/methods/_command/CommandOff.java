package xyz.climongoapp.methods._command;

public class CommandOff implements Command {
    ReceiverDevice device;

    public CommandOff(ReceiverDevice device) {

        this.device = device;
    }

    @Override
    public void execute(String cmdName) {

    }

    @Override
    public void execute() {
        device.off();
    }
}
