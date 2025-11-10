package com.bunnybistrocafe.enumerations;

public enum OrderOption {
    ADD_DRINK(1), ADD_FOOD_ITEM(2), CHECKOUT(3);

    private final int num;

    OrderOption(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public OrderOption fromNum(int num) {
        // iterate through all enum values
        for (OrderOption option : OrderOption.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, return null
        throw new IllegalArgumentException();
    }
}
