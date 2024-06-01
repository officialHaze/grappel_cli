package dev.moinak;

import dev.moinak.commands.CountCommand;
import dev.moinak.commands.SearchCommand;
import picocli.CommandLine;

import java.util.concurrent.Callable;

@CommandLine.Command(
        version = "0.0.1",
        name = "grappel",
        mixinStandardHelpOptions = true,
        commandListHeading = "%n The commands are: %n",
        separator = " ",
        subcommands = {
                CountCommand.class,
                SearchCommand.class
        }
)
public class App implements Callable<Integer>
{
    public static void main( String[] args )
    {
        try {
            new CommandLine(new App()).execute(args);

            System.exit(0);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    public Integer call() throws Exception {

        System.out.println("!!! Welcome to Grappel CLI tool !!!");

        return 0;
    }
}
