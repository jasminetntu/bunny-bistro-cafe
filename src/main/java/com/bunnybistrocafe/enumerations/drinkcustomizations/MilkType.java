package com.bunnybistrocafe.enumerations.drinkcustomizations;

public enum MilkType {
    WHOLE("W", "Whole Milk", 0.00), OAT("O", "Oat Milk", 0.50),
    ALMOND("A", "Almond Milk", 0.50), NONDAIRY ("ND", "Non-dairy Creamer", 0.00);

    private final String abbreviation;
    private final String name;
    private final double price;

    MilkType(String abbreviation, String name, double price) {
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
}
