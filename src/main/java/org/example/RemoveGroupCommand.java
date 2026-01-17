package org.example;

import java.util.Map;

public class RemoveGroupCommand implements Command{
    private final Map<String, ResourceGroup> map;

    public RemoveGroupCommand(Map<String, ResourceGroup> map) {
        this.map = map;
    }

    public String execute(String[] args) throws MissingIpAddressException{
        if (args.length < 2 || args[1].isEmpty()) {
            throw new MissingIpAddressException("REMOVE GROUP: MissingIpAddressException: Server IP Address was not provided. ## line no: " + Main.lineNumber);
        } else {
            ResourceGroup group = map.get(args[1]);
            if (group == null) {
                return "REMOVE GROUP: Group not found: ipAddress = " + args[1];
            }
            map.remove(args[1]);
            return "REMOVE GROUP: " + args[1];
        }
    }
}
