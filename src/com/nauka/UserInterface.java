package com.nauka;

import java.util.Scanner;

public class UserInterface {

    private final Scanner sc = new Scanner(System.in);

    String[] getFirstLineWords() {
        System.out.print("> ");
        String firstLine = sc.nextLine();
        return firstLine.split("\\s");
    }

    String getSecondLineWord() {
        System.out.print("> ");
        return sc.nextLine();
    }

    void printSearchEngineResult(int result) {
        if (result != -1) {
            System.out.println(result);
        } else {
            System.out.println("Not found");
        }
    }

}
