package edu.iutcs.cr;

/**
 * Represents the numbered operations available inside the order / shopping-cart
 * sub-menu.
 *
 * <p>Replaces the bare integer codes (1–5) previously used in
 * {@link ConsoleInputHandler#readCartOperation()} and
 * {@link edu.iutcs.cr.commands.CreateOrderCommand}.
 */
public enum CartOperation {

    ADD_VEHICLE(1),
    REMOVE_VEHICLE(2),
    VIEW_CART(3),
    CONFIRM_PURCHASE(4),
    RETURN_TO_MENU(5);

    private final int code;

    CartOperation(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    /** Returns the lowest valid cart-operation code (currently {@code 1}). */
    public static int minCode() {
        return ADD_VEHICLE.code;
    }

    /** Returns the highest valid cart-operation code (currently {@code 5}). */
    public static int maxCode() {
        return RETURN_TO_MENU.code;
    }

    /**
     * Maps a raw integer to its {@code CartOperation}.
     *
     * @throws IllegalArgumentException if {@code code} is out of range
     */
    public static CartOperation fromCode(int code) {
        for (CartOperation op : values()) {
            if (op.code == code) {
                return op;
            }
        }
        throw new IllegalArgumentException("Invalid cart operation: " + code);
    }
}
