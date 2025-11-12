package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.OrderOption;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class OrderScreen implements Screen {
    private final Scanner scnr;
    private final OrderManager orderManager;

    public OrderScreen(Scanner scnr) {
        this.scnr = scnr;
        this.orderManager = new OrderManager();
    }

    @Override
    public void displayScreen() {
        boolean isRunning = true;
        OrderOption orderChoice;

        while (isRunning) {
            UserInterface.printHomeMenu();

            try {
                orderChoice = OrderOption.fromNum(Integer.parseInt(scnr.nextLine()));

                switch (orderChoice) {
                    case ADD_DRINK -> {
                        DrinkScreen ds = new DrinkScreen(scnr);
                        ds.displayScreen();
                    }
                    case ADD_PASTRY -> {
                        PastryScreen ps = new PastryScreen(scnr);
                        ps.displayScreen();
                    }
                    case ADD_ENTREE -> {
                        EntreeScreen es = new EntreeScreen(scnr);
                        es.displayScreen();
                    }
                    case VIEW_ORDER_SUMMARY -> {
                        //tba
                    }
                    case CHECKOUT -> {
                        CheckoutScreen cs = new CheckoutScreen();
                        cs.displayScreen(scnr);
                    }
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Input must be numeric.");
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Must be 1-5 or R.");
            }
        }
    }
}
