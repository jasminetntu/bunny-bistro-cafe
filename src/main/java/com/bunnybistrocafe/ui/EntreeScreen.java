package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.ActionOption;
import com.bunnybistrocafe.models.Entree;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class EntreeScreen implements Screen {
    private final Scanner scnr;
    private final OrderManager orderManager;

    public EntreeScreen(Scanner scnr, OrderManager orderManager) {
        this.scnr = scnr;
        this.orderManager = orderManager;
    }

    @Override
    public void displayScreen() {
        boolean isRunning = true;
        Entree entreeChoice;

        while (isRunning) {
            UserInterface.printEntreeMenu();
            String input = scnr.nextLine().trim();

            // go back to previous screen if R
            if (ActionOption.RETURN.getAbbreviation().equalsIgnoreCase(input)) {
                try {
                    UserInterface.loadingBar("⮐ Returning to order...");
                } catch (InterruptedException e) {
                    System.out.println("❌ Error encountered: Interrupted exception.");
                }
                isRunning = false;
            }
            else { // compare w pastry options
                try {
                    entreeChoice = Entree.fromNum(Integer.parseInt(input));
                    boolean success = orderManager.addItemToOrder(entreeChoice);

                    if (success) {
                        System.out.println(entreeChoice.getName() + " was added to your order.");
                    } else {
                        System.out.println("Something went wrong when adding to order.");
                    }

                    UserInterface.waitForKey(scnr);
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Invalid input. Must be 1-4 or R.");
                }
            }
        }
    }
}