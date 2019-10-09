package com.codecool.kristofpanna;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    public List<String> getWordsOrderedAlphabetically() {
        /*
        calls FilePartReader.readLines ()
        returns the words ordered alphabetically as an ArrayList
         */
        // TODO
        List<String> wordsOrderedAlphabetically = new ArrayList<>();
        return wordsOrderedAlphabetically;
    }

    public List<String> getWordsContainingSubstring(String subString) {
        /*
        calls FilePartReader.readLines ()
        returns the words which contains the subString
         */
        // TODO
        return null;
    }

    public List<String> getStringsWhichPalindromes() {
        /*
        calls FilePartReader.readLines ()
        returns the words from the String which are palindrome
         */
        // TODO
        return null;
    }

    Stream<String> getWords() {
        String text = filePartReader.readLines();
        String[] splitByWhitespace = text.split("\\s+");
        return Arrays.stream(splitByWhitespace)
                .map(s -> s.replaceAll("[^\\p{L}]", ""));
    }


}
