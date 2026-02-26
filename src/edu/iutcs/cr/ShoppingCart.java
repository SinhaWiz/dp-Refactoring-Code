package edu.iutcs.cr;

import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.vehicles.Vehicle;
import edu.iutcs.cr.io.IOHandler;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static java.util.Objects.isNull;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class ShoppingCart implements Serializable {

    private final Set<Vehicle> vehicles;
    private final SystemDatabase database;
    private final IOHandler ioHandler;

    public ShoppingCart(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public ShoppingCart() {
        this.vehicles = new HashSet<>();
        database = SystemDatabase.getInstance();
    }

    public Set<Vehicle> getVehicles() {
        return this.vehicles;
    }

    public void addItem() {
        ioHandler.print("Enter registration number of vehicle: ");
        String registrationNumber = ioHandler.readLine();

        Vehicle vehicle = database.findVehicleByRegistrationNumber(registrationNumber);

        if (isNull(vehicle) || !vehicle.isAvailable()) {
            ioHandler.println("Vehicle not available");
            return;
        }

        vehicles.add(vehicle);
    }

    public void removeItem() {
        ioHandler.print("Enter the registration number of the vehicle: ");
        String registrationNumber = ioHandler.readLine();
        vehicles.remove(new Vehicle(registrationNumber));
    }

    public void viewCart() {
        ioHandler.println("\n\nShopping cart\n\n");

        if(vehicles.isEmpty()) {
            ioHandler.println("Cart is empty");
            return;
        }

        for (Vehicle vehicle : vehicles) {
            ioHandler.println(vehicle.toString());
        }
    }
}
