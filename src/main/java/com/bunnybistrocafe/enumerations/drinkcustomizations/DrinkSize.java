package com.bunnybistrocafe.enumerations.drinkcustomizations;

/**
 * Represents available drink sizes, each with an abbreviation, display name, and base price.
 */
public enum DrinkSize {
    SMALL("S", "Small", 4.95), MEDIUM("M", "Medium", 5.95), LARGE("L", "Large", 6.95);

    private final String abbreviation;
    private final String name;
    private final double price;

    /**
     * Constructs a DrinkSize enum constant.
     *
     * @param abbreviation single-letter abbreviation used for user input
     * @param name display name of the drink size
     * @param price base price associated with the size
     */
    DrinkSize(String abbreviation, String name, double price) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.price = price;
    }

    /**
     * Gets the abbreviation associated with this drink size.
     *
     * @return the single-letter abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Gets the display name of the drink size.
     *
     * @return name (e.g., "Small", "Medium", "Large")
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price associated with the drink size.
     *
     * @return base price for the size
     */
    public double getPrice() {
        return price;
    }

    /**
     * Converts a user-entered abbreviation into the corresponding DrinkSize enum constant.
     *
     * @param abbrev input abbreviation (case-insensitive)
     * @return matching DrinkSize enum
     * @throws IllegalArgumentException if no matching abbreviation exists
     */
    public static DrinkSize fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (DrinkSize option : DrinkSize.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }

    /**
     * Returns the display name of the size.
     *
     * @return size name
     */
    @Override
    public String toString() {
        return name;
    }
}
