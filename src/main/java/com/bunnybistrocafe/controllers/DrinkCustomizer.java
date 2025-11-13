package com.bunnybistrocafe.controllers;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;
import com.bunnybistrocafe.models.*;
import com.bunnybistrocafe.util.UserInterface;

import java.util.ArrayList;
import java.util.Scanner;

public class DrinkCustomizer {
    private final Scanner scnr;

    public DrinkCustomizer(Scanner scnr) {
        this.scnr = scnr;
    }

    public Drink customizeDrink() {
        // get basics
        DrinkSize size = getSize();
        DrinkType type = getDrinkType();

        // initialize some attributes
        boolean isIced = true;
        ArrayList<CoffeeFlavor> coffeeFlavors = new ArrayList<>();
        TeaType teaType = TeaType.BLACK;
        ArrayList<TeaFlavor> teaFlavors = new ArrayList<>();
        double iceLevel = 1;
        MilkType milk = MilkType.WHOLE;

        // get customized attributes
        if (type == DrinkType.MATCHA || type == DrinkType.COFFEE) {
            isIced = getIcedOrHot();
        }

        if (type == DrinkType.COFFEE) {
            coffeeFlavors = getCoffeeFlavors();
        }

        if (type == DrinkType.MILK_TEA || type == DrinkType.TEA) {
            teaType = getTeaType();
            teaFlavors = getTeaFlavors();
        }

        SweetenerType sweetener = getSweetenerType();
        double sweetnessLevel = getSweetnessLevel();

        if (isIced) {
            iceLevel = getIceLevel();
        }

        if (type != DrinkType.TEA) {
            milk = getMilkType();
        }

        ArrayList<Topping> toppings = getToppings();

        boolean hasPlushie = getHasPlushie();

        // create drinks based on type
        if (type == DrinkType.MATCHA) {
            return new Matcha(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, milk);
        }
        else if (type == DrinkType.COFFEE) {
            return new Coffee(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, milk, coffeeFlavors);
        }
        else if (type == DrinkType.MILK_TEA) {
            return new MilkTea(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, teaType, milk, teaFlavors);
        }
        else { //tea
            return new Tea(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, teaType, teaFlavors);
        }
    }

    // *** PRIVATE HELPERS ***

    private DrinkSize getSize() {
        DrinkSize size = null;
        boolean valid = false;
        
        UserInterface.printSizeOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            try {
                size = DrinkSize.fromAbbreviation(scnr.nextLine());
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid size (S, M, L). Please try again.");
            }
        }
        
