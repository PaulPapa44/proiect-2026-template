package org.example;

import java.util.Objects;

public class User {
    private final String name;
    private final String role;
    private final String email;

    public User(String name, String role, String email) {
        this.name = name;
        this.role = role;
        this.email = email;
    }

    public String getName() {
        return this.name;
    }

    public String getRole() {
        return this.role;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;
        return Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
