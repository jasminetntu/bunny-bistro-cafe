package com.bunnybistrocafe.enumerations;

/**
 * Represents the type of drink selection the user can make.
 * Each option is associated with a number.
 */
public enum DrinkOption {
    SIGNATURE(1), CUSTOM(2);

    private final int num;

    /**
     * Constructor for DrinkOption enum.
     *
     * @param num numeric value associated with the option
     */
    DrinkOption(int num) {
        this.num = num;
    }

    /**
     * Gets the numeric identifier for this drink option.
     *
     * @return the numeric value (1 or 2)
     */
    public int getNum() {
        return num;
    }

    /**
     * Converts a numeric input into the corresponding DrinkOption.
     *
     * @param num the numeric selection entered by the user
     * @return the matching DrinkOption
     * @throws IllegalArgumentException if the number does not match any option
     */
    public static DrinkOption fromNum(int num) {
        // iterate through all enum values
        for (DrinkOption option : DrinkOption.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}
