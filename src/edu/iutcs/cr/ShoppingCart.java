package edu.iutcs.cr;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.system.SystemRepository;
import edu.iutcs.cr.vehicles.Vehicle;
import java.io.Serializable;
import java.util.HashSet;
import static java.util.Objects.isNull;
import java.util.Set;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class ShoppingCart implements Serializable {

    private final Set<Vehicle> vehicles;
    private final SystemRepository repository;

    public ShoppingCart() {
        this.vehicles = new HashSet<>();
        repository = new SystemRepository(SystemDatabase.getInstance());
    }

    public Set<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void addItem(String registrationNumber) {
        Vehicle vehicle = repository.findVehicleByRegistrationNumber(registrationNumber);

        if (isNull(vehicle) || !vehicle.isAvailable()) {
            System.out.println("Vehicle not available");
            return;
        }

        vehicles.add(vehicle);
    }

    public void removeItem(String registrationNumber) {
        vehicles.remove(new Vehicle(registrationNumber));
    }

    public void viewCart() {
        System.out.println("\n\nShopping cart\n\n");

        if (vehicles.isEmpty()) {
            System.out.println("Cart is empty");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }
}
