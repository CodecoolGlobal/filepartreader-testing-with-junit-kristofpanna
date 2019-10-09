package com.codecool.kristofpanna;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
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

}
