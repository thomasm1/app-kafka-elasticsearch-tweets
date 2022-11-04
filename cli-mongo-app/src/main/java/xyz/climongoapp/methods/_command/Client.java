package xyz.climongoapp.methods._command;

public class Client {
    public static void main(String[] args) {
        ReceiverDevice device = new ReceiverDevice();

        InvokeControl remoteControl = new InvokeControl();

        CommandOn on = new CommandOn(device);
        remoteControl.setCommand(on);
        remoteControl.pressButton();
        System.out.println("-----register");

        CommandOff off = new CommandOff(device);
        remoteControl.register("customNameOff", off);
        remoteControl.execute("customNameOff");

        remoteControl.execute("wrong");

        remoteControl.register("myNewOn", on);
        remoteControl.execute("myNewOn");

    }
}
