package org.example;

public class Alert {
    AlertType type;
    Severity severity;
    String message;
    String ipAddress;

    public Alert(AlertType type, Severity severity, String message, String ipAddress) {
        this.type = type;
        this.severity = severity;
        this.message = message;
        this.ipAddress = ipAddress;
    }

    public Alert() {}
}
