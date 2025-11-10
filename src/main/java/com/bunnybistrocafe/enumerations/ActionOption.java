package com.bunnybistrocafe.enumerations;

public enum ActionOption {
    CONFIRM("Y"), CANCEL("N"), RETURN("R");

    private final String abbreviation;

    ActionOption(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public ActionOption fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (ActionOption option : ActionOption.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, return null
        throw new IllegalArgumentException();
    }
}
