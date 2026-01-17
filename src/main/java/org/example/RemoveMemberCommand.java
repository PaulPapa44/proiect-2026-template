package org.example;

import java.util.List;
import java.util.Map;

public class RemoveMemberCommand implements Command{
    private final Map<String, ResourceGroup> map;

    public RemoveMemberCommand(Map<String, ResourceGroup> map) {
        this.map = map;
    }

    public String execute(String[] args) throws MissingIpAddressException, UserException {
        if (args[1].isEmpty()) {
            throw new MissingIpAddressException("REMOVE MEMBER: MissingIpAddressException: Server IP Address was not provided. ## line no: " + Main.lineNumber);
        }

        if (args[2].isEmpty() || args[3].isEmpty()) {
            throw new UserException("REMOVE MEMBER: UserException: Name and role can't be empty. ## line no: " +  Main.lineNumber);
        }

        ResourceGroup group = map.get(args[1]);
        if (group == null) {
            return "REMOVE MEMBER: Group not found: ipAddress = " + args[1];
        }

        List<User> members = group.getMembers();
        for (User member : members) {
            if (args[2].equals(member.getName())) {
                members.remove(member);
                return "REMOVE MEMBER: " + args[1] + ": name = " + args[2] + " && role = " + args[3];
            }
        }
        return "REMOVE MEMBER: Member not found: ipAddress = " + args[1] + ": name = " + args[2] + " && role = " + args[3];
    }
}
