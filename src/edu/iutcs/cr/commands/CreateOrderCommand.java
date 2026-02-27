package edu.iutcs.cr.commands;

import edu.iutcs.cr.CartOperation;
import edu.iutcs.cr.ConsoleInputHandler;
import edu.iutcs.cr.Invoice;
import edu.iutcs.cr.ShoppingCart;
import edu.iutcs.cr.persons.Buyer;
import edu.iutcs.cr.persons.Seller;
import edu.iutcs.cr.system.SystemDatabase;
import edu.iutcs.cr.system.SystemRepository;
import edu.iutcs.cr.view.ConsoleDisplay;

/**
 * Command: manage a shopping-cart session and, on confirmation, create and
 * persist an {@link Invoice}.
 *
 * <p>Encapsulates what was previously the {@code createOrder()} and
 * {@code createInvoice()} private methods of {@code SystemFlowRunner}.
 */
public class CreateOrderCommand implements Command {

    private final SystemDatabase database;
    private final SystemRepository repository;
    private final ConsoleInputHandler inputHandler;
    private final ConsoleDisplay display;

    public CreateOrderCommand(SystemDatabase database,
                              SystemRepository repository,
                              ConsoleInputHandler inputHandler,
                              ConsoleDisplay display) {
        this.database     = database;
        this.repository   = repository;
        this.inputHandler = inputHandler;
        this.display      = display;
    }

    @Override
    public void execute() {
        System.out.println("\n\n\nCreate order");
        ShoppingCart cart = new ShoppingCart();

        while (true) {
            display.showOrderMenu();
            CartOperation op = inputHandler.readCartOperation();

            switch (op) {
                case ADD_VEHICLE    -> cart.addItem(inputHandler.readRegistrationNumber("Enter registration number of vehicle: "));
                case REMOVE_VEHICLE -> cart.removeItem(inputHandler.readRegistrationNumber("Enter the registration number of the vehicle: "));
                case VIEW_CART      -> cart.viewCart();
                case CONFIRM_PURCHASE -> { confirmPurchase(cart); return; }
                case RETURN_TO_MENU   -> { return; }
            }
        }
    }

    // ── Private helpers ───────────────────────────────────────────────────────

    private void confirmPurchase(ShoppingCart cart) {
        Buyer buyer = null;
        do {
            String buyerId = inputHandler.readBuyerId();
            buyer = repository.findBuyerById(buyerId);
            if (buyer == null) {
                System.out.println("Buyer not found. Try again!");
            }
        } while (buyer == null);

        Seller seller = null;
        do {
            String sellerId = inputHandler.readSellerId();
            seller = repository.findSellerById(sellerId);
            if (seller == null) {
                System.out.println("Seller not found. Try again!");
            }
        } while (seller == null);

        boolean isPaid = inputHandler.readPaymentStatus();
        Invoice invoice = new Invoice(buyer, seller, cart, isPaid);
        invoice.printInvoice();
        database.getInvoices().add(invoice);
    }
}
