package com.nauka;

public class Main {

    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        SearchEngine se = new SearchEngine();

        String[] firstLineWords = ui.getFirstLineWords();
        String secondLineWord = ui.getSecondLineWord();

        int result = se.find(firstLineWords, secondLineWord);

        ui.printSearchEngineResult(result);

    }

}
