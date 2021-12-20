package com.nauka;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private final List<String> persons = new ArrayList<>();

    void addPerson(String person) {
        persons.add(person);
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
