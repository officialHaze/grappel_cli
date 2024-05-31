package dev.moinak.actions;

import dev.moinak.utils.FileLine;
import dev.moinak.utils.FileReaderApi;
import dev.moinak.utils.WordOccurence;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class WordCounter {

    private boolean isRecursive;
    private String filepath;

    private String searchWord;

    int totalOccurences = 0;
    ArrayList<WordOccurence> occurences = new ArrayList<>();

    public WordCounter(String filepath, String searchWord, boolean isRecursive) {
        this.isRecursive = isRecursive;
        this.filepath = filepath;
        this.searchWord = searchWord;
    }

    public void count() throws Exception {

        File file = new File(filepath);
        System.out.println("File: " + file);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        if (file.isDirectory() && isRecursive) {
            File[] files = file.listFiles();
            System.out.println("Listed files: " + Arrays.toString(files));

            assert files != null;
            for (File file_ : files) {
                // Recursively call the method to look for files and read them
                filepath = file_.toString();
                count();
            }
        }
        else if (file.isDirectory() && !isRecursive) System.out.println("The provided filepath represents a directory not a file. To start execution in a directory follow the recursive approach by passing the -rf option");
        else {
            // Count the total occurences of the word in file
            FileReaderApi fileReader = new FileReaderApi(filepath);
            ArrayList<FileLine> lines = fileReader.getLines();

            for(FileLine line: lines)
            {
                //System.out.println("Search word: " + searchWord);
                //System.out.println("Line: " + line.getLinetext());
                if (!line.getLinetext().toLowerCase().contains(searchWord.toLowerCase())) continue;

                WordOccurence wo = new WordOccurence(line.getLinetext(), line.getLinenum(), filepath);
                occurences.add(wo);
                totalOccurences++;
            }
        }
    }

    // Getters
    public int getTotalOccurences() {
        return this.totalOccurences;
    }
    public ArrayList<WordOccurence> getWordOccurences() {
        return occurences;
    }
}
