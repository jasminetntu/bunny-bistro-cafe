package com.bunnybistrocafe.enumerations.drinkcustomizations;

/**
 * Represents base tea types used in drinks, each with an abbreviation and name.
 */
public enum TeaType {
    BLACK ("B", "Black Tea"), GREEN ("G", "Green Tea"), OOLONG ("O", "Oolong Tea"),
    THAI ("T", "Thai Tea"), WHITE ("W", "White Tea");

    private final String abbreviation;
    private final String name;

    /**
     * Constructs a TeaType enum instance.
     *
     * @param abbreviation short code for the tea type
     * @param name display name of the tea
     */
    TeaType(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    /**
     * Returns the abbreviation for this tea type.
     *
     * @return abbreviation string
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Returns this tea type's display name.
     *
     * @return tea name
     */
    public String getName() {
        return name;
    }

    /**
     * Converts a user input abbreviation into a TeaType enum.
     *
     * @param abbrev abbreviation input (case-insensitive)
     * @return matching TeaType
     * @throws IllegalArgumentException if no match is found
     */
    public static TeaType fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (TeaType option : TeaType.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }

    /**
     * Returns the display name of this tea type.
     *
     * @return tea name
     */
    @Override
    public String toString() {
        return name;
    }
}
