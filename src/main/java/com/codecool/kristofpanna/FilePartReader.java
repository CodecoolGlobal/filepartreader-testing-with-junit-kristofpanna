package com.codecool.kristofpanna;

public class FilePartReader {
    String filePath;
    Integer fromLine;
    Integer toLine;

    public FilePartReader() {
        /*
        sets the class' instance variables to some invalid default value
         */
    }

    public void setup(String filePath, Integer fromLine, Integer toLine) throws IllegalArgumentException {
        /*
        it throws an IllegalArgumentException :
            if toLine is smaller than fromLine
            if fromLine is smaller than 1
         */
        if (toLine > fromLine) {
            throw new IllegalArgumentException("toLine is smaller than fromLine.");
        }
        // TODO
    }

    public String read() {
        /*
        opens the file on filePath , and gives back it's content as a String
         */
        // TODO
        return null;
    }

    public String readLines() {
        /*
        - reads the file with read ()
        - it gives back every line from it's content between fromLine and toLine (both of them are included), and returns these lines as a String.
            Take care because if fromLine is 1, it means the very first row in the file. Also, if fromLine is 1 and toLine is 1 also, we will read only the very first line.
         */
        // TODO
        return null;
    }

}
