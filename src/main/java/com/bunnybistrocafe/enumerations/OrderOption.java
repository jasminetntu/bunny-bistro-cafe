package com.bunnybistrocafe.enumerations;

/**
 * Represents the available order-related actions a user can take
 * within the Bunny Bistro Café kiosk system. Each option is identified
 * by an associated numeric value.
 */
public enum OrderOption {
    ADD_DRINK(1), ADD_PASTRY(2), ADD_ENTREE(3), VIEW_ORDER_SUMMARY(4), CHECKOUT(5);

    private final int num;

    /**
     * Constructor for OrderOption enum.
     *
     * @param num numeric code representing the option
     */
    OrderOption(int num) {
        this.num = num;
    }

    /**
     * Retrieves the numeric value associated with this order option.
     *
     * @return numeric option value (1–5)
     */
    public int getNum() {
        return num;
    }

    /**
     * Converts the given numeric input into the corresponding OrderOption.
     *
     * @param num numeric input representing a menu choice
     * @return the matching OrderOption
     * @throws IllegalArgumentException if the number does not match any option
     */
    public static OrderOption fromNum(int num) {
        // iterate through all enum values
        for (OrderOption option : OrderOption.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}
