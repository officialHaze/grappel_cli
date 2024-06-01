package dev.moinak.commands.subs;

import dev.moinak.actions.LineCounter;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        header = "Count total lines of text in a single file or recursively through the entire project",
        name = "line",
        description = "Sub command to count total lines of text",
        separator = " ",
        mixinStandardHelpOptions = true,
        optionListHeading = "%n Options: %n",
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
        System.out.println("Total line(s) of text in this project: " + lnCount.getTotalLines());

        return 0;
    }
}
