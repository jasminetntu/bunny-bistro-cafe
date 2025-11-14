package com.bunnybistrocafe.enumerations.drinkcustomizations;

/**
 * Represents the main drink categories available at Bunny Bistro Cafe.
 * Each type includes an abbreviation, a display name, and an additional
 * base price added to the drink depending on the category.
 */
public enum DrinkType {
    MATCHA("M", "Matcha Latte", 1.50), COFFEE("C", "Caffe Latte", 1.00),
    MILK_TEA("MT", "Milk Tea", 0.00), TEA("T", "Tea", 0.00);

    private final String abbreviation;
    private final String name;
    private final double price;

    /**
     * Constructor for DrinkType enum.
     *
     * @param abbreviation short letter code associated with the drink type
     * @param name display name of the drink type
     * @param price additional cost added for this drink category
     */
    DrinkType(String abbreviation, String name, double price) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the abbreviation associated with this drink type.
     *
     * @return abbreviation (e.g., "M", "C", "MT", "T")
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Returns the display name of this drink type.
     *
     * @return full name of the drink type
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the additional price associated with this drink type.
     *
     * @return extra cost added to the drink
     */
    public double getPrice() {
        return price;
    }

    /**
     * Converts a user-input abbreviation into the corresponding DrinkType enum.
     *
     * @param abbrev abbreviation input, case-insensitive
     * @return matching DrinkType enum
     * @throws IllegalArgumentException if no matching abbreviation exists
     */
    public static DrinkType fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (DrinkType option : DrinkType.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }

    /**
     * Returns the display name of this drink type.
     *
     * @return name of the drink type
     */
    @Override
    public String toString() {
        return name;
    }
}
