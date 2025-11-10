package com.bunnybistrocafe.models;

public enum Entree implements MenuItem {
    EGG_SANDO ("ES", "Egg Sando", 7.00), HOUSE_SALAD ("HS", "House Salad", 10.00),
    CHICKEN_KATSU_SANDO ("CKS", "Chicken Katsu Sando", 12.50), SAVORY_CREPE ("SC", "Savory Crepe", 15.00);

    private final String abbreviation;
    private final String name;
    private final double price;

    Entree(String abbreviation, String name, double price) {
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

    @Override
    public double getPrice() {
        return price;
    }

    public Entree fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (Entree option : Entree.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, return null
        throw new IllegalArgumentException();
    }
}
