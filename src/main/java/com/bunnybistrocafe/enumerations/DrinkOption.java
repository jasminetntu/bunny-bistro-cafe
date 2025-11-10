package com.bunnybistrocafe.enumerations;

public enum DrinkOption {
    SIGNATURE(1), SEASONAL(2), CUSTOM(3);

    private final int num;

    DrinkOption(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public DrinkOption fromNum(int num) {
        // iterate through all enum values
        for (DrinkOption option : DrinkOption.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, return null
        throw new IllegalArgumentException();
    }
}
