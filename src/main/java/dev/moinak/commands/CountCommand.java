package dev.moinak.commands;

import dev.moinak.commands.subs.LineCountCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        header = "Count command",
        name = "count",
        description = "Count contents of a file",
        separator = " ",
        mixinStandardHelpOptions = true,
        optionListHeading = "%n Options are: %n",
        requiredOptionMarker = '*',
        commandListHeading = "%n Sub commands are: %n",
        subcommands = {
                LineCountCommand.class
        }
)
public class CountCommand implements Callable<Integer> {



    public static void main(String[] args) {

        try {
            new CommandLine(new CountCommand()).execute(
                    "linecount",
                    "-f C:\\PARTITION-DEV\\Inventory_Management_System\\ims_server\\src"
            );
            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    @Override
    public Integer call() throws Exception {

        System.out.println("[count] This tool will help you to count contents of a file.");

        return 0;
    }
}
