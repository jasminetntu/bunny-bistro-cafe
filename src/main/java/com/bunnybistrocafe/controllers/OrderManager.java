package com.bunnybistrocafe.controllers;

import com.bunnybistrocafe.models.MenuItem;
import com.bunnybistrocafe.models.Order;

public class OrderManager {
    private Order order;

    public OrderManager() {
        order = new Order();
    }

    public void cancelOrder() {
        order = new Order();
    }

    public void checkout() {

    }

    public boolean addItemToOrder(MenuItem item) {
        return order.addItem(item);
    }

    public boolean removeItemFromOrder(MenuItem item) {
        return order.removeItem(item);
    }

    public String viewOrder() {
        return "";
    }
}
