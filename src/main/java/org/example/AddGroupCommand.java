package org.example;

import java.util.Map;

public class AddGroupCommand implements Command{
    private final Map<String, ResourceGroup> map;

    public AddGroupCommand(Map<String, ResourceGroup> map) {
        this.map = map;
    }

    public String execute(String[] args) throws MissingIpAddressException {
        if (args.length < 2 || args[1].isEmpty()) {
            throw new MissingIpAddressException("ADD GROUP: MissingIpAddressException: Server IP Address was not provided. ## line no: " + Main.lineNumber);
        } else {
            if(!map.containsKey(args[1])) {
                ResourceGroup group = new ResourceGroup(args[1]);
                map.put(args[1], group);
            }
        }
        return "ADD GROUP: " + args[1];
    }
}
