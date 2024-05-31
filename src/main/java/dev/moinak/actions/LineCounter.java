package dev.moinak.actions;

import dev.moinak.utils.FileLine;
import dev.moinak.utils.FileReaderApi;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

public class LineCounter {

    private final boolean isRecursive;
    private String filepath;

    int totalLines = 0;

    public LineCounter(String filepath, boolean isRecursive) {
        this.isRecursive = isRecursive;
        this.filepath = filepath;
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
            // Count the total lines in file
            FileReaderApi fileReader = new FileReaderApi(filepath);
            ArrayList<FileLine> lines = fileReader.getLines();
            totalLines += lines.size();
        }
    }

    // Getters
    public int getTotalLines() {
        return this.totalLines;
    }
}
