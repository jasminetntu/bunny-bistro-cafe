package com.bunnybistrocafe.controllers;

import com.bunnybistrocafe.models.MenuItem;
import com.bunnybistrocafe.models.Order;
import com.bunnybistrocafe.util.ReceiptWriter;

import java.io.IOException;
import java.util.stream.Collectors;

public class OrderManager {
    private Order order;

    public OrderManager() {
        order = new Order();
    }

    public void cancelOrder() {
        order = new Order();
    }

    public int getNumItems() {
        return order.getNumItems();
    }

    public void printReceipt() {
        ReceiptWriter rw = new ReceiptWriter();
        System.out.println("\n" + rw.getReceipt(order));
    }

    public void checkout() {
        ReceiptWriter rw = new ReceiptWriter();

        try {
            rw.writeToTxtFile(order);
        } catch (IOException e) {
            System.out.println("ERROR: Something went wrong when writing receipt to .txt file.");
        }
    }

    public boolean addItemToOrder(MenuItem item) {
        return order.addItem(item);
    }

    public boolean removeItemFromOrder(MenuItem item) {
        return order.removeItem(item);
    }

    public void viewOrder() {
        String orderStr = order.getItems().stream()
                .map(MenuItem::toShortString) // convert each item to its short string
                .collect(Collectors.joining("\n> "));

        orderStr = "> " + orderStr; //add missing bullet pt to beginning
        System.out.println("\n•·······················•·······················•" +
                "\nOrder Overview:\n" +
                orderStr +
                "\n•·······················•·······················•");
    }
}
