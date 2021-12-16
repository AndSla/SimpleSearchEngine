package com.nauka;

public class SearchEngine {

    int find(String[] firstLineWords, String secondLineWord) {
        for (int i = 0; i < firstLineWords.length; i++) {
            if (firstLineWords[i].equals(secondLineWord)) {
                return i + 1;
            }
        }
        return -1;
    }

}
