package edu.iutcs.cr;

import edu.iutcs.cr.commands.*;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.view.ConsoleDisplay;
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

        Scanner scanner        = new Scanner(System.in);
        ConsoleInputHandler inputHandler = new ConsoleInputHandler(scanner);
        ConsoleDisplay display = new ConsoleDisplay(scanner);
        MainMenu mainMenu      = new MainMenu();

        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, new AddSellerCommand(database, inputHandler, display));
        commands.put(2, new AddBuyerCommand(database, inputHandler, display));
        commands.put(3, new AddVehicleCommand(database, inputHandler, display));
        commands.put(4, new ViewInventoryCommand(database, display));
        commands.put(5, new ViewSellerListCommand(database, display));
        commands.put(6, new ViewBuyerListCommand(database, display));
        commands.put(7, new CreateOrderCommand(database, inputHandler, display));
        commands.put(8, new ViewInvoicesCommand(database, display));
        commands.put(9, new SaveAndExitCommand(database));

        while (true) {
            System.out.println("\n\n\n");
            int selectedOperation = mainMenu.showAndSelectOperation();
            commands.get(selectedOperation).execute();
        }
    }
}
