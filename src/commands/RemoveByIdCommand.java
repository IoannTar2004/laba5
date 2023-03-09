package src.commands;

import src.collectionClasses.CollectionManager;
import src.support.Checks;
import src.collectionClasses.Dragon;
import src.tools.OutputText;

/**
 * Removes object by its ID.
 */
public class RemoveByIdCommand implements Command{
    /**
     * Removes object by its ID.
     * @param command command with ID
     */
    @Override
    public void execute(String... command) {
        try {
            Dragon dragon = Checks.idChecker(command[0]);
            if (dragon == null) {
                return;
            }
            CollectionManager.remove(dragon);
            OutputText.result("Removed");
        } catch (ArrayIndexOutOfBoundsException e) {
            OutputText.error("NoIdArgument");
        }
    }
}
