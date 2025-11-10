package com.bunnybistrocafe.models;

public enum Pastry implements MenuItem {
    PLAIN_CROISSANT("PC", "Plain Croissant", 2.50), STRAWBERRY_CROISSANT("SC", "Strawberry Croissant", 6.00), 
    MANGO_CROISSANT("MC", "Mango Croissant", 6.00), BANANA_BREAD("BB", "Banana Bread", 4.00), 
    COFFEE_CAKE("CC", "Coffee Cake", 4.00), CHOCO_CHIP_COOKIE("CCC", "Chocolate-Chip Cookie", 2.00),
    FRUIT_TART("FT", "Fruit Tart", 5.00), GLAZED_DONUT("GD", "Glazed Donut", 2.00),
    STRAWBERRY_SANDO("SS", "Strawberry Sando", 8.00);

    private final String abbreviation;
    private final String name;
    private final double price;

    Pastry(String abbreviation, String name, double price) {
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

    public Pastry fromAbbreviation(String abbrev) {
        abbrev = abbrev.trim().toUpperCase();

        // iterate through all enum values
        for (Pastry option : Pastry.values()) {
            // check if input letter matches associated letter
            if (option.abbreviation.equals(abbrev)) {
                return option;
            }
        }

        // if no match is found, return null
        throw new IllegalArgumentException();
    }
}
