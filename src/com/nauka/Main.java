package com.nauka;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Database db = new Database();

        File databaseFile = ui.getDatabaseFile(args[0], args[1]);
        db.loadDatabaseFileToMemory(databaseFile);

        while (ui.isSupposeToRun()) {
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
                    ui.showExitMessage();
                    ui.setSupposeToRun(false);
            }

        }
    }

}
