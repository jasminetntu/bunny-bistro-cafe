package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.ActionOption;
import com.bunnybistrocafe.models.Pastry;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class PastryScreen implements Screen {
    private final Scanner scnr;
    private final OrderManager orderManager;

    public PastryScreen(Scanner scnr, OrderManager orderManager) {
        this.scnr = scnr;
        this.orderManager = orderManager;
    }

    @Override
    public void displayScreen() {
        boolean isRunning = true;
        Pastry pastryChoice;

        while (isRunning) {
            UserInterface.printPastryMenu();
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
                    pastryChoice = Pastry.fromNum(Integer.parseInt(input));
                    boolean success = orderManager.addItemToOrder(pastryChoice);

                    if (success) {
                        System.out.println(pastryChoice.getName() + " was added to your order.");
                    } else {
                        System.out.println("Something went wrong when adding to order.");
                    }

                    UserInterface.waitForKey(scnr);
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Invalid input. Must be 1-9 or R.");
                }
            }
        }
    }
}
