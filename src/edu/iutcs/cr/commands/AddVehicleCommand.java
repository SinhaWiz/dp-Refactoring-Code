package edu.iutcs.cr.commands;

import edu.iutcs.cr.ConsoleInputHandler;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.vehicles.Vehicle;
import edu.iutcs.cr.vehicles.VehicleType;
import edu.iutcs.cr.view.ConsoleDisplay;

/**
 * Command: display vehicle-type sub-menu, collect vehicle details, and persist
 * the new vehicle to the database.
 */
public class AddVehicleCommand implements Command {

    private final SystemDatabase database;
    private final ConsoleInputHandler inputHandler;
    private final ConsoleDisplay display;

    public AddVehicleCommand(SystemDatabase database,
                             ConsoleInputHandler inputHandler,
                             ConsoleDisplay display) {
        this.database     = database;
        this.inputHandler = inputHandler;
        this.display      = display;
    }

    @Override
    public void execute() {
        System.out.println("\n\n\nAdd new vehicle");
        display.showVehicleTypeMenu();
        VehicleType vehicleType = inputHandler.readVehicleType();

        Vehicle newItem = switch (vehicleType) {
            case BUS      -> { System.out.println("\n\nCreate new bus");       yield inputHandler.readBus(); }
            case CAR      -> { System.out.println("\n\nCreate new car");       yield inputHandler.readCar(); }
            case HATCHBACK -> { System.out.println("\n\nCreate new hatchback"); yield inputHandler.readHatchback(); }
            case SEDAN    -> { System.out.println("\n\nCreate new sedan");     yield inputHandler.readSedan(); }
            case SUV      -> { System.out.println("\n\nCreate new SUV");       yield inputHandler.readSUV(); }
        };

        database.getVehicles().add(newItem);
        display.promptToViewMainMenu();
    }
}
