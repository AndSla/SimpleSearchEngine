package com.nauka;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

//Single strategy
public class SearchAll implements SearchStrategy {

    Database db;

    public SearchAll(Database db) {
        this.db = db;
    }

    @Override
    public List<String> find(String data) {
        String[] wordsToFind = data.toLowerCase().split("\\s+");
        List<List<String>> foundPersonsLists = new ArrayList<>();

        for (String word : wordsToFind) {
            List<String> foundPersons = new ArrayList<>();
            Set<Integer> positions;

            if ((positions = db.getInvertedIndex().get(word)) != null) {
                for (Integer position : positions) {
                    foundPersons.add(db.getPersons().get(position));
                }
            }

            foundPersonsLists.add(foundPersons);

        }

        List<String> foundPersons = foundPersonsLists.get(0);

        for (int i = 1; i < foundPersonsLists.size(); i++) {
            foundPersons.retainAll(foundPersonsLists.get(i));
        }

        return foundPersons;

    }

}
