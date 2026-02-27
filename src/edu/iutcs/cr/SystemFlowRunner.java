package edu.iutcs.cr;

import edu.iutcs.cr.commands.*;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.system.SystemRepository;
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
        SystemRepository repository = new SystemRepository(database);
        MainMenu mainMenu      = new MainMenu();

        Map<MenuOption, Command> commands = new HashMap<>();
        commands.put(MenuOption.ADD_SELLER,     new AddSellerCommand(database, inputHandler, display));
        commands.put(MenuOption.ADD_BUYER,      new AddBuyerCommand(database, inputHandler, display));
        commands.put(MenuOption.ADD_VEHICLE,    new AddVehicleCommand(database, inputHandler, display));
        commands.put(MenuOption.VIEW_INVENTORY, new ViewInventoryCommand(database, display));
        commands.put(MenuOption.VIEW_SELLERS,   new ViewSellerListCommand(database, display));
        commands.put(MenuOption.VIEW_BUYERS,    new ViewBuyerListCommand(database, display));
        commands.put(MenuOption.CREATE_ORDER,   new CreateOrderCommand(database, repository, inputHandler, display));
        commands.put(MenuOption.VIEW_INVOICES,  new ViewInvoicesCommand(database, display));
        commands.put(MenuOption.SAVE_AND_EXIT,  new SaveAndExitCommand(database));

        while (true) {
            System.out.println("\n\n\n");
            MenuOption selectedOperation = mainMenu.showAndSelectOperation();
            commands.get(selectedOperation).execute();
        }
    }
}
