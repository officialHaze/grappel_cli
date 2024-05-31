package dev.moinak.utils;

public class FileLine {

    private int linenum;
    private String linetext;

    FileLine(int linenum, String linetext)
    {
        this.linenum = linenum;
        this.linetext = linetext;
    }

    // Getters
    public int getLinenum()
    {
        return linenum;
    }
    public String getLinetext()
    {
        return linetext;
    }
}
