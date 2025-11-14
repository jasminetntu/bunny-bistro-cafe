package com.bunnybistrocafe.enumerations;

/**
 * Represents the user's options on the home screen of the Bunny Bistro Café kiosk.
 * Each option is identified by a single-letter abbreviation.
 */
public enum HomeOption {
    NEW_ORDER("N"), EXIT("X");

    private final String abbreviation;

    /**
     * Constructor for HomeOption enum.
     *
     * @param abbreviation single-letter code representing the option
     */
    HomeOption(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Retrieves the abbreviation associated with this home option.
     *
     * @return abbreviation ("N" or "X")
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Converts a user-provided abbreviation into the corresponding HomeOption.
     *
     * @param abbrev the single-letter input, case-insensitive
     * @return the matching HomeOption
     * @throws IllegalArgumentException if the abbreviation does not match any option
     */
    public static HomeOption fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (HomeOption option : HomeOption.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}
