package com.codecool.kristofpanna;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    /**
     * Returns the words ordered alphabetically as a List
     */
    public List<String> getWordsOrderedAlphabetically() {
        return getWords()
                .sorted()
                .collect(Collectors.toList());
    }
    /**
     * Returns the words which contain subString
     */
    public List<String> getWordsContainingSubstring(String subString) {

        // TODO
        return null;
    }

    /**
     * Returns the words which are palindrome
     */
    public List<String> getStringsWhichPalindromes() {

        // TODO
        return null;
    }

    /**
     * Calls FilePartReader.readLines(), returns Stream of words
     */
    Stream<String> getWords() {
        String text = filePartReader.readLines();
        String[] splitByWhitespace = text.split("\\s+");
        return Arrays.stream(splitByWhitespace)
                .map(s -> s.replaceAll("[^\\p{L}]", ""));
    }


}
