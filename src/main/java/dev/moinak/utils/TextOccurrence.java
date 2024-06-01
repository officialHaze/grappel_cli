package dev.moinak.utils;

public class TextOccurrence {

    private final String occurrenceText;
    private final int occurrenceLineNum;

    private final String occurrenceFilename;

    public TextOccurrence(String occurrenceText, int occurrenceLineNum, String occurrenceFilename) {
        this.occurrenceText = occurrenceText;
        this.occurrenceLineNum = occurrenceLineNum;
        this.occurrenceFilename = occurrenceFilename;
    }

    public String getOccurrenceText() {
        return occurrenceText;
    }

    public int getOccurrenceLineNum() {
        return occurrenceLineNum;
    }

    public String getOccurrenceFilename() {
        return occurrenceFilename;
    }
}
