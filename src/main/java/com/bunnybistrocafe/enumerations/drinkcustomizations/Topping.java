package com.bunnybistrocafe.enumerations.drinkcustomizations;

public enum Topping {
    //regular toppings
    BOBA(1, "Boba", false), CRYSTAL_BOBA(2, "Crystal Boba", false), ALOE_VERA(3, "Aloe Vera", false), 
    GRASS_JELLY(4, "Grass Jelly", false), LYCHEE_JELLY(5, "Lychee Jelly", false), STRAWBERRY_BITS(6, "Strawberry Bits", false),
    MANGO_CHUNKS(7, "Mango Chunks", false), LYCHEE_BITS(8, "Lychee Bits", false), PEACH_BITS(9, "Peach Bits", false),
    WATERMELON_CHUNKS(10, "Watermelon Chunks", false),
    //premium toppings
    CREAM_TOP(11, "Cream Top", true), TARO_CHUNKS(12, "Taro Chunks", true),
    RED_BEAN_PASTE(13, "Red Bean Paste", true), CREME_BRULEE(14, "Creme Brulee", true);

    private final int num;
    private final String name;
    private final boolean isPremium;

    Topping(int num, String name, boolean isPremium) {
        this.num = num;
        this.name = name;
        this.isPremium = isPremium;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public boolean isPremium() {
        return isPremium;
    }

    public double getPrice() {
        if (isPremium) { //premium
            return 1.00;
        } else { //regular
            return 0.75;
        }
    }

    public static Topping fromNum(int num) {
        // iterate through all enum values
        for (Topping option : Topping.values()) {
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
