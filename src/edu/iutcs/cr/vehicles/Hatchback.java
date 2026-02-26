package edu.iutcs.cr.vehicles;

import edu.iutcs.cr.io.IOHandler;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class Hatchback extends Vehicle {

    public Hatchback(IOHandler ioHandler) {
        super(ioHandler);
    }

    public void updateDetails() {
        ioHandler.print("Enter hatchback-specific detail: ");
        this.someDetail = ioHandler.readLine();
    }
}
