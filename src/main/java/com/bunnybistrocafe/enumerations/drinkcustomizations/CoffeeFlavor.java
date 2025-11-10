package com.bunnybistrocafe.enumerations.drinkcustomizations;

public enum CoffeeFlavor {
    MOCHA ("M", "Mocha"), CARAMEL ("C", "Caramel"), VANILLA ("V", "Vanilla");

    private final String abbreviation;
    private final String name;

    CoffeeFlavor(String abbreviation, String name) {
        this.abbreviation = abbreviation;
        this.name = name;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return 0.25;
    }

    public CoffeeFlavor fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (CoffeeFlavor option : CoffeeFlavor.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, return null
        throw new IllegalArgumentException();
    }
}
