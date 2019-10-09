package com.codecool.kristofpanna;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class FileWordAnalyzerTest {
    private FilePartReader filePartReader = new FilePartReader();

    @Test
    void constructor_ok() {
        filePartReader.setup("src/test/resources/file_to_read1.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
    }

    @Test
    void getWords_containsDuplicates_returnContainsMultipleTimes() {
        filePartReader.setup("src/test/resources/multiple.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Arrays.asList("bbb", "d", "d", "aaaa", "d", "cc", "bbb"),
                fileWordAnalyzer.getWords().collect(Collectors.toList())
        );
    }

    @Test
    void getWords_containsSpecialChars_returnWithoutSpecialChars() {
        filePartReader.setup("src/test/resources/spec_chars.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Arrays.asList("igen", "ez","ilyen", "csak", "megjobb", "szer", "jobb", "nem", "egyszer"),
                fileWordAnalyzer.getWords().collect(Collectors.toList())
        );
    }

    @Test
    void getWords_containsAccent_handleAccentedLettersAsLetter() {
        filePartReader.setup("src/test/resources/accent.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Arrays.asList("árvíztűrő", "tükörfúrógép"),
                fileWordAnalyzer.getWords().collect(Collectors.toList())
        );
    }

    @Test
    void getWords_emptyFile_emptyList() {
        filePartReader.setup("src/test/resources/empty.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Collections.emptyList(),
                fileWordAnalyzer.getWords().collect(Collectors.toList())
        );
    }

    @Test
    void getWordsOrderedAlphabetically_multiple_multipleOrdered() {
        filePartReader.setup("src/test/resources/multiple.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Arrays.asList("aaaa", "bbb", "bbb", "cc", "d", "d", "d"),
                fileWordAnalyzer.getWordsOrderedAlphabetically()
        );
    }

    @Test
    void getWordsOrderedAlphabetically_upperLowerCaseWithAccent_UpperFirstAccentLast() {
        filePartReader.setup("src/test/resources/upper_lower.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Arrays.asList("A", "B", "a", "a", "b", "Á", "á"),
                fileWordAnalyzer.getWordsOrderedAlphabetically()
        );
    }

    @Test
    void getWordsOrderedAlphabetically_emptyFile_emptyList() {
        filePartReader.setup("src/test/resources/empty.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Collections.emptyList(),
                fileWordAnalyzer.getWordsOrderedAlphabetically()
        );
    }

    @Test
    void getWordsContainingSubstring_multiple_multiple() {
        filePartReader.setup("src/test/resources/file_to_read1.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Arrays.asList("monkey","only", "monkey", "one"),
                fileWordAnalyzer.getWordsContainingSubstring("on")
        );
    }

    @Test
    void getWordsContainingSubstring_noMatching_emptyList() {
        filePartReader.setup("src/test/resources/upper_lower.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Collections.emptyList(),
                fileWordAnalyzer.getWordsContainingSubstring("on")
        );
    }

    @Test
    void getWordsContainingSubstring_emptyFile_emptyList() {
        filePartReader.setup("src/test/resources/empty.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);
        assertEquals(
                Collections.emptyList(),
                fileWordAnalyzer.getWordsContainingSubstring("on")
        );
    }
}
