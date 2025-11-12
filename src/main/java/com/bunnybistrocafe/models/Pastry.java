package com.bunnybistrocafe.models;

public enum Pastry implements MenuItem {
    PLAIN_CROISSANT(1, "Plain Croissant", 2.50), STRAWBERRY_CROISSANT(2, "Strawberry Croissant", 6.00),
    MANGO_CROISSANT(3, "Mango Croissant", 6.00), BANANA_BREAD(4, "Banana Bread", 4.00),
    COFFEE_CAKE(5, "Coffee Cake", 4.00), CHOCO_CHIP_COOKIE(6, "Chocolate-Chip Cookie", 2.00),
    FRUIT_TART(7, "Fruit Tart", 5.00), GLAZED_DONUT(8, "Glazed Donut", 2.00),
    STRAWBERRY_SANDO(9, "Strawberry Sando", 8.00);

    private final int num;
    private final String name;
    private final double price;

    Pastry(int num, String name, double price) {
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

    public Pastry fromNum(int num) {
        // iterate through all enum values
        for (Pastry option : Pastry.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, return null
        throw new IllegalArgumentException();
    }
}
