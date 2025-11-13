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
                isRunning = false;
            }
            else { // compare w pastry options
                try {
                    pastryChoice = Pastry.fromNum(Integer.parseInt(input));

                    //todo: add to order here
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Must be N or X.");
                }
            }
        }
    }
}
