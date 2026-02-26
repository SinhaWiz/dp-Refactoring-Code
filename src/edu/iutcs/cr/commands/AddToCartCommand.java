package edu.iutcs.cr.commands;

import edu.iutcs.cr.ShoppingCart;

/**
 * Command to add a vehicle to the shopping cart.
 */
public class AddToCartCommand implements Command {

    private final ShoppingCart cart;

    public AddToCartCommand(ShoppingCart cart) {
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.addItem();
    }
}
