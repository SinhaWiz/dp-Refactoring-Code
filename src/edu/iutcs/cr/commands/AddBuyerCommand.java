package edu.iutcs.cr.commands;

import edu.iutcs.cr.ConsoleInputHandler;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.view.ConsoleDisplay;

/**
 * Command: collect buyer details from the user and persist to the database.
 */
public class AddBuyerCommand implements Command {

    private final SystemDatabase database;
    private final ConsoleInputHandler inputHandler;
    private final ConsoleDisplay display;

    public AddBuyerCommand(SystemDatabase database,
                           ConsoleInputHandler inputHandler,
                           ConsoleDisplay display) {
        this.database     = database;
        this.inputHandler = inputHandler;
        this.display      = display;
    }

    @Override
    public void execute() {
        System.out.println("\n\n\nAdd new customer");
        database.getBuyers().add(inputHandler.readBuyer());
        display.promptToViewMainMenu();
    }
}
