package org.example;

public interface Command{
    public String execute(String[] args) throws LocationException, UserException, MissingIpAddressException;
}
