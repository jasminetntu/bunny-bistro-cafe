package com.bunnybistrocafe.models;

public enum Entree implements MenuItem {
    EGG_SANDO (1, "Egg Sando", 7.00), HOUSE_SALAD (2, "House Salad", 10.00),
    CHICKEN_KATSU_SANDO (3, "Chicken Katsu Sando", 12.50), SAVORY_CREPE (4, "Savory Crepe", 15.00);

    private final int num;
    private final String name;
    private final double price;

    /**
     * Constructs an entree with a menu number, display name, and price.
     *
     * @param num   the numeric ID associated with this entree
     * @param name  the display name shown on menus
     * @param price the base price of the entree
     */
    Entree(int num, String name, double price) {
        this.num = num;
        this.name = name;
        this.price = price;
    }

    /**
     * Returns the numeric value for this entree.
     *
     * @return the entree menu number
     */
    public int getNum() {
        return num;
    }

    /**
     * Returns the display name of this entree.
     *
     * @return the entree name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the price of this entree.
     *
     * @return the entree price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * Returns the entree option corresponding to the provided menu number.
     *
     * @param num the numeric ID of the desired entree
     * @return the matching {@code Entree}
     * @throws IllegalArgumentException if the number does not match any entree
     */
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

    /**
     * Returns the display category order used for sorting menu items.
     * Entrees are 2 (third / last).
     *
     * @return the category order integer
     */
    @Override
    public int getCategoryOrder() {
        return 2;
    }

    /**
     * Returns a Receipt string representation with price.
     *
     * @return formatted entree information with aligned name and price
     */
    @Override
    public String toString() {
        return String.format("   %-36s$%.2f", name, price);
    }

    /**
     * Returns a shorter string representation used for order summaries.
     *
     * @return the entree name
     */
    @Override
    public String toShortString() {
        return name;
    }
}
