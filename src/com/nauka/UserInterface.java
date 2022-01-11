package com.nauka;

import java.io.File;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner sc = new Scanner(System.in);
    private boolean supposeToRun = true;

    public boolean isSupposeToRun() {
        return supposeToRun;
    }

    public void setSupposeToRun(boolean supposeToRun) {
        this.supposeToRun = supposeToRun;
    }

    File getDatabaseFile(String param1, String param2) {
        if (param1.equals("--data")) {

            File file = new File(param2);
            if (file.exists()) {
                return file;
            } else {
                System.out.println("There is no such file!");
            }

        } else {
            System.out.println("Wrong parameter! Type --data <filename>");
        }

        supposeToRun = false;
        return null;

    }

    String getSearchQuery() {
        System.out.println("\nEnter a name or email to search all suitable people.");
        System.out.print("> ");
        return sc.nextLine();
    }

    void printSearchEngineResult(List<String> foundedPersons) {
        if (foundedPersons.isEmpty()) {
            System.out.println("\nNo matching people found.");
        } else {
            System.out.println("\n" + foundedPersons.size() + " persons found:");
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

    String getStrategy() {
        String chosenStrategy;

        while (true) {
            System.out.println("\nSelect a matching strategy: ALL, ANY, NONE");
            System.out.print("> ");
            String input = sc.nextLine();
            if (input.toLowerCase().matches("all|any|none")) {
                chosenStrategy = input.toLowerCase();
                break;
            } else {
                System.out.println("\nIncorrect option! Try again.");
            }
        }

        return chosenStrategy;

    }

    void showExitMessage() {
        System.out.println("\nBye!");
    }

}
