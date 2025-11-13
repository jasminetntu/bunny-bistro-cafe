package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.ActionOption;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class CheckoutScreen implements Screen {
    private final Scanner scnr;
    private final OrderManager orderManager;

    public CheckoutScreen(Scanner scnr, OrderManager orderManager) {
        this.scnr = scnr;
        this.orderManager = orderManager;
    }

    @Override
    public void displayScreen() {
        boolean isRunning = true;
        ActionOption checkoutChoice;

        while (isRunning) {
            UserInterface.printCheckoutMenu();

            try {
                checkoutChoice = ActionOption.fromAbbreviation(scnr.nextLine());

                switch (checkoutChoice) {
                    case CONFIRM -> {
                        //todo
                    }
                    case CANCEL -> {
                        //todo
                    }
                    case RETURN -> {
                        isRunning = false;
                    }
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Must be N or X.");
            }
        }
    }
}
