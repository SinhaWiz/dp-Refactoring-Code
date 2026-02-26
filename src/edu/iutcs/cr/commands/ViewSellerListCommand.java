package edu.iutcs.cr.commands;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.view.ConsoleDisplay;

/**
 * Command: display the list of registered sellers.
 */
public class ViewSellerListCommand implements Command {

    private final SystemDatabase database;
    private final ConsoleDisplay display;

    public ViewSellerListCommand(SystemDatabase database, ConsoleDisplay display) {
        this.database = database;
        this.display  = display;
    }

    @Override
    public void execute() {
        System.out.println("\n\n\nSeller's list");
        display.showSellerList(database.getSellers());
        display.promptToViewMainMenu();
    }
}
