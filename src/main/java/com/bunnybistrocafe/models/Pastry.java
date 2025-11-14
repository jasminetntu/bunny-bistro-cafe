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

    /**
     * Constructor for Pastry enum.
     *
     * @param num   unique identifier
     * @param name  display name
     * @param price price of the pastry
     */
    Pastry(int num, String name, double price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the unique number assigned to the pastry.
     *
     * @return the pastry number
     */
    public int getNum() {
        return num;
    }

    /**
     * Returns the name of the pastry.
     *
     * @return the pastry name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of the pastry.
     *
     * @return the pastry price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Returns the Pastry enum corresponding to the given number.
     *
     * @param num the unique number of the pastry
     * @return the matching {@link Pastry} enum
     * @throws IllegalArgumentException if no matching pastry is found
     */
    public static Pastry fromNum(int num) {
        // iterate through all enum values
        for (Pastry option : Pastry.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, throws exception
        throw new IllegalArgumentException();
    }

    /**
     * Returns the category order for sorting purposes.
     * Pastries have a category order of 1 (second).
     *
     * @return category order
     */
    @Override
    public int getCategoryOrder() {
        return 1;
    }

    /**
     * Returns a Receipt string representation of the pastry with price.
     *
     * @return formatted string
     */
    @Override
    public String toString() {
        return String.format("   %-36s$%.2f", name, price);
    }

    /**
     * Returns a short string representation of the pastry (name only).
     *
     * @return short string
     */
    @Override
    public String toShortString() {
        return name;
    }
}
