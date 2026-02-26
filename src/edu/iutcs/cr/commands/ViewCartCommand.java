package edu.iutcs.cr.commands;

import edu.iutcs.cr.ShoppingCart;

/**
 * Command to display all items currently in the shopping cart.
 */
public class ViewCartCommand implements Command {

    private final ShoppingCart cart;

    public ViewCartCommand(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.viewCart();
    }
}
