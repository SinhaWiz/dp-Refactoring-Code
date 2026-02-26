package edu.iutcs.cr.commands;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.view.ConsoleDisplay;

/**
 * Command: display the full vehicle inventory.
 */
public class ViewInventoryCommand implements Command {

    private final SystemDatabase database;
    private final ConsoleDisplay display;

    public ViewInventoryCommand(SystemDatabase database, ConsoleDisplay display) {
        this.database = database;
        this.display  = display;
    }

    @Override
    public void execute() {
        System.out.println("\n\n\nInventory list");
        display.showInventory(database.getVehicles());
        display.promptToViewMainMenu();
    }
}
