package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.controllers.DrinkCustomizer;
import com.bunnybistrocafe.controllers.OrderManager;
import com.bunnybistrocafe.enumerations.DrinkOption;
import com.bunnybistrocafe.enumerations.ActionOption;
import com.bunnybistrocafe.enumerations.SignatureDrinkOption;
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
                            getSignatureDrink();
                            UserInterface.waitForKey(scnr);
                        }
                        case CUSTOM -> {
                            getCustomDrink();
                        }
                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid input. Must be 1-3 or R.");
                }
            } //end else
        } //end while
    } //end method

    // *** HELPERS ***
    private void getCustomDrink() {
        DrinkCustomizer drinkCustomizer = new DrinkCustomizer(scnr);
        Drink drink = drinkCustomizer.customizeDrink();

        if (drink != null) {
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

    //todo
    private void getSignatureDrink() {
        boolean valid = false;
        boolean success = false;
        String input = "";
        SignatureDrinkOption signatureDrinkOption = null;

        UserInterface.printSignatureDrinkMenu();

        //get signature drink choice
        while (!valid) {
            System.out.print("> Enter choice: ");
            input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                return;
            }

            try {
                signatureDrinkOption = SignatureDrinkOption.fromNum(Integer.parseInt(input));
                valid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid choice. Must be 1-26.");
            }
        }

        //ask to customize
        valid = false;
        while (!valid) {
            System.out.print("> Would you like to customize your drink? (Y/N): ");
            input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("Y")) {
                DrinkCustomizer dc = new DrinkCustomizer(scnr);
                Drink customizedDrink = dc.customizeSignatureDrink(signatureDrinkOption.getDrink());
                if (customizedDrink != null) {
                    success = orderManager.addItemToOrder(customizedDrink);

                    if (success) {
                        System.out.printf("%s %s was added to your order.%n",
                                customizedDrink.getSize().getName(), customizedDrink.getType().getName());
                    } else {
                        System.out.println("Something went wrong when adding to order.");
                    }
                }

                UserInterface.waitForKey(scnr);
                valid = true;
            }
            else if (input.equalsIgnoreCase("N")) {
                success = orderManager.addItemToOrder(signatureDrinkOption.getDrink());

                if (success) {
                    System.out.printf("%s %s was added to your order.%n",
                            signatureDrinkOption.getDrink().getSize().getName(), signatureDrinkOption.getDrink().getType().getName());
                } else {
                    System.out.println("Something went wrong when adding to order.");
                }

                UserInterface.waitForKey(scnr);
                valid = true;
            }
            else {
                System.out.println("Invalid choice. Please enter Y or N.");
            }
        }
    }

}
