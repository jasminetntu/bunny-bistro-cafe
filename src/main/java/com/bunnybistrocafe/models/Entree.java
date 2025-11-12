package com.bunnybistrocafe.models;

public enum Entree implements MenuItem {
    EGG_SANDO (1, "Egg Sando", 7.00), HOUSE_SALAD (2, "House Salad", 10.00),
    CHICKEN_KATSU_SANDO (3, "Chicken Katsu Sando", 12.50), SAVORY_CREPE (4, "Savory Crepe", 15.00);

    private final int num;
    private final String name;
    private final double price;

    Entree(int num, String name, double price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    public static Entree fromNum(int num) {
        // iterate through all enum values
        for (Entree option : Entree.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, throws exception
        throw new IllegalArgumentException();
    }
}
