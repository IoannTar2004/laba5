package src.commands;

import src.tools.OutputText;
import src.collectionClasses.CollectionManager;
import src.collectionClasses.Dragon;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Count amount of objects which have greater age than entered.
 */
public class CountGreaterCommand implements Command {
    /**
     * Method checks if the age entered correctly then runs {@link CountGreaterCommand#execute(String...)}. If this is not the case print mistake messages.
     * @param command command with argument as dragon's age
     */
    public static void preexecute(String command) {
        String age;
        Pattern pattern = Pattern.compile("\\s*count_greater_than_age\\s+([1-9][0-9]*)\\s*");
        Matcher matcher = pattern.matcher(command);

        Pattern pattern1 = Pattern.compile("\\s*count_greater_than_age\\s+(-\\d+|0)\\s*");
        Matcher matcher1 = pattern1.matcher(command);

        Pattern pattern2 = Pattern.compile("\\s*count_greater_than_age\\s+-?\\d+\\.\\d+\\s*");
        Matcher matcher2 = pattern2.matcher(command);

        Pattern pattern_noargument = Pattern.compile("\\s*count_greater_than_age\\s*");
        Matcher matcher_noargument = pattern_noargument.matcher(command);

        if (matcher.matches()) {
            age = matcher.group(1);
            execute(age);
        } else if (matcher1.matches()) {
            System.out.println("Возраст - положительное число!");
        } else if (matcher2.matches()) {
            System.out.println("Возраст - целое положительное число!");
        } else if (matcher_noargument.matches()) {
            OutputText.error("NoAgeArgument");
        }
        else {
            System.out.println("Возраст должен быть положительным целым числом в 10 сс!");
        }
    }

    /**
     * Count amount of objects which have greater age than entered.
     */
    @Override
    public void execute(String... age) {
        int count = 0;
        for (int i = 0; i < CollectionManager.length(); i++) {
            Dragon dragon = CollectionManager.getDragonByIndex(i);
            if (CollectionManager.getAge(dragon) > Integer.parseInt(age[0])) {
                count++;
            }
        }
        System.out.println(count);
    }
}