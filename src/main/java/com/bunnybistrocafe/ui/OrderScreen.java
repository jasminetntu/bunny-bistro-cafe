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
                try {
                    UserInterface.loadingBar("🅧 Cancelling order & returning to home...");
                } catch (InterruptedException e) {
                    System.out.println("❌ Error encountered: Interrupted exception.");
                }
                isRunning = false;
            }
            else { // compare w order options
                try {
                    orderChoice = OrderOption.fromNum(Integer.parseInt(input));

                    switch (orderChoice) {
                        case ADD_DRINK -> {
                            UserInterface.loadingBar("🍵 Loading drink menu...");
                            DrinkScreen ds = new DrinkScreen(scnr, orderManager);
                            ds.displayScreen();
                        }
                        case ADD_PASTRY -> {
                            UserInterface.loadingBar("🍰 Loading pastry menu...");
                            PastryScreen ps = new PastryScreen(scnr, orderManager);
                            ps.displayScreen();
                        }
                        case ADD_ENTREE -> {
                            UserInterface.loadingBar("🥗 Loading entree menu...");
                            EntreeScreen es = new EntreeScreen(scnr, orderManager);
                            es.displayScreen();
                        }
                        case VIEW_ORDER_SUMMARY -> {
                            UserInterface.loadingBar("✏️ Loading order summary...");
                            if (orderManager.getNumItems() == 0) {
                                System.out.println("Your order is empty.");
                            } else {
                                orderManager.viewOrder();
                            }

                            UserInterface.waitForKey(scnr);
                        }
                        case CHECKOUT -> {
                            UserInterface.loadingBar("🛍️ Loading Checkout...");
                            if (orderManager.getNumItems() == 0) {
                                System.out.println("Your order is empty. Must add at least 1 item before checking out.");
                            } else {
                                CheckoutScreen cs = new CheckoutScreen(scnr, orderManager);
                                cs.displayScreen();

                                if (cs.isBackToHome()) {
                                    UserInterface.loadingBar("⮐ Confirming choice & returning to home...");
                                    isRunning = false;
                                }
                            }
                        }
                    }

                } catch (NumberFormatException e) {
                    System.out.println("❌ Input must be numeric.");
                } catch (IllegalArgumentException e) {
                    System.out.println("❌ Invalid input. Must be 1-5 or R.");
                } catch (InterruptedException e) {
                    System.out.println("❌ Error encountered: Interrupted exception.");
                }
            }
        }
    }
}
