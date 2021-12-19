package com.nauka;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private final Scanner sc = new Scanner(System.in);
    private boolean showMsg = true;
    private boolean eatEol = true;

    int getNumberOfDataLines() {
        System.out.println("Enter the number of people:");
        System.out.print("> ");
        return sc.nextInt();
    }

    int getNumberOfSearchQueries() {
        System.out.println("\nEnter the number of search queries:");
        System.out.print("> ");
        return sc.nextInt();
    }

    String getPersonString() {
        if (showMsg) {
            sc.nextLine(); // in order to eat "end of line" sign after nextInt method
            System.out.println("Enter all people:");
            showMsg = false;
        }
        System.out.print("> ");
        return sc.nextLine();
    }

    String getSearchQuery() {
        if (eatEol) {
            sc.nextLine();
            eatEol = false;
        }

        System.out.println("\nEnter data to search people:");
        System.out.print("> ");
        return sc.nextLine();
    }

    void printSearchEngineResult(List<String> foundedPersons) {
        if (foundedPersons.isEmpty()) {
            System.out.println("No matching people found.");
        } else {
            System.out.println("\nFound people:");
            for (String person : foundedPersons) {
                System.out.println(person);
            }
        }
    }

}
