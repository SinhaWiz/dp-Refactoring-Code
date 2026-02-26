package edu.iutcs.cr.system;

import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.vehicles.Vehicle;

/**
 * Query layer for the in-memory data store.
 *
 * <p>Extracted from {@link SystemDatabase} to satisfy SRP:
 * {@code SystemDatabase} is now responsible only for singleton lifecycle,
 * data access (getters), and persistence, while this class handles
 * all search / lookup logic.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SystemRepository {

    private final SystemDatabase database;

    public SystemRepository(SystemDatabase database) {
        this.database = database;
    }

    /**
     * Returns the {@link Vehicle} whose registration number matches, or
     * {@code null} if no such vehicle is found.
     */
    public Vehicle findVehicleByRegistrationNumber(String registrationNumber) {
        Vehicle key = new Vehicle(registrationNumber);
        for (Vehicle vehicle : database.getVehicles()) {
            if (vehicle.equals(key)) {
                return vehicle;
            }
        }
        return null;
    }

    /**
     * Returns the {@link Buyer} whose id matches, or {@code null} if not found.
     */
    public Buyer findBuyerById(String id) {
        Buyer key = new Buyer(id);
        for (Buyer buyer : database.getBuyers()) {
            if (buyer.equals(key)) {
                return buyer;
            }
        }
        return null;
    }

    /**
     * Returns the {@link Seller} whose id matches, or {@code null} if not found.
     */
    public Seller findSellerById(String id) {
        Seller key = new Seller(id);
        for (Seller seller : database.getSellers()) {
            if (seller.equals(key)) {
                return seller;
            }
        }
        return null;
    }
}
