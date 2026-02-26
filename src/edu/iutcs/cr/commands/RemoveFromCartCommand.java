package edu.iutcs.cr.commands;

import edu.iutcs.cr.ShoppingCart;

/**
 * Command to remove a vehicle from the shopping cart.
 */
public class RemoveFromCartCommand implements Command {

    private final ShoppingCart cart;

    public RemoveFromCartCommand(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.removeItem();
    }
}
