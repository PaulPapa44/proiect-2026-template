package org.example;

public class AddEventCommand implements Command {

    public AddEventCommand() {
    }

    @Override
    public String execute(String[] args) {
        String ipAddress = args[3];
        String message = args[4];
        return "ADD EVENT: " + ipAddress + ": type = " + args[1] + " && severity = " + args[2] + " && message = "+ message;
    }
}