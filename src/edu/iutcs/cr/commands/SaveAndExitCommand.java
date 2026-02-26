package edu.iutcs.cr.commands;

import edu.iutcs.cr.system.SystemDatabase;

/**
 * Command: persist all data and terminate the application.
 */
public class SaveAndExitCommand implements Command {

    private final SystemDatabase database;

    public SaveAndExitCommand(SystemDatabase database) {
        this.database = database;
    }

    @Override
    public void execute() {
        database.saveSystem();
        System.exit(0);
    }
}
