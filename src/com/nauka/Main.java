package com.nauka;

import java.io.File;
import java.util.List;

// Strategy pattern
public class Main {

    public static void main(String[] args) {
        UserInterface ui = new UserInterface();
        Database db = new Database();
        SearchTool searchTool = new SearchTool();

        File databaseFile = ui.getDatabaseFile(args[0], args[1]);
        db.loadDatabaseFileToMemory(databaseFile);

        while (ui.isSupposeToRun()) {
            int menuItem = ui.getMainMenuItem();

            switch (menuItem) {
                case 1:
                    String chosenStrategy = ui.getStrategy();

                    switch (chosenStrategy) {
                        case "all":
                            searchTool.setSearchStrategy(new SearchAll(db));
                            break;
                        case "any":
                            searchTool.setSearchStrategy(new SearchAny(db));
                            break;
                        case "none":
                            searchTool.setSearchStrategy(new SearchNone(db));
                            break;
                    }

                    String data = ui.getSearchQuery();
                    List<String> foundedPeople = searchTool.find(data);
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
