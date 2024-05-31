package dev.moinak.actions;

import dev.moinak.utils.FileLine;

import java.util.ArrayList;

public class TextSearcher {

    private ArrayList<FileLine> lines;
    private String textToSearch;

    public TextSearcher(ArrayList<FileLine> lines, String textToSearch) {

        this.lines = lines;
        this.textToSearch = textToSearch;
    }

    public void search()
    {

        boolean isTextFound = false;
        ArrayList<Integer> foundAtLinenums = new ArrayList<>();
        ArrayList<String> foundTexts = new ArrayList<>();

        for (FileLine line: lines)
        {
            String lineText = line.getLinetext();
            int lineNum = line.getLinenum();

            if (!lineText.contains(textToSearch)) continue;

            isTextFound = true;
            foundAtLinenums.add(lineNum);
            foundTexts.add(lineText);
        }

        if (!isTextFound) {
            System.out.println("No matching text found!");
            return;
        }

        System.out.println("Matching text found at line numbers: " + foundAtLinenums.toString());
        System.out.println("Matching texts found in: " + foundTexts.toString());
    }
}
