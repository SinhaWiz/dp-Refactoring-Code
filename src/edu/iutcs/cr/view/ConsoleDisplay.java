package edu.iutcs.cr.view;

import edu.iutcs.cr.Invoice;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.vehicles.Vehicle;

import java.util.Scanner;
import java.util.Set;

/**
 * Handles all console display / presentation logic.
 *
 * <p>Extracted from {@code SystemDatabase} to satisfy SRP: the database is
 * now purely a data store, while all {@code System.out} calls live here.
 *
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class ConsoleDisplay {

    private final Scanner scanner;

    public ConsoleDisplay(Scanner scanner) {
        this.scanner = scanner;
    }

    // ── Collection views ──────────────────────────────────────────────────────

    public void showInventory(Set<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No vehicles present in system");
            return;
        }
        for (Vehicle vehicle : vehicles) {
            System.out.println(vehicle.toString());
        }
    }

    public void showBuyerList(Set<Buyer> buyers) {
        if (buyers.isEmpty()) {
            System.out.println("No buyer present in system");
            return;
        }
        for (Buyer buyer : buyers) {
            System.out.println(buyer.toString());
        }
    }

    public void showSellerList(Set<Seller> sellers) {
        if (sellers.isEmpty()) {
            System.out.println("No seller present in system");
            return;
        }
        for (Seller seller : sellers) {
            System.out.println(seller.toString());
        }
    }

    public void showInvoices(Set<Invoice> invoices) {
        if (invoices.isEmpty()) {
            System.out.println("No invoice found in system");
            return;
        }
        for (Invoice invoice : invoices) {
            invoice.printInvoice();
            System.out.println("\n\n\n");
        }
    }

    // ── Sub-menus ─────────────────────────────────────────────────────────────

    public void showVehicleTypeMenu() {
        System.out.println("Please enter the type of vehicle [1-5]: ");
        System.out.println("1. Bus");
        System.out.println("2. Car");
        System.out.println("3. Hatchback");
        System.out.println("4. Sedan");
        System.out.println("5. SUV");
    }

    public void showOrderMenu() {
        System.out.println("Please enter the type of operation: [1-5]");
        System.out.println("1. Add new vehicle to cart");
        System.out.println("2. Remove vehicle from cart");
        System.out.println("3. View cart");
        System.out.println("4. Confirm purchase");
        System.out.println();
        System.out.println("5. Return to main menu");
    }

    // ── Navigation prompt ─────────────────────────────────────────────────────

    /** Blocks until the user enters {@code 0} to return to the main menu. */
    public void promptToViewMainMenu() {
        System.out.print("\n\nEnter 0 to view main menu: ");
        int val = -1;
        do {
            val = scanner.nextInt();
        } while (val != 0);
    }
}
