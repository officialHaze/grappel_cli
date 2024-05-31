package dev.moinak.commands;

import dev.moinak.actions.TextSearcher;
import dev.moinak.utils.FileLine;
import dev.moinak.utils.FileReaderApi;
import picocli.CommandLine;

import java.util.ArrayList;
import java.util.concurrent.Callable;

@CommandLine.Command(
        header = "Search command",
        name = "search",
        description = "Search for a particular string in a file",
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
            names = {"-s", "--string"},
            description = "The text or string to search for",
            required = true
    )
    String string;

    public static void main(String[] args) {

        new CommandLine(new SearchCommand()).execute(
                "--help"
        );
    }

    @Override
    public Integer call() throws Exception {

        FileReaderApi fileReader = new FileReaderApi(filepath);

        ArrayList<FileLine> lines = fileReader.getLines();

        new TextSearcher(lines, string).search();

        return 0;
    }
}
