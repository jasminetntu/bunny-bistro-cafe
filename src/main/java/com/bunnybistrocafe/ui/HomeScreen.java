package com.bunnybistrocafe.ui;

import com.bunnybistrocafe.enumerations.HomeOption;
import com.bunnybistrocafe.util.UserInterface;

import java.util.Scanner;

public class HomeScreen implements Screen {
    private final Scanner scnr;

    public HomeScreen(Scanner scnr) {
        this.scnr = scnr;
    }

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
                        OrderScreen os = new OrderScreen();
                        os.displayScreen();
                    }
                    case EXIT -> {
                        isRunning = false;
                    }
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Invalid input. Must be N or X.");
            }
        }
    }

}
