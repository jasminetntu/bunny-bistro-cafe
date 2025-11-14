package com.bunnybistrocafe.enumerations.drinkcustomizations;

/**
 * Represents coffee flavor add-ons for coffee drinks.
 * Each flavor has an abbreviation (used for user input) and a readable name.
 */
public enum CoffeeFlavor {
    MOCHA ("M", "Mocha"), CARAMEL ("C", "Caramel"), VANILLA ("V", "Vanilla");

    // attributes
    private final String abbreviation;
    private final String name;

    /**
     * Constructs a CoffeeFlavor enum constant.
     *
     * @param abbreviation single-letter abbreviation used for selecting the flavor
     * @param name full display name of the flavor
     */
    CoffeeFlavor(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    /**
     * Gets the abbreviation associated with this coffee flavor.
     *
     * @return the single-letter abbreviation
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Gets the display name of the coffee flavor.
     *
     * @return flavor name (e.g., "Mocha", "Caramel")
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the price of the coffee flavor.
     *
     * @return fixed price of $0.25
     */
    public double getPrice() {
        return 0.25;
    }

    /**
     * Converts a user-entered abbreviation into a corresponding CoffeeFlavor enum constant.
     *
     * @param abbrev input abbreviation (case-insensitive)
     * @return matching CoffeeFlavor enum
     * @throws IllegalArgumentException if the abbreviation does not match any flavor
     */
    public static CoffeeFlavor fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (CoffeeFlavor option : CoffeeFlavor.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }

    /**
     * Returns the display name of the flavor.
     *
     * @return flavor name
     */
    @Override
    public String toString() {
        return name;
    }
}
