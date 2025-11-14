package com.bunnybistrocafe.controllers;

import com.bunnybistrocafe.models.MenuItem;
import com.bunnybistrocafe.models.Order;
import com.bunnybistrocafe.util.ReceiptWriter;

import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Manages the user's current order by delegating add/remove operations,
 * printing receipts, and handling checkout logic.
 */
public class OrderManager {
    private Order order;

    /**
     * Creates a new OrderManager with an empty order.
     */
    public OrderManager() {
        order = new Order();
    }

    /**
     * Cancels the current order and replaces it with a new, empty one.
     */
    public void cancelOrder() {
        order = new Order();
    }

    /**
     * Returns the number of items currently in the active order.
     *
     * @return the number of items in the order
     */
    public int getNumItems() {
        return order.getNumItems();
    }

    /**
     * Prints a formatted receipt of the current order to the console.
     * Uses {@link ReceiptWriter#getReceipt(Order)} to generate the receipt string.
     */
    public void printReceipt() {
        ReceiptWriter rw = new ReceiptWriter();
        System.out.println("\n" + rw.getReceipt(order));
    }

    /**
     * Finalizes the checkout process by writing the order receipt
     * to a .txt file inside the receipts folder.
     * Prints an error message if the file cannot be written.
     */
    public void checkout() {
        ReceiptWriter rw = new ReceiptWriter();

        try {
            rw.writeToTxtFile(order);
        } catch (IOException e) {
            System.out.println("ERROR: Something went wrong when writing receipt to .txt file.");
        }
    }

    /**
     * Adds a {@link MenuItem} to the current order.
     *
     * @param item the item to add
     * @return true if the item was successfully added, false otherwise
     */
    public boolean addItemToOrder(MenuItem item) {
        return order.addItem(item);
    }

    /**
     * Removes a {@link MenuItem} from the current order.
     *
     * @param item the item to remove
     * @return true if the item was successfully removed, false otherwise
     */
    public boolean removeItemFromOrder(MenuItem item) {
        return order.removeItem(item);
    }

    /**
     * Displays the current order in a formatted list,
     * showing each item's short description.
     */
    public void viewOrder() {
        String orderStr = order.getItems().stream()
                .map(MenuItem::toShortString) // convert each item to its short string
                .collect(Collectors.joining("\n> "));

        orderStr = "> " + orderStr; //add missing bullet pt to beginning
        System.out.println("\n•·······················•·······················•·······················•·······················•" +
                "\nOrder Overview:\n" +
                orderStr +
                "\n•·······················•·······················•·······················•·······················•");
    }
}
