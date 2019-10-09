package com.codecool.kristofpanna;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader() {
        /*
        sets the instance variables to some invalid default value (-> default null)
         */
    }

    /**
     * Set up the reader parameters.
     * @param filePath file to read
     * @param fromLine index of first line to read (from 1)
     * @param toLine index of last line to read (from 1)
     * @throws IllegalArgumentException if toLine < fromLine, or fromLine < 1
     */
    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        if (toLine < fromLine) {
            throw new IllegalArgumentException("toLine is smaller than fromLine.");
        }
        if (fromLine < 1) {
            throw new IllegalArgumentException("fromLine is smaller than 1.");
        }

        this.filePath = filePath;
        this.fromLine = fromLine;
        this.toLine = toLine;
    }

    /**
     * Opens the file on filePath, returns its content as a String.
     * @throws IOException if there was a problem reading the file
     */
    public String read() throws IOException {
        return new String(Files.readAllBytes(Paths.get(filePath)));
    }

    /**
     * Returns every line from between fromLine and toLine (both of them are included) as a String.
     *
     * If fromLine is 1, it means the very first row in the file.
     * Also, if fromLine is 1 and toLine is 1 also, we will read only the very first line.
     */
    public String readLines() {
        /*
         */
        String whole;
        try {
            whole = read();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        String[] wholeLines = whole.split("(?<=\n)");  // linebreak char stays at the end of lines

        int wholeLength = wholeLines.length;
        if (wholeLength < fromLine) {
            return "";
        }
        int endLine = Math.min(toLine, wholeLength);
        final int length = endLine - fromLine + 1;

        String[] partLines = new String[length];
        System.arraycopy(wholeLines, fromLine - 1, partLines, 0, length);

        return String.join("", partLines);
    }

}
