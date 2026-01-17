package org.example;

public class Location {
    private String country;

    //campuri optionale
    private String city;
    private String address;
    private double latitude;
    private double longitude;

    private Location(Builder builder) {
        this.country = builder.country;
        this.city = builder.city;
        this.address = builder.address;
        this.latitude = builder.latitude;
        this.longitude = builder.longitude;
    }

    public static class Builder {
        private String country;

        //campuri optionale
        private String city;
        private String address;
        private double latitude;
        private double longitude;

        public Builder (String country) {
            this.country = country;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public Builder setLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public Location build() {
            return new Location(this);
        }
    }
}
