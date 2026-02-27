package edu.iutcs.cr;

import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.vehicles.*;
import java.util.Scanner;

/**
 * Centralised console I/O handler.
 *
 * <p>Responsible for all user-facing prompts and input collection.
 * Constructs and returns fully populated domain objects so that no
 * model / domain class ever touches {@link System#in} directly.
 *
 * @author Raian Rahman
 * @since 4/18/2024
 */
public class ConsoleInputHandler {

    private final Scanner scanner;

    public ConsoleInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    
    public Seller readSeller() {
        String name  = readRequiredString("Enter name: ",  "Name is mandatory!");
        String id    = readRequiredString("Enter id: ",    "Id is mandatory!");
        String email = readRequiredString("Enter email: ", "Email is mandatory!");
        return new Seller(name, id, email);
    }

    public Buyer readBuyer() {
        String name  = readRequiredString("Enter name: ",  "Name is mandatory!");
        String id    = readRequiredString("Enter id: ",    "Id is mandatory!");
        String email = readRequiredString("Enter email: ", "Email is mandatory!");
        System.out.print("Enter payment method: ");
        String paymentMethod = scanner.nextLine();
        return new Buyer(name, id, email, paymentMethod);
    }

    
    public Bus readBus() {
        VehicleBaseData base = readVehicleBaseFields();
        System.out.print("Enter passenger capacity: ");
        int passengerCapacity = scanner.nextInt();
        scanner.nextLine();
        return new Bus(base.registrationNumber(), base.make(), base.model(), base.year(), base.price(), passengerCapacity);
    }

    public Car readCar() {
        VehicleBaseData base = readVehicleBaseFields();
        System.out.print("Enter seating capacity: ");
        int seatingCapacity = scanner.nextInt();
        scanner.nextLine();
        return new Car(base.registrationNumber(), base.make(), base.model(), base.year(), base.price(), seatingCapacity);
    }

    public Hatchback readHatchback() {
        VehicleBaseData base = readVehicleBaseFields();
        System.out.print("Is the hatchback compact? (true/false): ");
        boolean isCompact = scanner.nextBoolean();
        scanner.nextLine();
        return new Hatchback(base.registrationNumber(), base.make(), base.model(), base.year(), base.price(), isCompact);
    }

    public Sedan readSedan() {
        VehicleBaseData base = readVehicleBaseFields();
        System.out.print("Does the sedan have a sunroof? (true/false): ");
        boolean hasSunroof = scanner.nextBoolean();
        scanner.nextLine();
        return new Sedan(base.registrationNumber(), base.make(), base.model(), base.year(), base.price(), hasSunroof);
    }

    public SUV readSUV() {
        VehicleBaseData base = readVehicleBaseFields();
        System.out.print("Is the SUV for off-road use? (true/false): ");
        boolean isOffRoad = scanner.nextBoolean();
        scanner.nextLine();
        return new SUV(base.registrationNumber(), base.make(), base.model(), base.year(), base.price(), isOffRoad);
    }

    
     public String readRegistrationNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    public String readBuyerId() {
        return readRequiredString("Enter buyer id: ", "Buyer id is mandatory!");
    }

    public String readSellerId() {
        return readRequiredString("Enter seller id: ", "Seller id is mandatory!");
    }

    public boolean readPaymentStatus() {
        System.out.print("Is payment done (true/false): ");
        boolean paid = scanner.nextBoolean();
        scanner.nextLine();
        return paid;
    }
    
    /**
     * Displays a prompt and validates a vehicle-type choice in the range [1, 5].
     * Called by {@link edu.iutcs.cr.commands.AddVehicleCommand} after
     * {@link edu.iutcs.cr.view.ConsoleDisplay#showVehicleTypeMenu()} has been shown.
     */
    public VehicleType readVehicleType() {
        int code = -1;
        while (code < VehicleType.minCode() || code > VehicleType.maxCode()) {
            System.out.print("Enter your choice: ");
            code = scanner.nextInt();
            scanner.nextLine();
            if (code < VehicleType.minCode() || code > VehicleType.maxCode()) {
                System.out.println("Enter a valid vehicle type!");
            }
        }
        return VehicleType.fromCode(code);
    }

    /**
     * Reads and validates a cart-operation choice in the range [1, 5].
     * Called by {@link edu.iutcs.cr.commands.CreateOrderCommand} after
     * {@link edu.iutcs.cr.view.ConsoleDisplay#showOrderMenu()} has been shown.
     */
    public CartOperation readCartOperation() {
        int code = -1;
        while (code < CartOperation.minCode() || code > CartOperation.maxCode()) {
            code = scanner.nextInt();
            scanner.nextLine();
            if (code < CartOperation.minCode() || code > CartOperation.maxCode()) {
                System.out.print("Please select a valid operation: ");
            }
        }
        return CartOperation.fromCode(code);
    }

    
    /**
     * Reads the five fields shared by every Vehicle subclass.
     *
     * @return a {@link VehicleBaseData} with named fields for each value
     */
    private VehicleBaseData readVehicleBaseFields() {
        String regNo = readRequiredString("Enter registration number: ", "Registration number is mandatory!");
        String make  = readRequiredString("Enter make: ",                "Make is mandatory!");
        String model = readRequiredString("Enter model: ",               "Model is mandatory!");
        String year  = readRequiredString("Enter year: ",                "Year is mandatory!");
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume trailing newline
        return new VehicleBaseData(regNo, make, model, year, price);
    }

    private String readRequiredString(String prompt, String errorMessage) {
        String value = null;
        while (value == null || value.isBlank()) {
            System.out.print(prompt);
            value = scanner.nextLine();
            if (value == null || value.isBlank()) {
                System.out.println(errorMessage);
            }
        }
        return value;
    }
}
