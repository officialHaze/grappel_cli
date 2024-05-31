package dev.moinak.commands.subs;

import dev.moinak.actions.LineCounter;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        header = "Count total lines in a file",
        name = "linecount",
        description = "This is a sub command of the main Count command to count the total lines in a file",
        separator = " ",
        mixinStandardHelpOptions = true,
        optionListHeading = "%n Options are: %n",
        requiredOptionMarker = '*'

)
public class LineCountCommand implements Callable<Integer> {

    @CommandLine.Option(
            names = {"-f", "--f"},
            description = "The absolute path of the file to read",
            required = true
    )
    String filepath;

    @CommandLine.Option(
            names = {"-r", "--rf"},
            description = "Recursively read files in every directory and count the total lines"
    )
    boolean rf;

    @Override
    public Integer call() throws Exception {

        LineCounter lnCount = new LineCounter(filepath, rf);
        lnCount.count();
        System.out.println();
        System.out.println("Total lines: " + lnCount.getTotalLines());

        return 0;
    }
}
