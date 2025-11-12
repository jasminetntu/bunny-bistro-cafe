package com.bunnybistrocafe.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Order {
    private List<MenuItem> items;

    // *** CONSTRUCTORS ***
    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(List<MenuItem> items) {
        this.items = items;
    }

    // *** GETTERS ***
    public List<MenuItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public int getNumItems() {
        return items.size();
    }

    public int getNumDrinks() {
        int count = 0;
        for (MenuItem item : items) {
            if (item instanceof Drink) {
                count++;
            }
        }
        return count;
    }

    public int getNumPastries() {
        int count = 0;
        for (MenuItem item : items) {
            if (item instanceof Pastry) {
                count++;
            }
        }
        return count;
    }

    public int getNumEntrees() {
        int count = 0;
        for (MenuItem item : items) {
            if (item instanceof Entree) {
                count++;
            }
        }
        return count;
    }

    // *** SETTERS ***
    public void addItem(MenuItem item) {
        items.add(item);
    }

    public void removeItem(MenuItem item) {
        items.remove(item);
    }

    // *** OTHER ***
    public double calculateSubtotal() {
        double subtotal = 0;
        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    public double calculateTax(double taxPercent) {
        return calculateSubtotal() * taxPercent;
    }

    public double calculateTotal(double taxPercent) {
        return calculateSubtotal() + calculateTax(taxPercent);
    }
}
