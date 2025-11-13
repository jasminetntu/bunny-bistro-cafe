package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.DrinkCustomizer;
import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.DrinkOption;
import com.bunnybistrocafe.enumerations.ActionOption;
import com.bunnybistrocafe.models.Drink;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class DrinkScreen implements Screen {
    private final Scanner scnr;
    private final OrderManager orderManager;

    public DrinkScreen(Scanner scnr, OrderManager orderManager) {
        this.scnr = scnr;
        this.orderManager = orderManager;
    }

    @Override
    public void displayScreen() {
        boolean isRunning = true;
        DrinkOption drinkChoice;

        while (isRunning) {
            UserInterface.printHomeMenu();
            String input = scnr.nextLine().trim();

            // go back to previous screen if R
            if (ActionOption.RETURN.getAbbreviation().equalsIgnoreCase(input)) {
                isRunning = false;
            }
            else { // compare w drink options
                try {
                    drinkChoice = DrinkOption.fromNum(Integer.parseInt(input));

                    switch (drinkChoice) {
                        case SIGNATURE -> {
                            System.out.println("Signatures TBA.");
                        }
                        case SEASONAL -> {
                            System.out.println("Seasonals TBA.");
                        }
                        case CUSTOM -> {
                            DrinkCustomizer drinkCustomizer = new DrinkCustomizer(scnr);
                            orderManager.addItemToOrder(drinkCustomizer.customizeDrink());
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Must be N or X.");
                }
            }
        }
    }
}
