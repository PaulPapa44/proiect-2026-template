package org.example;

public class Server {
    private final String ipAddress;
    private final Location location;
    // nu se poate folosi singletone pentru owner, fiind instanta unica a clasei User, fiind nevoie de o multitudine de instante
    private final User owner;

    //campuri optionale
    private final String hostname;
    private final ServerStatus status;
    private final Integer cpuCores;
    private final Integer ramGb;
    private final Integer storageGb;

    //voi folosi design pattern-ul Builder
    private Server(Builder builder) {
        this.ipAddress = builder.ipAddress;
        this.location = builder.location;
        this.owner = builder.owner;
        this.hostname = builder.hostname;
        this.status = builder.status;
        this.cpuCores = builder.cpuCores;
        this.ramGb = builder.ramGb;
        this.storageGb = builder.storageGb;
    }

    public static class Builder {
        private String ipAddress;
        private Location location;
        private User owner;

        //campuri optionale
        private String hostname;
        private ServerStatus status;
        private Integer cpuCores;
        private Integer ramGb;
        private Integer storageGb;

        public Builder (String ipAddress, Location location, User owner) {
            this.ipAddress = ipAddress;
            this.location = location;
            this.owner = owner;
        }

        public Builder setHostname (String hostname) {
            this.hostname = hostname;
            return this;
        }

        public Builder setStatus(ServerStatus status) {
            this.status = status;
            return this;
        }

        public Builder setCpuCores(Integer cpuCores) {
            this.cpuCores = cpuCores;
            return this;
        }

        public Builder setRamGb(Integer ramGb) {
            this.ramGb = ramGb;
            return this;
        }

        public Builder setStorageGb(Integer storageGb) {
            this.storageGb = storageGb;
            return this;
        }

        public Server build() {
            return new Server(this);
        }
    }
    public String getIpAddress() {
        return this.ipAddress;
    }

    public ServerStatus getStatus() {
        return this.status;
    }
}
