package com.codecool.kristofpanna;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FilePartReaderTest {
    @Test
    void setup_toLineIsSmallerThanFromLine_ThrowsIllegalArgumentException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup("/file/path", 1, 2);
        });
    }
}
