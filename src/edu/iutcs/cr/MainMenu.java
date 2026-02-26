package edu.iutcs.cr;

import java.util.Scanner;
import edu.iutcs.cr.io.IOHandler;

/**
 * @author Raian Rahman
 * @since 4/19/2024
 */
public class MainMenu {
    private final IOHandler ioHandler;

    public MainMenu(IOHandler ioHandler) {
        this.ioHandler = ioHandler;
    }

    private void showMenu() {
        ioHandler.println("Please enter the type of vehicle [1-9]: ");
        ioHandler.println("1. Add new seller");
        ioHandler.println("2. Add new customer");
        ioHandler.println("3. Add car");
        ioHandler.println("4. View inventory");
        ioHandler.println("5. View seller list");
        ioHandler.println("6. View buyer list");

        ioHandler.println();
        ioHandler.println("7. Add new order");
        ioHandler.println("8. View all invoices");

        ioHandler.println();
        ioHandler.println("9. Save System and Exit");
    }

    public int showAndSelectOperation() {
        Scanner scanner = new Scanner(System.in);
        showMenu();
        int selectedOperation = -1;

        while(selectedOperation<1 || selectedOperation>9) {
            System.out.print("Enter your choice: ");
            selectedOperation = scanner.nextInt();

            if(selectedOperation<1 || selectedOperation>9) {
                System.out.print("Enter a valid operation: ");
            }
        }

        return selectedOperation;
    }
}
