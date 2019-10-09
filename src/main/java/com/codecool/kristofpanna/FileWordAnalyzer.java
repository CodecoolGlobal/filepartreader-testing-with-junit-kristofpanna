package com.codecool.kristofpanna;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWordAnalyzer {
    private FilePartReader filePartReader;

    public FileWordAnalyzer(FilePartReader filePartReader) {
        this.filePartReader = filePartReader;
    }

    /**
     * Returns the words ordered alphabetically as a List.
     */
    public List<String> getWordsOrderedAlphabetically() throws IOException {
        return getWords()
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Returns the words which contain subString.
     */
    public List<String> getWordsContainingSubstring(String subString) throws IOException {
        return getWords()
                .filter(s -> s.contains(subString))
                .collect(Collectors.toList());
    }

    /**
     * Returns the words which are palindrome.
     */
    public List<String> getStringsWhichPalindromes() throws IOException {
        Predicate<String> palindrome = s -> s.equals(reverse(s));
        return getWords()
                .filter(palindrome)
                .collect(Collectors.toList());
    }

    private String reverse(String string) {
        StringBuilder reversed = new StringBuilder(string).reverse();
        return reversed.toString();
    }

    /**
     * Calls FilePartReader.readLines(), returns Stream of words.
     */
    Stream<String> getWords() throws IOException {
        String text = filePartReader.readLines();
        String[] splitByWhitespace = text.split("\\s+");
        return Arrays.stream(splitByWhitespace)
                .map(s -> s.replaceAll("[^\\p{L}]", ""))
                .filter(s -> !s.equals(""));
    }


}
