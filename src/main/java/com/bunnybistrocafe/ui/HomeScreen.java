package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.enumerations.HomeOption;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class HomeScreen implements Screen {
    private final Scanner scnr;

    /**
     * Constructs a HomeScreen with the given scanner.
     *
     * @param scnr the {@link Scanner} for user input
     */
    public HomeScreen(Scanner scnr) {
        this.scnr = scnr;
    }

    /**
     * Displays the home screen to the user.
     * Provides options to start a new order or exit the application.
     */
    @Override
    public void displayScreen() {
        boolean isRunning = true;
        HomeOption homeChoice;

        while (isRunning) {
            UserInterface.printHomeMenu();

            try {
                homeChoice = HomeOption.fromAbbreviation(scnr.nextLine());

                switch (homeChoice) {
                    case NEW_ORDER -> {
                        UserInterface.loadingBar("🔖 Loading New Order...");
                        OrderScreen os = new OrderScreen(scnr);
                        os.displayScreen();
                    }
                    case EXIT -> isRunning = false;
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("❌ Invalid input. Must be N or X.");
            } catch (InterruptedException e) {
                System.out.println("❌ Error encountered: Interrupted exception.");
            }
        }
    }

}
