package edu.iutcs.cr.vehicles;

import java.io.Serializable;
import edu.iutcs.cr.io.IOHandler;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class Sedan extends Vehicle implements Serializable {

    private boolean hasSunroof;

    // Constructor
    public Sedan(IOHandler ioHandler) {
        super(ioHandler);
    }

    // Getters and setters
    public boolean hasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof() {
        // Taking input within the setter, which might lead to unexpected behavior
        ioHandler.print("Does the sedan have a sunroof? (true/false): ");
        this.hasSunroof = ioHandler.nextBoolean();
    }

    @Override
    public String toString() {
        return "Sedan{" + super.toString() + ", " +
                "hasSunroof=" + hasSunroof() +
                "}";
    }
}
