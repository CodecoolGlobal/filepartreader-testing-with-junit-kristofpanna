package com.codecool.kristofpanna;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


public class FilePartReaderTest {
    private FilePartReader filePartReader;
    private static final String validFilePath = "src/test/resources/file_to_read1.txt";

    @BeforeEach
    void setUp() {
        filePartReader = new FilePartReader();
    }

    @Test
    void constructor__valuesNull() {
        assertNull(filePartReader.filePath, "filePath is not null after FilePartReader() constructor call");
        assertNull(filePartReader.fromLine, "fromLine is not null after FilePartReader() constructor call");
        assertNull(filePartReader.toLine, "toLine is not null after FilePartReader() constructor call");
    }

    @Test
    void setup_toLineIsSmallerThanFromLine_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup(validFilePath, 1, 2);
        });
    }

    @Test
    void setup_fromLineIsSmallerThan1_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup(validFilePath, 0, -1);
        });
    }

    @Test
    void setup_validValues_valuesNotNull() {
        filePartReader.setup(validFilePath, 2, 1);
        assertNotNull(filePartReader.filePath, "filePath is null after calling setup");
        assertNotNull(filePartReader.fromLine, "fromLine is null after calling setup");
        assertNotNull(filePartReader.toLine, "toLine is null after calling setup");
    }

    @Test
    void read_validFilePath_returnsContent() throws IOException {
        filePartReader.setup(validFilePath, 2, 1);
        assertEquals(filePartReader.read(),
                "The monkey 123 is the only monkey here.\n" +
                        "No others.\n" +
                        "Just the one.\n");
    }

    @Test
    void read_invalidFilePath_throwsIOException() {
        filePartReader.setup("src/test/resources/non_existent_file.txt", 2, 1);
        assertThrows(IOException.class, () -> {
            filePartReader.read();
        });
    }
}
