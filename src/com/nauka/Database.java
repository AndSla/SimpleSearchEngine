package com.nauka;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private List<String> persons = new ArrayList<>();

    void loadDatabaseFileToMemory(File databaseFile) {
        try {
            persons = Files.readAllLines(databaseFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    List<String> find(String data) {
        List<String> foundPersons = new ArrayList<>();
        for (String person : persons) {
            if (person.toLowerCase().contains(data.toLowerCase())) {
                foundPersons.add(person);
            }
        }
        return foundPersons;
    }

    public List<String> getPersons() {
        return persons;
    }

}
