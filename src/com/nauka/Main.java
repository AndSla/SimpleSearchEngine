package com.nauka;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        Database db = new Database();

        int n = ui.getNumberOfDataLines();

        for (int i = 0; i < n; i++) {
            String person = ui.getPersonString();
            db.addPerson(person);
        }

        int m = ui.getNumberOfSearchQueries();

        for (int i = 0; i < m; i++) {
            String data = ui.getSearchQuery();
            HashSet<String> foundedPersons = db.find(data);
            ui.printSearchEngineResult(foundedPersons);
        }

    }

}
