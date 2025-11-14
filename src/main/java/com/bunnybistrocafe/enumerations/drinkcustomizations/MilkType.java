package com.bunnybistrocafe.enumerations.drinkcustomizations;

/**
 * Represents the milk options available for drinks at Bunny Bistro Cafe.
 * Each type has an abbreviation, display name, and an additional cost
 * that may be added to the drink price.
 */
public enum MilkType {
    WHOLE("W", "Whole Milk", 0.00), OAT("O", "Oat Milk", 0.50),
    ALMOND("A", "Almond Milk", 0.50), NONDAIRY("N", "Non-dairy Creamer", 0.00);

    private final String abbreviation;
    private final String name;
    private final double price;

    /**
     * Constructor for MilkType enum.
     *
     * @param abbreviation short letter code representing the milk type
     * @param name display name of the milk type
     * @param price additional cost associated with this milk option
     */
    MilkType(String abbreviation, String name, double price) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the abbreviation associated with this milk type.
     *
     * @return single-letter abbreviation (e.g., "W", "O", "A", "N")
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Returns the display name of this milk type.
     *
     * @return name such as "Oat Milk" or "Almond Milk"
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the additional price added when selecting this milk type.
     *
     * @return price difference for this milk option
     */
    public double getPrice() {
        return price;
    }

    /**
     * Converts a user-input abbreviation into the corresponding MilkType enum.
     *
     * @param abbrev abbreviation input, case-insensitive
     * @return matching MilkType value
     * @throws IllegalArgumentException if no matching abbreviation exists
     */
    public static MilkType fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (MilkType option : MilkType.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }

    /**
     * Returns the display name of this milk type.
     *
     * @return name of the milk type
     */
    @Override
    public String toString() {
        return name;
    }
}
