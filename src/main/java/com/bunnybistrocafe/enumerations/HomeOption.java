package com.bunnybistrocafe.enumerations;

public enum HomeOption {
    NEW_ORDER("N"), EXIT("X");

    private final String abbreviation;

    HomeOption(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

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
