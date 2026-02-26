package edu.iutcs.cr;

import edu.iutcs.cr.commands.AddToCartCommand;
import edu.iutcs.cr.commands.Command;
import edu.iutcs.cr.commands.RemoveFromCartCommand;
import edu.iutcs.cr.commands.ViewCartCommand;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.vehicles.Vehicle;
import edu.iutcs.cr.vehicles.VehicleFactory;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class SystemFlowRunner {

    public static void run() {
        System.out.println("Welcome to Car Hut");

        System.out.println("Loading existing system");
        SystemDatabase database = SystemDatabase.getInstance();
        System.out.println("Existing system loaded");

        // Command Pattern: each menu option is mapped to a Command (lambda).
        // Adding a new menu entry requires only a new map entry — no if-else changes.
        Map<Integer, Command> menuCommands = new HashMap<>();
        menuCommands.put(1, () -> { System.out.println("\n\n\nAdd new seller");   database.getSellers().add(new Seller());  promptToViewMainMenu(); });
        menuCommands.put(2, () -> { System.out.println("\n\n\nAdd new customer"); database.getBuyers().add(new Buyer());   promptToViewMainMenu(); });
        menuCommands.put(3, () -> { System.out.println("\n\n\nAdd new vehicle");  addVehicle();                              promptToViewMainMenu(); });
        menuCommands.put(4, () -> { System.out.println("\n\n\nInventory list");   database.showInventory();                 promptToViewMainMenu(); });
        menuCommands.put(5, () -> { System.out.println("\n\n\nSeller's list");    database.showSellerList();                promptToViewMainMenu(); });
        menuCommands.put(6, () -> { System.out.println("\n\n\nCustomer's list");  database.showBuyerList();                 promptToViewMainMenu(); });
        menuCommands.put(7, () -> { System.out.println("\n\n\nCreate order");     createOrder(); });
        menuCommands.put(8, () -> { System.out.println("\n\n\nInvoice list");     database.showInvoices();                  promptToViewMainMenu(); });

        MainMenu mainMenu = new MainMenu();

        while (true) {
            System.out.println("\n\n\n");

            int selectedOperation = mainMenu.showAndSelectOperation();

            if (selectedOperation == 9) {
                database.saveSystem();
                return;
            }

            Command command = menuCommands.get(selectedOperation);
            if (command != null) {
                command.execute();
            }
        }
    }

    private static void promptToViewMainMenu() {
        System.out.print("\n\nEnter 0 to view main menu: ");

        Scanner scanner = new Scanner(System.in);
        int val = -1;

        do {
            val = scanner.nextInt();
        } while (val != 0);
    }

    // Factory Pattern: VehicleFactory maps the type integer to the correct constructor.
    // No if-else needed here — adding a new vehicle type only requires updating VehicleFactory.
    private static void addVehicle() {
        Scanner scanner = new Scanner(System.in);
        SystemDatabase database = SystemDatabase.getInstance();
        int typeCount = VehicleFactory.getTypeCount();

        System.out.println("Please enter the type of vehicle [1-" + typeCount + "]: ");
        System.out.println("1. Bus");
        System.out.println("2. Car");
        System.out.println("3. Hatchback");
        System.out.println("4. Sedan");
        System.out.println("5. SUV");

        int vehicleType = -1;
        while (vehicleType < 1 || vehicleType > typeCount) {
            System.out.print("Enter your choice: ");
            vehicleType = scanner.nextInt();

            if (vehicleType < 1 || vehicleType > typeCount) {
                System.out.println("Enter a valid vehicle type!");
            }
        }

        System.out.println("\n\nCreate new " + VehicleFactory.getTypeName(vehicleType).toLowerCase());
        Vehicle newItem = VehicleFactory.create(vehicleType);
        database.getVehicles().add(newItem);
    }

    private static void createOrder() {
        Scanner scanner = new Scanner(System.in);
        ShoppingCart cart = new ShoppingCart();

        // Command Pattern: cart sub-menu operations mapped to concrete Command objects.
        Map<Integer, Command> cartCommands = new HashMap<>();
        cartCommands.put(1, new AddToCartCommand(cart));
        cartCommands.put(2, new RemoveFromCartCommand(cart));
        cartCommands.put(3, new ViewCartCommand(cart));

        while (true) {
            System.out.println("Please enter the type of operation: [1-5]");
            System.out.println("1. Add new vehicle to cart");
            System.out.println("2. Remove vehicle from cart");
            System.out.println("3. View cart");
            System.out.println("4. Confirm purchase");
            System.out.println();
            System.out.println("5. Return to main menu");

            int selectedOperation = scanner.nextInt();

            while (selectedOperation < 1 || selectedOperation > 5) {
                System.out.print("Please select a valid operation: ");
                selectedOperation = scanner.nextInt();
            }

            if (selectedOperation == 4) { createInvoice(cart); return; }
            if (selectedOperation == 5) { return; }

            cartCommands.get(selectedOperation).execute();
        }
    }

    private static void createInvoice(ShoppingCart cart) {
        Scanner scanner = new Scanner(System.in);
        SystemDatabase database = SystemDatabase.getInstance();

        Buyer buyer = null;
        Seller seller = null;

        do {
            System.out.print("Enter buyer id: ");
            String buyerId = scanner.nextLine();
            buyer = database.findBuyerById(buyerId);

            if (buyer == null) {
                System.out.println("Buyer not found. Try again!");
            }
        } while (buyer == null);

        do {
            System.out.print("Enter seller id: ");
            String sellerId = scanner.nextLine();
            seller = database.findSellerById(sellerId);

            if (seller == null) {
                System.out.println("Seller not found. Try again!");
            }
        } while (seller == null);

        Invoice invoice = new Invoice(buyer, seller, cart);
        invoice.printInvoice();
        database.getInvoices().add(invoice);
    }
}
