package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.ActionOption;
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
            UserInterface.printOrderMenu();
            String input = scnr.nextLine().trim();

            // go back to previous screen if R
            if (ActionOption.RETURN.getAbbreviation().equalsIgnoreCase(input)) {
                isRunning = false;
            }
            else { // compare w order options
                try {
                    orderChoice = OrderOption.fromNum(Integer.parseInt(input));

                    switch (orderChoice) {
                        case ADD_DRINK -> {
                            DrinkScreen ds = new DrinkScreen(scnr, orderManager);
                            ds.displayScreen();
                        }
                        case ADD_PASTRY -> {
                            PastryScreen ps = new PastryScreen(scnr, orderManager);
                            ps.displayScreen();
                        }
                        case ADD_ENTREE -> {
                            EntreeScreen es = new EntreeScreen(scnr, orderManager);
                            es.displayScreen();
                        }
                        case VIEW_ORDER_SUMMARY -> {
                            //todo
                        }
                        case CHECKOUT -> {
                            CheckoutScreen cs = new CheckoutScreen(scnr, orderManager);
                            cs.displayScreen();
                        }
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Input must be numeric.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Must be 1-5 or R.");
                }
            }
        }
    }
}
