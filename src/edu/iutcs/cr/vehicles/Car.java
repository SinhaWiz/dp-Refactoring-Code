package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.io.IOHandler;
import java.io.Serializable;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Car extends Vehicle implements Serializable {

    int seatingCapacity;

    public Car(IOHandler ioHandler) {
        super();
        this.ioHandler = ioHandler;
    }

    public int getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity() {
        ioHandler.print("Enter new seating capacity: ");
        this.seatingCapacity = ioHandler.readInt();
    }

    @Override
    public String toString() {
        return "Car{" + super.toString() + ", " +
                "seatingCapacity=" + getSeatingCapacity() +
                "}";
    }

    private final IOHandler ioHandler;
}
