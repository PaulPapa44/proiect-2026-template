package org.example;

import java.util.List;
import java.util.Map;

public class FindMemberCommand implements Command{
    private final Map<String, ResourceGroup> map;

    public FindMemberCommand(Map<String, ResourceGroup> map) {
        this.map = map;
    }

    public String execute(String[] args) throws MissingIpAddressException, UserException {
        if (args.length < 2 || args[1].isEmpty()) {
            throw new MissingIpAddressException("FIND MEMBER: MissingIpAddressException: Server IP Address was not provided. ## line no: " + Main.lineNumber);
        }

        if (args[2].isEmpty() || args[3].isEmpty()) {
            throw new UserException("FIND MEMBER: UserException: Name and role can't be empty. ## line no: " +  Main.lineNumber);
        }

        ResourceGroup group = map.get(args[1]);
        if (group == null) {
            return "FIND MEMBER: Group not found: ipAddress = " + args[1];
        }

        List<User> members = group.getMembers();
        for (User member : members) {
            if (args[2].equals(member.getName())) {
                return "FIND MEMBER: " + args[1] + ": name = " + args[2] + " && role = " + args[3];
            }
        }
        return "FIND MEMBER: Member not found: ipAddress = " + args[1] + ": name = " + args[2] + " && role = " + args[3];
    }

}
