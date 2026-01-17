package org.example;

public class AddServerCommand implements Command {

    @Override
    public String execute(String[] args) throws LocationException, UserException, MissingIpAddressException {
        if (args[10].isEmpty() || args[9].isEmpty()) {
            throw new UserException("ADD SERVER: UserException: Name and role can't be empty. ## line no: " + Main.lineNumber);
        } else {
            if (args[4].isEmpty()) {
                throw new LocationException("ADD SERVER: LocationException: Country is missing. ## line no: " + Main.lineNumber);
            } else {
                if (args[2].isEmpty()) {
                    throw new MissingIpAddressException("ADD SERVER: MissingIpAddressException: Server IP Address was not provided. ## line no: " + Main.lineNumber);
                } else {
                    Server server = ServerFactory.createServer(args);
                    Database.getInstance().addServer(server);
                    return "ADD SERVER: " + server.getIpAddress() + ": " + server.getStatus();
                }
            }
        }
    }
}