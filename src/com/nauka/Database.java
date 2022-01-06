package com.nauka;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;

public class Database {

    private List<String> persons = new ArrayList<>();
    private final Map<String, Set<Integer>> invertedIndex = new LinkedHashMap<>();

    void loadDatabaseFileToMemory(File databaseFile) {
        try {
            persons = Files.readAllLines(databaseFile.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
        createInvertedIndex();
    }

    void createInvertedIndex() {
        String[] words;
        Set<Integer> positions;
        int lineNumber = 0;

        for (String person : persons) {
            words = person.split("\\s+");

            for (String word : words) {

                word = word.toLowerCase();

                if (invertedIndex.get(word) != null) {
                    positions = invertedIndex.get(word);
                } else {
                    positions = new HashSet<>();
                }

                positions.add(lineNumber);
                invertedIndex.put(word, positions);

            }

            lineNumber += 1;

        }

    }

    List<String> find(String data) {
        data = data.toLowerCase();
        Set<Integer> positions;
        List<String> foundPersons = new ArrayList<>();

        if ((positions = invertedIndex.get(data)) != null) {
            for (Integer position : positions) {
                foundPersons.add(persons.get(position));
            }
        }

        return foundPersons;
    }

    public List<String> getPersons() {
        return persons;
    }

}
