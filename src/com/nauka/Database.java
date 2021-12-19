package com.nauka;

import java.util.HashSet;

public class Database {

    private final HashSet<String> persons = new HashSet<>();

    void addPerson(String person) {
        persons.add(person);
    }

    HashSet<String> find(String data) {
        HashSet<String> foundPersons = new HashSet<>();
        for (String person : persons) {
            if (person.toLowerCase().contains(data.toLowerCase())) {
                foundPersons.add(person);
            }
        }
        return foundPersons;
    }

}
