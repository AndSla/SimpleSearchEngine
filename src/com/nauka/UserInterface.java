package com.nauka;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner sc = new Scanner(System.in);
    private boolean showMsg = true;

    int getNumberOfDataLines() {
        int number;
        System.out.println("Enter the number of people:");
        while (true) {
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.matches("\\d")){
                number = Integer.parseInt(input);
                break;
            }
        }
        return number;
    }

    String getPersonString() {
        if (showMsg) {
            System.out.println("Enter all people:");
            showMsg = false;
        }
        System.out.print("> ");
        return sc.nextLine();
    }

    String getSearchQuery() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        System.out.print("> ");
        return sc.nextLine();
    }

    void printSearchEngineResult(List<String> foundedPersons) {
        if (foundedPersons.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println("Found people:");
            for (String person : foundedPersons) {
                System.out.println(person);
            }
        }
    }

    void printAllPeople(List<String> allPeople) {
        System.out.println("\n=== List of people ===");
        for (String person : allPeople) {
            System.out.println(person);
        }
    }

    int getMainMenuItem() {
        int chosenMenuItem;

        while (true) {
            System.out.println("\n=== Menu ===");
            System.out.println("1. Find a person");
            System.out.println("2. Print all people");
            System.out.println("0. Exit");
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.matches("[0-2]")) {
                chosenMenuItem = Integer.parseInt(input);
                break;
            } else {
                System.out.println("\nIncorrect option! Try again.");
            }
        }

        return chosenMenuItem;

    }

}
