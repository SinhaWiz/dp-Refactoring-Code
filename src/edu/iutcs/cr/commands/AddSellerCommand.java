package edu.iutcs.cr.commands;

import edu.iutcs.cr.ConsoleInputHandler;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.view.ConsoleDisplay;

/**
 * Command: collect seller details from the user and persist to the database.
 */
public class AddSellerCommand implements Command {

    private final SystemDatabase database;
    private final ConsoleInputHandler inputHandler;
    private final ConsoleDisplay display;

    public AddSellerCommand(SystemDatabase database,
                            ConsoleInputHandler inputHandler,
                            ConsoleDisplay display) {
        this.database     = database;
        this.inputHandler = inputHandler;
        this.display      = display;
    }

    @Override
    public void execute() {
        System.out.println("\n\n\nAdd new seller");
        database.getSellers().add(inputHandler.readSeller());
        display.promptToViewMainMenu();
    }
}
