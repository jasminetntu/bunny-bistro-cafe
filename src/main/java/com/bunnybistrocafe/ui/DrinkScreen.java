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
            UserInterface.printDrinkMenu();
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
            else { // compare w drink options
                try {
                    drinkChoice = DrinkOption.fromNum(Integer.parseInt(input));

                    switch (drinkChoice) {
                        case SIGNATURE -> {
                            System.out.println("Signatures TBA.");
                            UserInterface.waitForKey(scnr);
                            //todo
                        }
                        case SEASONAL -> {
                            System.out.println("Seasonals TBA.");
                            UserInterface.waitForKey(scnr);
                            //todo
                        }
                        case CUSTOM -> {
                            DrinkCustomizer drinkCustomizer = new DrinkCustomizer(scnr);
                            Drink drink = drinkCustomizer.customizeDrink();
                            boolean success = orderManager.addItemToOrder(drink);

                            if (success) {
                                System.out.printf("%s %s was added to your order.%n",
                                        drink.getSize().getName(), drink.getType().getName());
                            } else {
                                System.out.println("Something went wrong when adding to order.");
                            }

                            UserInterface.waitForKey(scnr);
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Must be 1-3 or R.");
                }
            } //end else
        } //end while
    } //end method

}
