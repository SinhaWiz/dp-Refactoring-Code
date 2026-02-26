package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.io.IOHandler;
import java.io.Serializable;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class Bus extends Vehicle implements Serializable {

    int passengerCapacity;

    public Bus(IOHandler ioHandler) {
        super();
        this.ioHandler = ioHandler;
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public void setPassengerCapacity() {
        ioHandler.print("Enter new passenger capacity: ");
        this.passengerCapacity = ioHandler.readInt();
    }

    @Override
    public String toString() {
        return "Bus{" + super.toString() + ", " +
                "passengerCapacity=" + getPassengerCapacity() +
                "}";
    }

    private final IOHandler ioHandler;
}
