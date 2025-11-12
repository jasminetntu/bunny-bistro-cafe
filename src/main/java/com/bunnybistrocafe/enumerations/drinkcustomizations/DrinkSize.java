package com.bunnybistrocafe.enumerations.drinkcustomizations;

public enum DrinkSize {
    SMALL("S", "Small", 4.95), MEDIUM("M", "Medium", 5.95), LARGE("L", "Large", 6.95);

    private final String abbreviation;
    private final String name;
    private final double price;

    DrinkSize(String abbreviation, String name, double price) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.price = price;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

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
}
