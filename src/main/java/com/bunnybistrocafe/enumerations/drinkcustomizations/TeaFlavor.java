package com.bunnybistrocafe.enumerations.drinkcustomizations;

public enum TeaFlavor {
    STRAWBERRY(1, "Strawberry"), MANGO(2, "Mango"), PASSIONFRUIT(3, "Passionfruit"),
    PEACH(4, "Peach"), LYCHEE(5, "Lychee"), WATERMELON(6, "Watermelon"),
    WINTERMELON(7, "Wintermelon");

    private final int num;
    private final String name;

    TeaFlavor(int num, String name) {
        this.num = num;
        this.name = name;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return 0.25;
    }

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

    @Override
    public String toString() {
        return name;
    }
}
