package edu.iutcs.cr.vehicles;

import java.io.Serializable;
import edu.iutcs.cr.io.IOHandler;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SUV extends Vehicle implements Serializable {

    private boolean isOffRoad;

    // Constructor
    public SUV(IOHandler ioHandler) {
        super();
        this.ioHandler = ioHandler;
    }

    // Getters and setters
    public boolean isOffRoad() {
        return isOffRoad;
    }

    public void setOffRoad() {
        ioHandler.print("Is the SUV for off-road use? (true/false): ");
        this.isOffRoad = ioHandler.readBoolean();
    }

    @Override
    public String toString() {
        return "SUV{" + super.toString() + ", " +
                "isOffRoad=" + isOffRoad() +
                "}";
    }
}
