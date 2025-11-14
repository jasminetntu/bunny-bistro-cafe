package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.ActionOption;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class CheckoutScreen implements Screen {
    private final Scanner scnr;
    private final OrderManager orderManager;
    private boolean backToHome;

    public CheckoutScreen(Scanner scnr, OrderManager orderManager) {
        this.scnr = scnr;
        this.orderManager = orderManager;
        this.backToHome = true;
    }

    public boolean isBackToHome() {
        return backToHome;
    }

    @Override
    public void displayScreen() {
        boolean isRunning = true;
        ActionOption checkoutChoice;

        orderManager.printReceipt();

        while (isRunning) {
            try {
                UserInterface.printCheckoutMenu();
                checkoutChoice = ActionOption.fromAbbreviation(scnr.nextLine());

                switch (checkoutChoice) {
                    case CONFIRM -> {
                        orderManager.checkout();
                    }
                    case CANCEL -> {
                        orderManager.cancelOrder();
                    }
                    case RETURN -> {
                        this.backToHome = false;
                    }
                }

                isRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid input. Must be Y or N or R.");
            }
        }
    }
}
