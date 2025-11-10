package com.bunnybistrocafe.enumerations.drinkcustomizations;

public enum DrinkType {
    MATCHA("M", "Matcha Latte", 1.50), COFFEE("C", "Caffe Latte", 1.00),
    MILK_TEA("MT", "Milk Tea", 0.00), TEA("T", "Tea", 0.00);

    private final String abbreviation;
    private final String name;
    private final double price;

    DrinkType(String abbreviation, String name, double price) {
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

    public DrinkType fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (DrinkType option : DrinkType.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, return null
        throw new IllegalArgumentException();
    }
}
