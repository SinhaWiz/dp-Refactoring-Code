package edu.iutcs.cr.vehicles;

import java.io.Serializable;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Car extends Vehicle implements Serializable {

    int seatingCapacity;

    public Car(String registrationNumber, String make, String model, String year, double price, int seatingCapacity) {
        super(registrationNumber, make, model, year, price);
        this.seatingCapacity = seatingCapacity;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(int seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() + ", " +
                "seatingCapacity=" + getSeatingCapacity() +
                "}";
    }
}
