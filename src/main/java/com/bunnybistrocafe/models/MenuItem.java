package com.bunnybistrocafe.models;

public interface MenuItem {
    double getPrice();
    String toString();

    default String toShortString() {
        return toString();
    }
}
