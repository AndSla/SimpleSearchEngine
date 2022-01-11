package com.nauka;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Single strategy
public class SearchNone implements SearchStrategy {

    Database db;

    public SearchNone(Database db) {
        this.db = db;
    }

    @Override
    public List<String> find(String data) {
        String[] wordsToFind = data.toLowerCase().split("\\s+");
        List<String> foundPersons = new ArrayList<>();
        List<String> persons = db.getPersons();

        for (String word : wordsToFind) {
            Set<Integer> positions;

            if ((positions = db.getInvertedIndex().get(word)) != null) {
                for (Integer position : positions) {
                    foundPersons.add(persons.get(position));
                }
            }

        }

        persons.removeAll(foundPersons);

        return persons;
    }

}
