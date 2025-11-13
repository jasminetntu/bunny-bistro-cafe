package com.bunnybistrocafe.models;

public interface MenuItem {
    double getPrice();
    String toString();
    int getCategoryOrder();

    default String toShortString() {
        return toString();
    }
}
