package com.bunnybistrocafe.models;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a customer order containing multiple {@link MenuItem} objects.
 * Supports adding, removing, and retrieving items as well as calculating
 * subtotal, tax, and total.
 */
public class Order {
    private final List<MenuItem> items;

    // *** CONSTRUCTORS ***

    /**
     * Initializes an empty order with no items.
     */
    public Order() {
        this.items = new ArrayList<>();
    }

    /**
     * Constructor with an initial list of menu items.
     *
     * @param items the initial list of items in the order
     */
    public Order(List<MenuItem> items) {
        this.items = items;
    }

    // *** GETTERS ***

    /**
     * Returns a sorted list of items sorted by category in the following order:
     * Drinks -> Pastries -> Entrees.
     *
     * @return a sorted list of {@link MenuItem} objects
     */
    public List<MenuItem> getItems() {
        return items.stream()
                .sorted(Comparator.comparingInt(MenuItem::getCategoryOrder))
                .toList();
    }

    /**
     * Returns the total number of items in the order.
     *
     * @return number of items
     */
    public int getNumItems() {
        return items.size();
    }

    /**
     * Returns the number of drinks in the order.
     *
     * @return number of {@link Drink} items
     */
    public int getNumDrinks() {
        int count = 0;
        for (MenuItem item : items) {
            if (item instanceof Drink) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the number of pastries in the order.
     *
     * @return number of {@link Pastry} items
     */
    public int getNumPastries() {
        int count = 0;
        for (MenuItem item : items) {
            if (item instanceof Pastry) {
                count++;
            }
        }
        return count;
    }

    /**
     * Returns the number of entrees in the order.
     *
     * @return number of {@link Entree} items
     */
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
    /**
     * Adds a {@link MenuItem} to the order.
     *
     * @param item the item to add
     * @return true if the item was successfully added
     */
    public boolean addItem(MenuItem item) {
        return items.add(item);
    }

    /**
     * Removes a {@link MenuItem} from the order.
     *
     * @param item the item to remove
     * @return true if the item was successfully removed
     */
    public boolean removeItem(MenuItem item) {
        return items.remove(item);
    }

    // *** OTHER ***

    /**
     * Calculates the subtotal of the order by summing the prices of all items.
     *
     * @return the subtotal amount
     */
    public double calculateSubtotal() {
        double subtotal = 0;
        for (MenuItem item : items) {
            subtotal += item.getPrice();
        }
        return subtotal;
    }

    /**
     * Calculates the tax on the order based on the given tax percentage.
     *
     * @param taxPercent the tax rate as a decimal (e.g., 0.09 for 9%)
     * @return the calculated tax amount
     */
    public double calculateTax(double taxPercent) {
        return calculateSubtotal() * taxPercent;
    }

    /**
     * Calculates the total cost of the order including tax.
     *
     * @param taxPercent the tax rate as a decimal (e.g., 0.09 for 9%)
     * @return the total amount of the order
     */
    public double calculateTotal(double taxPercent) {
        return calculateSubtotal() + calculateTax(taxPercent);
    }
}
