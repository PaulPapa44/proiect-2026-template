package org.example;

public class Operator extends User {
    private final String departament;
    public Operator(String name, String role, String email, String departament) {
        super(name, role, email);
        this.departament = departament;
    }

    public String getDepartament() {
        return this.departament;
    }
}
