package org.example;

import java.util.ArrayList;
import java.util.List;

public class ResourceGroup {
    private final List<User> members;
    private final String ipAdress;

    public ResourceGroup(String ipAdress) {
        this.ipAdress = ipAdress;
        this.members = new ArrayList<>();
    }

    public void addMember(User user) {
        members.add(user);
    }

    public List<User> getMembers() {
        return this.members;
    }

    public void removeMember(User user) {
        members.remove(user);
    }
}
