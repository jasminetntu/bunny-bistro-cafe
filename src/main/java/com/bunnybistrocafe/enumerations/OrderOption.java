package com.bunnybistrocafe.enumerations;

public enum OrderOption {
    ADD_DRINK(1), ADD_PASTRY(2), ADD_ENTREE(3), VIEW_ORDER_SUMMARY(4), CHECKOUT(5);

    private final int num;

    OrderOption(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public static OrderOption fromNum(int num) {
        // iterate through all enum values
        for (OrderOption option : OrderOption.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}
