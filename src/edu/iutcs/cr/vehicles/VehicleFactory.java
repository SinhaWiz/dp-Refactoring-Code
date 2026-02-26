package edu.iutcs.cr.vehicles;

import java.util.Map;
import java.util.function.Supplier;

/**
 * Factory Pattern for vehicle creation.
 * Maps a numeric type choice to a concrete Vehicle constructor,
 * replacing the if-else chain in SystemFlowRunner.addCar().
 * Supports OCP: registering a new vehicle type requires no changes
 * to the calling code, only a new entry in VEHICLE_SUPPLIERS.
 */
public class VehicleFactory {

    private static final Map<Integer, Supplier<Vehicle>> VEHICLE_SUPPLIERS = Map.of(
            1, Bus::new,
            2, Car::new,
            3, Hatchback::new,
            4, Sedan::new,
            5, SUV::new
    );

    private static final Map<Integer, String> VEHICLE_NAMES = Map.of(
            1, "Bus",
            2, "Car",
            3, "Hatchback",
            4, "Sedan",
            5, "SUV"
    );

    /** Returns the total number of supported vehicle types. */
    public static int getTypeCount() {
        return VEHICLE_SUPPLIERS.size();
    }

    /**
     * Creates and returns a new Vehicle of the given type.
     * @throws IllegalArgumentException if the type is not registered.
     */
    public static Vehicle create(int type) {
        Supplier<Vehicle> supplier = VEHICLE_SUPPLIERS.get(type);
        if (supplier == null) {
            throw new IllegalArgumentException("Unknown vehicle type: " + type);
        }
        return supplier.get();
    }

    /** Returns the display name of the given vehicle type. */
    public static String getTypeName(int type) {
        return VEHICLE_NAMES.getOrDefault(type, "Unknown");
    }
}
