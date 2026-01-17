package org.example;

import java.util.Map;

public class FindGroupCommand implements Command{
    private final Map<String, ResourceGroup> map;

    public FindGroupCommand(Map<String, ResourceGroup> map) {
        this.map = map;
    }

    public String execute(String[] args) {
        if (args.length < 2 || args[1].isEmpty()) {
            throw new MissingIpAddressException("FIND GROUP: MissingIpAddressException: Server IP Address was not provided. ## line no: " + Main.lineNumber);
        } else {
            ResourceGroup group = map.get(args[1]);
            if (group == null) {
                return "FIND GROUP: Group not found: ipAddress = " + args[1];
            }
            return "FIND GROUP: " + args[1];
        }
    }
}
