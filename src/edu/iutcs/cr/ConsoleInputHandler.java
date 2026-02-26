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

    // ── Person helpers ────────────────────────────────────────────────────────

    /** Prompts for all Seller fields and returns a fully constructed {@link Seller}. */
    public Seller readSeller() {
        String name  = readRequiredString("Enter name: ",  "Name is mandatory!");
        String id    = readRequiredString("Enter id: ",    "Id is mandatory!");
        String email = readRequiredString("Enter email: ", "Email is mandatory!");
        return new Seller(name, id, email);
    }

    /** Prompts for all Buyer fields and returns a fully constructed {@link Buyer}. */
    public Buyer readBuyer() {
        String name  = readRequiredString("Enter name: ",  "Name is mandatory!");
        String id    = readRequiredString("Enter id: ",    "Id is mandatory!");
        String email = readRequiredString("Enter email: ", "Email is mandatory!");
        System.out.print("Enter payment method: ");
        String paymentMethod = scanner.nextLine();
        return new Buyer(name, id, email, paymentMethod);
    }

    // ── Vehicle helpers ───────────────────────────────────────────────────────

    /** Prompts for all Bus fields and returns a fully constructed {@link Bus}. */
    public Bus readBus() {
        String[] base = readVehicleBaseFields();
        System.out.print("Enter passenger capacity: ");
        int passengerCapacity = scanner.nextInt();
        scanner.nextLine(); // consume trailing newline
        return new Bus(base[0], base[1], base[2], base[3], Double.parseDouble(base[4]), passengerCapacity);
    }

    /** Prompts for all Car fields and returns a fully constructed {@link Car}. */
    public Car readCar() {
        String[] base = readVehicleBaseFields();
        System.out.print("Enter seating capacity: ");
        int seatingCapacity = scanner.nextInt();
        scanner.nextLine();
        return new Car(base[0], base[1], base[2], base[3], Double.parseDouble(base[4]), seatingCapacity);
    }

    /** Prompts for all Hatchback fields and returns a fully constructed {@link Hatchback}. */
    public Hatchback readHatchback() {
        String[] base = readVehicleBaseFields();
        System.out.print("Is the hatchback compact? (true/false): ");
        boolean isCompact = scanner.nextBoolean();
        scanner.nextLine();
        return new Hatchback(base[0], base[1], base[2], base[3], Double.parseDouble(base[4]), isCompact);
    }

    /** Prompts for all Sedan fields and returns a fully constructed {@link Sedan}. */
    public Sedan readSedan() {
        String[] base = readVehicleBaseFields();
        System.out.print("Does the sedan have a sunroof? (true/false): ");
        boolean hasSunroof = scanner.nextBoolean();
        scanner.nextLine();
        return new Sedan(base[0], base[1], base[2], base[3], Double.parseDouble(base[4]), hasSunroof);
    }

    /** Prompts for all SUV fields and returns a fully constructed {@link SUV}. */
    public SUV readSUV() {
        String[] base = readVehicleBaseFields();
        System.out.print("Is the SUV for off-road use? (true/false): ");
        boolean isOffRoad = scanner.nextBoolean();
        scanner.nextLine();
        return new SUV(base[0], base[1], base[2], base[3], Double.parseDouble(base[4]), isOffRoad);
    }

    // ── Misc helpers ──────────────────────────────────────────────────────────

    /** Prompts for and returns a vehicle registration number. */
    public String readRegistrationNumber(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine().trim();
    }

    /** Prompts for and returns a buyer ID string. */
    public String readBuyerId() {
        return readRequiredString("Enter buyer id: ", "Buyer id is mandatory!");
    }

    /** Prompts for and returns a seller ID string. */
    public String readSellerId() {
        return readRequiredString("Enter seller id: ", "Seller id is mandatory!");
    }

    /** Prompts for payment confirmation and returns the boolean result. */
    public boolean readPaymentStatus() {
        System.out.print("Is payment done (true/false): ");
        boolean paid = scanner.nextBoolean();
        scanner.nextLine();
        return paid;
    }

    // ── Menu choice readers ────────────────────────────────────────────────────

    /**
     * Displays a prompt and validates a vehicle-type choice in the range [1, 5].
     * Called by {@link edu.iutcs.cr.commands.AddVehicleCommand} after
     * {@link edu.iutcs.cr.view.ConsoleDisplay#showVehicleTypeMenu()} has been shown.
     */
    public int readVehicleType() {
        int type = -1;
        while (type < 1 || type > 5) {
            System.out.print("Enter your choice: ");
            type = scanner.nextInt();
            scanner.nextLine();
            if (type < 1 || type > 5) {
                System.out.println("Enter a valid vehicle type!");
            }
        }
        return type;
    }

    /**
     * Reads and validates a cart-operation choice in the range [1, 5].
     * Called by {@link edu.iutcs.cr.commands.CreateOrderCommand} after
     * {@link edu.iutcs.cr.view.ConsoleDisplay#showOrderMenu()} has been shown.
     */
    public int readCartOperation() {
        int op = -1;
        while (op < 1 || op > 5) {
            op = scanner.nextInt();
            scanner.nextLine();
            if (op < 1 || op > 5) {
                System.out.print("Please select a valid operation: ");
            }
        }
        return op;
    }

    // ── Internal utilities ────────────────────────────────────────────────────

    /**
     * Reads the five base fields shared by every Vehicle subclass.
     *
     * @return {@code String[]} with indexes: 0=regNo, 1=make, 2=model, 3=year, 4=price
     */
    private String[] readVehicleBaseFields() {
        String regNo = readRequiredString("Enter registration number: ", "Registration number is mandatory!");
        String make  = readRequiredString("Enter make: ",                "Make is mandatory!");
        String model = readRequiredString("Enter model: ",               "Model is mandatory!");
        String year  = readRequiredString("Enter year: ",                "Year is mandatory!");
        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); // consume trailing newline
        return new String[]{regNo, make, model, year, String.valueOf(price)};
    }

    /** Keeps re-prompting until a non-blank value is entered. */
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
