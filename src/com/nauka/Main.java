package com.nauka;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        Database db = new Database();

        int n = ui.getNumberOfDataLines();

        for (int i = 0; i < n; i++) {
            String person = ui.getPersonString();
            db.addPerson(person);
        }

        boolean keepOnRunning = true;

        while (keepOnRunning) {
            int menuItem = ui.getMainMenuItem();

            switch (menuItem) {
                case 1:
                    String data = ui.getSearchQuery();
                    List<String> foundedPeople = db.find(data);
                    ui.printSearchEngineResult(foundedPeople);
                    break;
                case 2:
                    ui.printAllPeople(db.getPersons());
                    break;
                case 0:
                    System.out.println("\nBye!");
                    keepOnRunning = false;
            }

        }
    }

}
