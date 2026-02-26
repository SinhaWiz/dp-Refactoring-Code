package edu.iutcs.cr.vehicles;

import java.io.Serializable;
import java.util.Objects;

import edu.iutcs.cr.io.IOHandler;

/**
 * @author Raian Rahman
 * @since 4/18/2024
 */
public abstract class Vehicle implements Serializable {

    protected final IOHandler ioHandler;

    private String make;
    private String model;
    private String year;
    private double price;
    private boolean available;
    private String registrationNumber;

    public Vehicle(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    public Vehicle(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return this.registrationNumber;
    }

    public void setRegistrationNumber() {
        ioHandler.print("Enter registration number: ");
        this.registrationNumber = ioHandler.readLine();

        while (this.registrationNumber == null || this.registrationNumber.isBlank()) {
            ioHandler.print("Registration number is mandatory!");
            this.registrationNumber = ioHandler.readLine();
        }
    }

    public String getMake() {
        return make;
    }

    public void setMake() {
        ioHandler.print("Enter make: ");
        this.make = ioHandler.readLine();

        while (this.make == null || this.make.isBlank()) {
            ioHandler.print("Make is mandatory!");
            this.make = ioHandler.readLine();
        }
    }

    public String getModel() {
        return model;
    }

    public void setModel() {
        ioHandler.print("Enter model: ");
        this.model = ioHandler.readLine();

        while (this.model == null || this.model.isBlank()) {
            ioHandler.print("Model is mandatory!");
            this.model = ioHandler.readLine();
        }
    }

    public String getYear() {
        return year;
    }

    public void setYear() {
        ioHandler.print("Enter year: ");
        this.year = ioHandler.readLine();

        while (this.year == null || this.year.isBlank()) {
            ioHandler.print("Year is mandatory!");
            this.year = ioHandler.readLine();
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice() {
        ioHandler.print("Enter price: ");
        this.price = ioHandler.nextDouble();
    }

    public boolean isAvailable() {
        return available;
    }

    public void setUnavailable() {
        this.available = false;
    }

    @Override
    public String toString() {
        return "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year='" + year + '\'' +
                ", price=" + price +
                ", available=" + available +
                ", registrationNumber='" + registrationNumber + '\'';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vehicle vehicle)) return false;
        return Objects.equals(this.registrationNumber, vehicle.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
