package org.example;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static int lineNumber = 0;

    public static void main(String[] args) {
        // Verificăm dacă avem modul corect și cel puțin un fișier
        if (args.length > 1 && (args[0].equals("servers") || args[0].equals("groups") || args[0].equals("listener"))) {

            // 1. Inițializăm "baza de date" o singură dată, în afara buclei de fișiere
            Map<String, ResourceGroup> groupMap = new HashMap<>();

            // 2. Iterăm prin TOATE argumentele rămase (fișierele de intrare)
            for (int i = 1; i < args.length; i++) {
                try {
                    String inputFilePath = args[i];
                    BufferedReader reader = new BufferedReader(new FileReader(inputFilePath + ".in"));
                    BufferedWriter writer = new BufferedWriter(new FileWriter(inputFilePath + ".out"));

                    // Resetăm linia pentru fiecare fișier nou
                    lineNumber = 0;
                    String line;

                    while ((line = reader.readLine()) != null) {

                        // Sărim peste liniile goale
                        if (line.trim().isEmpty()) {
                            continue;
                        }

                        try {
                            String[] arguments = line.split("\\|");
                            String commandName = arguments[0];
                            Command command = null;

                            switch (commandName) {
                                case "ADD SERVER":
                                    lineNumber++;
                                    command = new AddServerCommand();
                                    break;
                                case "ADD GROUP":
                                    lineNumber++;
                                    command = new AddGroupCommand(groupMap);
                                    break;
                                case "ADD MEMBER":
                                    lineNumber++;
                                    command = new AddMemberCommand(groupMap);
                                    break;
                                case "FIND GROUP":
                                    lineNumber++;
                                    command = new FindGroupCommand(groupMap);
                                    break;
                                case "REMOVE GROUP":
                                    lineNumber++;
                                    command = new RemoveGroupCommand(groupMap);
                                    break;
                                case "FIND MEMBER":
                                    lineNumber++;
                                    command = new FindMemberCommand(groupMap);
                                    break;
                                case "REMOVE MEMBER":
                                    lineNumber++;
                                    command = new RemoveMemberCommand(groupMap);
                                    break;
                                case "ADD EVENT":
                                    lineNumber++;
                                    command = new AddEventCommand();
                                    break;
                            }

                            if (command != null) {
                                String result = command.execute(arguments);
                                writer.write(result + "\n");
                            }

                        } catch (Exception e) {
                            writer.write(e.getMessage());
                            writer.newLine();
                        }
                    }

                    // Închidem resursele pentru fișierul curent înainte de a trece la următorul
                    writer.close();
                    reader.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}