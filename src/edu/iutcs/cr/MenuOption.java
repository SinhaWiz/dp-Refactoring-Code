package edu.iutcs.cr;

/**
 * Represents each numbered option in the main application menu.
 *
 * <p>Replaces the bare integer codes (1–9) that were previously scattered
 * across {@link MainMenu} and {@link SystemFlowRunner}, eliminating both
 * magic numbers and primitive obsession.
 */
public enum MenuOption {

    ADD_SELLER(1),
    ADD_BUYER(2),
    ADD_VEHICLE(3),
    VIEW_INVENTORY(4),
    VIEW_SELLERS(5),
    VIEW_BUYERS(6),
    CREATE_ORDER(7),
    VIEW_INVOICES(8),
    SAVE_AND_EXIT(9);

    private final int code;

    MenuOption(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    /** Returns the lowest valid menu code (currently {@code 1}). */
    public static int minCode() {
        return ADD_SELLER.code;
    }

    /** Returns the highest valid menu code (currently {@code 9}). */
    public static int maxCode() {
        return SAVE_AND_EXIT.code;
    }

    /**
     * Maps a raw integer to its {@code MenuOption}.
     *
     * @throws IllegalArgumentException if {@code code} is out of range
     */
    public static MenuOption fromCode(int code) {
        for (MenuOption option : values()) {
            if (option.code == code) {
                return option;
            }
        }
        throw new IllegalArgumentException("Invalid menu option: " + code);
    }
}
