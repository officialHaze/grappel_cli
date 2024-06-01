package dev.moinak.actions;

import dev.moinak.utils.FileLine;
import dev.moinak.utils.FileReaderApi;
import dev.moinak.utils.TextOccurrence;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class TextFinder {

    private final boolean isRecursive;
    private String filepath;

    private final String searchParam;

    int totalOccurences = 0;
    ArrayList<TextOccurrence> occurences = new ArrayList<>();

    public TextFinder(String filepath, String searchParam, boolean isRecursive) {
        this.isRecursive = isRecursive;
        this.filepath = filepath;
        this.searchParam = searchParam;
    }

    public void find() throws Exception {

        File file = new File(filepath);
        System.out.println("File: " + file);

        // Check if file exists
        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        // Check if the provided path is a directory and the rf option is true
        // to search for files inside dirs with a recursive approach
        if (file.isDirectory() && isRecursive) {
            File[] files = file.listFiles();
            System.out.println("Listed files: " + Arrays.toString(files));

            assert files != null;
            for (File file_ : files) {
                // Recursively call the method to look for files and read them
                filepath = file_.toString(); // Update the filepath with the new path of the current dir
                find();
            }
        }
        // When the provided path is a directory but the rf option is false
        else if (file.isDirectory() && !isRecursive)
            System.out.println("The provided filepath represents a directory not a file." +
                "To start execution in a directory follow the recursive approach by passing the -r or --rf option");

        // This block is where the search param is matched with the contents (texts) in the file.
        else {
            // Count the total occurences of the word / text in file
            FileReaderApi fileReader = new FileReaderApi(filepath);
            ArrayList<FileLine> lines = fileReader.getLines();

            for(FileLine line: lines)
            {
                if (!line.getLinetext().contains(searchParam)) continue;

                TextOccurrence txtOcr = new TextOccurrence(line.getLinetext(), line.getLinenum(), filepath);
                occurences.add(txtOcr);
                totalOccurences++;
            }
        }
    }

    // Getters
    public int getTotalOccurencesNumber() {
        return this.totalOccurences;
    }
    public ArrayList<TextOccurrence> getOccurences() {
        return occurences;
    }
}
