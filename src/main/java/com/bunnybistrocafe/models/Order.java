package com.bunnybistrocafe.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Order {
    private final List<MenuItem> items;

    // *** CONSTRUCTORS ***
    public Order() {
        this.items = new ArrayList<>();
    }

    public Order(List<MenuItem> items) {
        this.items = items;
    }

    // *** GETTERS ***

    /**
     * Returns item list sorted by diff menu items (drinks, pastries, entrees)
     * @return
     */
    public List<MenuItem> getItems() {
        return items.stream()
                .sorted(new Comparator<MenuItem>() {
                    @Override
                    public int compare(MenuItem o1, MenuItem o2) {
                        return o1.getClass().getName().compareTo(o2.getClass().getName());
                    }
                })
                .toList();
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
    public boolean addItem(MenuItem item) {
        return items.add(item);
    }

    public boolean removeItem(MenuItem item) {
        return items.remove(item);
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
