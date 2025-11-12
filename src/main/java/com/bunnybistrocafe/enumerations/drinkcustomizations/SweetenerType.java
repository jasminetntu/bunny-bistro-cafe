package com.bunnybistrocafe.enumerations.drinkcustomizations;

public enum SweetenerType {
    CANE_SUGAR("C", "Cane Sugar", 0.00), STEVIA("S", "Stevia", 0.00),
    HONEY("H", "Honey", 0.50);

    private final String abbreviation;
    private final String name;
    private final double price;

    SweetenerType(String abbreviation, String name, double price) {
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

    public static SweetenerType fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (SweetenerType option : SweetenerType.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}

