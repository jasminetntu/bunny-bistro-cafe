package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.ActionOption;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class CheckoutScreen implements Screen {
    private final Scanner scnr;
    private final OrderManager orderManager;
    private boolean backToHome; // indicates whether to return to home screen after checkout.

    /**
     * Constructs a CheckoutScreen with the given scanner and order manager.
     *
     * @param scnr the {@link Scanner} for user input
     * @param orderManager the {@link OrderManager} handling the order
     */
    public CheckoutScreen(Scanner scnr, OrderManager orderManager) {
        this.scnr = scnr;
        this.orderManager = orderManager;
        this.backToHome = true;
    }

    /**
     * Returns whether the screen should return to the home screen after checkout.
     *
     * @return true if returning to home, false if returning to order
     */
    public boolean isBackToHome() {
        return backToHome;
    }

    /**
     * Displays the checkout screen to the user.
     * Shows the receipt and prompts the user to confirm, cancel, or return.
     * Processes the selected {@link ActionOption} accordingly.
     */
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
                    case CONFIRM -> orderManager.checkout();
                    case CANCEL -> orderManager.cancelOrder();
                    case RETURN -> this.backToHome = false;
                }

                isRunning = false;
            } catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid input. Must be Y or N or R.");
            }
        }
    }
}
