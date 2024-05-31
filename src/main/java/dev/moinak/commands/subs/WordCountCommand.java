package dev.moinak.commands.subs;

import dev.moinak.actions.LineCounter;
import dev.moinak.actions.WordCounter;
import dev.moinak.utils.WordOccurence;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@CommandLine.Command(
        header = "Count total occurences of a word in a text file",
        name = "wordcount",
        description = "This is a sub command of the main Count command to count the total occurences of a given word in a text file",
        separator = " ",
        mixinStandardHelpOptions = true,
        optionListHeading = "%n Options are: %n",
        requiredOptionMarker = '*'

)
public class WordCountCommand implements Callable<Integer> {

    @CommandLine.Option(
            names = {"-f", "--file"},
            description = "The absolute path of the file to read",
            required = true
    )
    String filepath;

    @CommandLine.Option(
            names = {"-w", "--word"},
            description = "The search word",
            required = true
    )
    String word;

    @CommandLine.Option(
            names = {"-r", "--rf"},
            description = "Recursively read files in every directory and count the occurences of the given word"
    )
    boolean rf;

    @Override
    public Integer call() throws Exception {

        WordCounter wordCount = new WordCounter(filepath, word, rf);
        wordCount.count();
        System.out.println();
        System.out.println("The given word appeared in: ");
        ArrayList<WordOccurence> occurences = wordCount.getWordOccurences();
        for (WordOccurence occurence: occurences) {
            System.out.println("Filename: " + occurence.getOccurenceFile());
            System.out.println("Text: " + occurence.getOccurenceText());
            System.out.println("Line number: " + occurence.getOccurenceLineNum());
            System.out.println();
        }

        System.out.println("Total occurences of the given word: " + wordCount.getTotalOccurences());

        return 0;
    }
}
