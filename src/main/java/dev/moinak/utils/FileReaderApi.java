package dev.moinak.utils;

import java.io.File;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReaderApi {

    private String filepath;

    public FileReaderApi(String filepath)
    {
        this.filepath = filepath;
    }

    public ArrayList<FileLine> getLines() throws Exception {

        ArrayList<FileLine> lines = new ArrayList<>();

        String absPath = FileSystems.getDefault().getPath(filepath).toAbsolutePath().toString();

        File file = new File(absPath);
        System.out.println("File absolute path: " + absPath);

        // Read the file using scanner class
        Scanner scanner = new Scanner(file);
        int linenum = 0;
        while(scanner.hasNextLine()) {
            linenum++;
            String lineText = scanner.nextLine();
            FileLine line = new FileLine(linenum, lineText);
            lines.add(line);

        }
        scanner.close();

        return lines;
    }
}
