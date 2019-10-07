package com.codecool.kristofpanna;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class FilePartReaderTest {
    private FilePartReader filePartReader;

    @BeforeEach
    void setUp() {
        filePartReader = new FilePartReader();
    }

    @Test
    void setup_toLineIsSmallerThanFromLine_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup("/file/path", 1, 2);
        });
    }

    @Test
    void setup_fromLineIsSmallerThan1_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup("/file/path", 0, -1);
        });
    }

    @Test
    void setup_validValues_valuesNotNull() {
        filePartReader.setup("file_to_read.txt", 2, 1);
        assertNotNull(filePartReader.filePath, "filePath is null after calling setup");
        assertNotNull(filePartReader.fromLine, "fromLine is null after calling setup");
        assertNotNull(filePartReader.toLine, "toLine is null after calling setup");
    }
}
