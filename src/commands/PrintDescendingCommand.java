package src.commands;

import src.support.Sort;
import src.tools.OutputText;

import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Prints objects in descending order by its value of field.
 */
public class PrintDescendingCommand implements Command {
    /**
     * Prints objects in descending order by its value of field.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        if (Objects.equals(mode, "script")) {
            executeWithScript(args[0]);
        } else {printDescending();}
    }

    /**
     * Triggers when user enters this command to terminal
     */
    public static void printDescending() {
        Scanner scanner = new Scanner(System.in);
        Matcher matcher;

        OutputText.input("DescendingInput");
        Pattern pattern = Pattern.compile("\\s*([1-7])\\s*");
        do {
            String field = scanner.nextLine();
            matcher = pattern.matcher(field);

            if(matcher.matches()) {
                field = matcher.group(1);
                Sort.sort(field);
            } else {OutputText.error("FieldIncorrect");}

        } while (!matcher.matches());
    }

    /**
     * Triggers when command is from script file. Object is not created if at least one of the argument is invalid.
     * @param arg number of field
     */
    public static void executeWithScript(String arg) {
        Pattern pattern = Pattern.compile("\\s*([1-7])\\s*");
        Matcher matcher;
        matcher = pattern.matcher(arg);

        if(matcher.matches()) {
            arg = matcher.group(1);
            Sort.sort(arg);
        }
    }
}
