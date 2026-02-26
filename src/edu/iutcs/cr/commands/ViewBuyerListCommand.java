package edu.iutcs.cr.commands;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.view.ConsoleDisplay;

/**
 * Command: display the list of registered buyers.
 */
public class ViewBuyerListCommand implements Command {

    private final SystemDatabase database;
    private final ConsoleDisplay display;

    public ViewBuyerListCommand(SystemDatabase database, ConsoleDisplay display) {
        this.database = database;
        this.display  = display;
    }

    @Override
    public void execute() {
        System.out.println("\n\n\nCustomer's list");
        display.showBuyerList(database.getBuyers());
        display.promptToViewMainMenu();
    }
}
