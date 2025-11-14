package com.bunnybistrocafe.enumerations.drinkcustomizations;

/**
 * Represents flavor add-ins for teas, each with a numeric code and display name.
 */
public enum TeaFlavor {
    STRAWBERRY(1, "Strawberry"), MANGO(2, "Mango"), PASSIONFRUIT(3, "Passionfruit"),
    PEACH(4, "Peach"), LYCHEE(5, "Lychee"), WATERMELON(6, "Watermelon"),
    WINTERMELON(7, "Wintermelon");

    private final int num;
    private final String name;

    /**
     * Constructs a TeaFlavor enum instance.
     *
     * @param num numeric menu option
     * @param name display name of the flavor
     */
    TeaFlavor(int num, String name) {
        this.num = num;
        this.name = name;
    }

    /**
     * Returns the number of this tea flavor.
     *
     * @return numeric ID
     */
    public int getNum() {
        return num;
    }

    /**
     * Returns the display name of this tea flavor.
     *
     * @return flavor name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the additional cost for adding this flavor.
     *
     * @return price of flavor
     */
    public double getPrice() {
        return 0.25;
    }

    /**
     * Converts a number into the corresponding TeaFlavor enum value.
     *
     * @param num numeric ID
     * @return matching TeaFlavor
     * @throws IllegalArgumentException if input number does not match any flavor
     */
    public static TeaFlavor fromNum(int num) {
        // iterate through all enum values
        for (TeaFlavor option : TeaFlavor.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }

    /**
     * Returns the display name of this flavor.
     *
     * @return flavor name
     */
    @Override
    public String toString() {
        return name;
    }
}
