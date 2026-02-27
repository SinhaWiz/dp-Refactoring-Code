package edu.iutcs.cr.vehicles;

/**
 * Represents the selectable vehicle types in the add-vehicle sub-menu.
 *
 * <p>Replaces the bare integer codes (1–5) previously used in
 * {@link edu.iutcs.cr.ConsoleInputHandler#readVehicleType()} and
 * {@link edu.iutcs.cr.commands.AddVehicleCommand}.
 */
public enum VehicleType {

    BUS(1),
    CAR(2),
    HATCHBACK(3),
    SEDAN(4),
    SUV(5);

    private final int code;

    VehicleType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    /** Returns the lowest valid vehicle-type code (currently {@code 1}). */
    public static int minCode() {
        return BUS.code;
    }

    /** Returns the highest valid vehicle-type code (currently {@code 5}). */
    public static int maxCode() {
        return SUV.code;
    }

    /**
     * Maps a raw integer to its {@code VehicleType}.
     *
     * @throws IllegalArgumentException if {@code code} is out of range
     */
    public static VehicleType fromCode(int code) {
        for (VehicleType type : values()) {
            if (type.code == code) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid vehicle type: " + code);
    }
}
