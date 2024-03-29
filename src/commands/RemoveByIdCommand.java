package src.commands;

import src.manager.ObjectsManager;
import src.support.Checks;
import src.collections.Dragon;
import src.tools.OutputText;

/**
 * Removes object by its ID.
 */
public class RemoveByIdCommand implements Command{
    /**
     * Removes object by its ID.
     */
    @Override
    public void execute(String mode, String[] command, String... args) {
        try {
            ObjectsManager objectsManager = new ObjectsManager();
            Dragon dragon = Checks.idChecker(command[1]);
            if (dragon == null) {
                return;
            }
            objectsManager.remove(dragon);
            OutputText.result("Removed");
        } catch (ArrayIndexOutOfBoundsException e) {
            OutputText.error("NoIdArgument");
        }
    }
}
