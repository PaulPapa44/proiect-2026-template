package org.example;

import java.util.HashSet;
import java.util.Set;

//trebuie implementat singletone
public class Database {
    private static Database instance;
    private Database() {}
    public static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    Set<Server> servers = new HashSet<Server>();
    Set<ResourceGroup> resourceGroups = new HashSet<ResourceGroup>();
    Set<Alert> alerts = new HashSet<>();

    public void addServer(Server server) {
        servers.add(server);
    }

    public void addServers(Set<Server> servers) {
        this.servers.addAll(servers);
    }

    public void addResourceGroup(ResourceGroup resourceGroup) {
        resourceGroups.add(resourceGroup);
    }

    public void addResourceGroups(Set<ResourceGroup> resourceGroups) {
        this.resourceGroups.addAll(resourceGroups);
    }

    public void addAlert(Alert alert) {
        alerts.add(alert);
    }
}
