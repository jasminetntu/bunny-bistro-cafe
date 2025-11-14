package com.bunnybistrocafe.enumerations;

/**
 * Represents user action choices such as confirming, canceling, or returning.
 * Each option is associated with a single-letter abbreviation.
 */
public enum ActionOption {
    CONFIRM("Y"), CANCEL("N"), RETURN("R");

    private final String abbreviation;

    /**
     * Constructor for ActionOption enum.
     *
     * @param abbreviation the abbreviation associated with the option
     */
    ActionOption(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    /**
     * Gets the abbreviation associated with this action option.
     *
     * @return the abbreviation (Y, N, R)
     */
    public String getAbbreviation() {
        return abbreviation;
    }

    /**
     * Converts a user-provided string into the corresponding ActionOption.
     * Matching is case-insensitive and ignores surrounding whitespace.
     *
     * @param abbrev the input abbreviation (e.g., "Y", "N", "R")
     * @return the corresponding ActionOption
     * @throws IllegalArgumentException if the input does not match any option
     */
    public static ActionOption fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (ActionOption option : ActionOption.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}
