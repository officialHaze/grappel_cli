package dev.moinak.commands;

import dev.moinak.actions.TextFinder;
import dev.moinak.utils.TextOccurrence;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@CommandLine.Command(
        header = "Search for a text or word in a text file or recursively through the entire project",
        name = "search",
        description = "Find all the occurences of a given word / text in a text file",
        separator = " ",
        mixinStandardHelpOptions = true,
        optionListHeading = "%n Options are: %n",
        requiredOptionMarker = '*'
)
public class SearchCommand implements Callable<Integer> {

    @CommandLine.Option(
            names = {"-f", "--file"},
            description = "Filepath to read",
            required = true
    )
    String filepath;

    @CommandLine.Option(
            names = {"-t", "--text"},
            description = "The text or string to search for",
            required = true
    )
    String text;

    @CommandLine.Option(
            names = {"-r", "--rf"},
            description = "Recursively read files in every directory and count the occurences of the given word / text"
    )
    boolean rf;

    @Override
    public Integer call() throws Exception {

        TextFinder textFinder = new TextFinder(filepath, text, rf);
        textFinder.find();
        System.out.println();
        System.out.println("The given text appeared in: ");
        ArrayList<TextOccurrence> occurences = textFinder.getOccurences();
        for (TextOccurrence occurrence: occurences) {
            System.out.println("Filename: " + occurrence.getOccurrenceFilename());
            System.out.println("Text: " + occurrence.getOccurrenceText());
            System.out.println("Line number: " + occurrence.getOccurrenceLineNum());
            System.out.println();
        }

        System.out.println("Total occurences of the given text: " + textFinder.getTotalOccurencesNumber());

        return 0;
    }
}
