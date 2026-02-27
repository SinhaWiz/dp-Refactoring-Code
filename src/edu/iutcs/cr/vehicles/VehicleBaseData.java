package edu.iutcs.cr.vehicles;

/**
 * Immutable value object carrying the five fields shared by every
 * {@link Vehicle} subclass.
 *
 * <p>Replaces the positional {@code String[]} (indexed 0–4) that was
 * previously returned by
 * {@code ConsoleInputHandler.readVehicleBaseFields()}, eliminating
 * both the index magic numbers and the need to re-parse {@code price}
 * from a {@code String}.
 */
public record VehicleBaseData(
        String registrationNumber,
        String make,
        String model,
        String year,
        double price
) {}