        return size;
    }

    private DrinkType getDrinkType() {
        DrinkType type = null;
        boolean valid = false;

        UserInterface.printDrinkTypeOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            try {
                type = DrinkType.fromAbbreviation(scnr.nextLine());
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid drink (M, C, MT, T). Please try again.");
            }
        }

        return type;
    }

    private TeaType getTeaType() {
        TeaType teaType = null;
        boolean valid = false;

        UserInterface.printTeaTypeOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            try {
                teaType = TeaType.fromAbbreviation(scnr.nextLine());
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid tea (B, G, O, T, W). Please try again.");
            }
        }

        return teaType;
    }

    private ArrayList<TeaFlavor> getTeaFlavors() {
        ArrayList<TeaFlavor> teaFlavors = new ArrayList<>();;
        boolean valid = false;

        UserInterface.printTeaFlavorOptions();

        while (!valid) {
            teaFlavors.clear(); // reset arraylist

            System.out.print("> Enter flavor(s): ");
            String[] flavorNumbers = scnr.nextLine().trim().split(",");
            valid = true; //assume input is valid

            // error if user inputs more than max allowed
            if (flavorNumbers.length > 3) {
                System.out.println("You cannot have more than 3 flavors. Please try again.");
            }
            else {
                // iterate through each flavor
                for (String num : flavorNumbers) {
                    try {
                        // add each flavor to arraylist if valid
                        teaFlavors.add(TeaFlavor.fromNum(Integer.parseInt(num.trim())));
                    }
                    catch (NumberFormatException e) { // non-integer input
                        System.out.println("Input must be an integer.");
                        valid = false;
                    }
                    catch (IllegalArgumentException e) { //integer out of bounds
                        System.out.println("Not a valid flavor number (1-7). Please try again.");
                        valid = false;
                    }

                    // if any invalid input, clear list -> ensures any invalid num means entire input is invalid
                    if (!valid) {
                        teaFlavors.clear();
                    }
                } // end for
            } // end else
        } //end while

        return teaFlavors;
    }

    private boolean getIcedOrHot() {
        boolean isIced = true;
        boolean valid = false;

        UserInterface.printIcedOrHotOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            String choice = scnr.nextLine().trim();

            if (choice.equalsIgnoreCase("I")) {
                valid = true;
            }
            else if (choice.equalsIgnoreCase("H")) {
                isIced = false;
                valid = true;
            }
            else {
                System.out.println("Must be I or H. Please try again.");
            }
        }

        return isIced;
    }

    private ArrayList<CoffeeFlavor> getCoffeeFlavors() {
        ArrayList<CoffeeFlavor> coffeeFlavors = new ArrayList<>();;
        boolean valid = false;

        UserInterface.printCoffeeFlavorOptions();

        while (!valid) {
            coffeeFlavors.clear(); // reset arraylist

            System.out.print("> Enter flavor(s): ");
            String[] flavorAbbrevs = scnr.nextLine().trim().split(",");
            valid = true; //assume input is valid

            // error if user inputs more than max allowed
            if (flavorAbbrevs.length > 3) {
                System.out.println("You cannot have more than 3 flavors. Please try again.");
            }
            else {
                // iterate through each flavor
                for (String abbrev : flavorAbbrevs) {
                    try {
                        // add each flavor to arraylist if valid
                        coffeeFlavors.add(CoffeeFlavor.fromAbbreviation(abbrev));
                    }
                    catch (IllegalArgumentException e) { //invalid abbrev
                        System.out.println("Not a valid flavor (M, C, V). Please try again.");
                        valid = false;
                    }

                    // if any invalid input, clear list -> ensures any invalid num means entire input is invalid
                    if (!valid) {
                        coffeeFlavors.clear();
                    }
                } // end for
            } // end else
        } //end while

        return coffeeFlavors;
    }

    private SweetenerType getSweetenerType() {
        SweetenerType sweetener = null;
        boolean valid = false;

        UserInterface.printSweetenerTypeOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            try {
                sweetener = SweetenerType.fromAbbreviation(scnr.nextLine());
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid sweetener (C, S, H). Please try again.");
            }
        }

        return sweetener;
    }

    private double getSweetnessLevel() {
        double sweetnessLevel = 1;
        boolean valid = false;

        UserInterface.printSweetnessLevelOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            try {
                sweetnessLevel = Double.parseDouble(scnr.nextLine());

                for (int level = 0; level <= 125; level += 25) {
                    if (sweetnessLevel == level) {
                        sweetnessLevel /= 100;
                        valid = true;
                    }
                }

                if (!valid) {
                    System.out.println("Must be one of the 5 integers. Please try again.");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Must be an integer (0-125). Please try again.");
            }
        }

        return sweetnessLevel;
    }

    private double getIceLevel() {
        double iceLevel = 1;
        boolean valid = false;

        UserInterface.printIceLevelOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            try {
                iceLevel = Double.parseDouble(scnr.nextLine());

                for (int level = 0; level <= 125; level += 25) {
                    if (iceLevel == level) {
                        iceLevel /= 100;
                        valid = true;
                    }
                }

                if (!valid) {
                    System.out.println("Must be one of the 5 integers. Please try again.");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Must be an integer (0-125). Please try again.");
            }
        }

        return iceLevel;
    }

    private MilkType getMilkType() {
        MilkType milkType = null;
        boolean valid = false;

        UserInterface.printMilkTypeOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            try {
                milkType = MilkType.fromAbbreviation(scnr.nextLine());
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid milk (W, N, O, A). Please try again.");
            }
        }

        return milkType;
    }

    private ArrayList<Topping> getToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();;
        boolean valid = false;

        UserInterface.printTeaFlavorOptions();

        while (!valid) {
            toppings.clear(); // reset arraylist

            System.out.print("> Enter flavor(s): ");
            String[] toppingNumbers = scnr.nextLine().trim().split(",");
            valid = true; //assume input is valid

            // error if user inputs more than max allowed
            if (toppingNumbers.length > 3) {
                System.out.println("You cannot have more than 5 toppings. Please try again.");
            }
            else {
                // iterate through each flavor
                for (String num : toppingNumbers) {
                    try {
                        // add each flavor to arraylist if valid
                        toppings.add(Topping.fromNum(Integer.parseInt(num.trim())));
                    }
                    catch (NumberFormatException e) { // non-integer input
                        System.out.println("Input must be an integer.");
                        valid = false;
                    }
                    catch (IllegalArgumentException e) { //integer out of bounds
                        System.out.println("Not a valid topping number (1-14). Please try again.");
                        valid = false;
                    }

                    // if any invalid input, clear list -> ensures any invalid num means entire input is invalid
                    if (!valid) {
                        toppings.clear();
                    }
                } // end for
            } // end else
        } //end while

        return toppings;
    }

    private boolean getHasPlushie() {
        boolean hasPlushie = true;
        boolean valid = false;

        UserInterface.printPlushieOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            String choice = scnr.nextLine().trim();

            if (choice.equalsIgnoreCase("Y")) {
                valid = true;
            }
            else if (choice.equalsIgnoreCase("N")) {
                hasPlushie = false;
                valid = true;
            }
            else {
                System.out.println("Must be Y or N. Please try again.");
            }
        }

        return hasPlushie;
    }
}
