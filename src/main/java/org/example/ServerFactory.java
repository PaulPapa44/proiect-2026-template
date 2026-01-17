package org.example;

public class ServerFactory {
    public static Server createServer(String[] args) {
        double latitude = 0.0;
        if (!args[7].isEmpty()) {
            latitude = Double.parseDouble(args[7]);
        }

        double longitude = 0.0;
        if (!args[8].isEmpty()) {
            longitude = Double.parseDouble(args[8]);
        }

        int cpuCores = 0;
        if (!args[14].isEmpty()) {
            cpuCores = Integer.parseInt(args[14]);
        }

        int ramGb = 0;
        if (!args[15].isEmpty()) {
            ramGb = Integer.parseInt(args[15]);
        }

        int storageGb = 0;
        if (!args[16].isEmpty()) {
            storageGb = Integer.parseInt(args[16]);
        }

        Location location = new Location.Builder(args[4]).setCity(args[5]).setAddress(args[6]).setLatitude(latitude).setLongitude(longitude).build();
        User owner = new User(args[9], args[10], args[11]);
        return new Server.Builder(args[2], location, owner).setHostname(args[1]).setStatus(ServerStatus.valueOf(args[3])).setCpuCores(cpuCores).setRamGb(ramGb).setStorageGb(storageGb).build();
    }
}
