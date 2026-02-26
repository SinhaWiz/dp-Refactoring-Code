package edu.iutcs.cr.commands;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.view.ConsoleDisplay;

/**
 * Command: display all stored invoices.
 */
public class ViewInvoicesCommand implements Command {

    private final SystemDatabase database;
    private final ConsoleDisplay display;

    public ViewInvoicesCommand(SystemDatabase database, ConsoleDisplay display) {
        this.database = database;
        this.display  = display;
    }

    @Override
    public void execute() {
        System.out.println("\n\n\nInvoice list");
        display.showInvoices(database.getInvoices());
        display.promptToViewMainMenu();
    }
}
