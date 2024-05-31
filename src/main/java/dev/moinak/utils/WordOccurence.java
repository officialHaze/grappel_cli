package dev.moinak.utils;

public class WordOccurence {

    private String occurenceText;
    private int occurenceLineNum;

    private String occurenceFile;

    public WordOccurence(String occurenceText, int occurenceLineNum, String occurenceFile) {
        this.occurenceText = occurenceText;
        this.occurenceLineNum = occurenceLineNum;
        this.occurenceFile = occurenceFile;
    }

    public String getOccurenceText() {
        return occurenceText;
    }

    public void setOccurenceText(String occurenceText) {
        this.occurenceText = occurenceText;
    }

    public int getOccurenceLineNum() {
        return occurenceLineNum;
    }

    public String getOccurenceFile() {
        return occurenceFile;
    }

    public void setOccurenceFile(String occurenceFile) {
        this.occurenceFile = occurenceFile;
    }

    public void setOccurenceLineNum(int occurenceLineNum) {
        this.occurenceLineNum = occurenceLineNum;
    }
}
