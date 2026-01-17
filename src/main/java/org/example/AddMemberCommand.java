package org.example;

import java.util.Map;

public class AddMemberCommand implements Command {
    private final Map<String, ResourceGroup> map;

    public AddMemberCommand(Map<String, ResourceGroup> map) {
        this.map = map;
    }

    public String execute(String[] args) throws MissingIpAddressException {
        if (args[1].isEmpty()) {
            throw new MissingIpAddressException("ADD MEMBER: MissingIpAddressException: Server IP Address was not provided. ## line no: " + Main.lineNumber);
        } else {
            ResourceGroup group = map.get(args[1]);

            String name = args[2];
            String role = args[3];
            String email = args[4];
            String department = args[5];

            User newUser;

            if (role.equals("Admin")) {
                int clearance = Integer.parseInt(args[6]);
                newUser = new Admin(name, role, email, department, clearance);
            } else {
                newUser = new Operator(name, role, email, department);
            }

            group.addMember(newUser);
        }
        return "ADD MEMBER: " + args[1] + ": name = " + args[2] + " && role = " + args[3];
    }
}
