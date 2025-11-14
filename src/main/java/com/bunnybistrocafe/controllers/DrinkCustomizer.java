package com.bunnybistrocafe.controllers;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;
import com.bunnybistrocafe.models.*;
import com.bunnybistrocafe.util.UserInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrinkCustomizer {
    private final Scanner scnr;

    public DrinkCustomizer(Scanner scnr) {
        this.scnr = scnr;
    }

    public Drink customizeDrink() {
        try {
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
            } else if (type == DrinkType.COFFEE) {
                return new Coffee(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, milk, coffeeFlavors);
            } else if (type == DrinkType.MILK_TEA) {
                return new MilkTea(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, teaType, milk, teaFlavors);
            } else { //tea
                return new Tea(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, teaType, teaFlavors);
            }
        }
        catch (RuntimeException e) {
            System.out.println("Drink cancelled. Returning to order.");
            return null;
        }
    }

    public Drink customizeSignatureDrink(Drink drink) {
        try {
            // basics
            DrinkSize size = getOptionalSize(drink.getSize());
            SweetenerType sweetener = getOptionalSweetenerType(drink.getSweetener());
            double sweetnessLevel = getOptionalSweetnessLevel(drink.getSweetnessLevel());
            ArrayList<Topping> toppings = getOptionalToppings(new ArrayList<>(drink.getToppings()));

            // initialize attributes
            boolean isIced = true;
            TeaType teaType = TeaType.BLACK;
            double iceLevel = 1;
            MilkType milk = MilkType.WHOLE;

            // iced or hot
            if (drink.getType() == DrinkType.MATCHA || drink.getType() == DrinkType.COFFEE) {
                isIced = getOptionalIcedOrHot();
            }

            // ice level
            if (isIced) {
                iceLevel = getOptionalIceLevel(drink.getIceLevel());
            }

            // tea type
            if (drink instanceof MilkTea mt) {
                teaType = getOptionalTeaType(mt.getTeaType());
            } else if (drink instanceof Tea t) {
                teaType = getOptionalTeaType(t.getTeaType());
            }

            // milk type
            if (drink instanceof Matcha m) {
                milk = getOptionalMilkType(m.getMilk());
            } else if (drink instanceof Coffee c) {
                milk = getOptionalMilkType(c.getMilk());
            } else if (drink instanceof MilkTea mt) {
                milk = getOptionalMilkType(mt.getMilk());
            }

            boolean hasPlushie = getOptionalHasPlushie();

            // create drinks based on type
            if (drink instanceof Matcha m) {
                return new SignatureMatcha(size, m.getType(), sweetener, sweetnessLevel, isIced, iceLevel, toppings,
                        hasPlushie, milk, drink.getDisplayName());
            } else if (drink instanceof Coffee c) {
                return new SignatureCoffee(size, drink.getType(), sweetener, sweetnessLevel, isIced, iceLevel, toppings,
                        hasPlushie, milk, new ArrayList<>(c.getFlavors()), drink.getDisplayName());
            } else if (drink instanceof MilkTea mt) {
                return new SignatureMilkTea(size, drink.getType(), sweetener, sweetnessLevel, isIced, iceLevel, toppings,
                        hasPlushie, teaType, milk, new ArrayList<>(mt.getFlavors()), drink.getDisplayName());
            } else if (drink instanceof Tea t) { //tea
                return new SignatureTea(size, drink.getType(), sweetener, sweetnessLevel, isIced, iceLevel, toppings,
                        hasPlushie, teaType, new ArrayList<>(t.getFlavors()), drink.getDisplayName());
            } else {
                return null;
            }
        }
        catch (RuntimeException e) {
            System.out.println("Signature drink cancelled. Returning to order.");
            return null;
        }
    }

    // *** PRIVATE HELPERS FOR MANDATORY ***
    private DrinkSize getSize() {
        DrinkSize size = null;
        boolean valid = false;
        
        UserInterface.printSizeOptions();

        while (!valid) {
            System.out.print("> Enter choice: ");
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            try {
                size = DrinkSize.fromAbbreviation(input);
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
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            try {
                type = DrinkType.fromAbbreviation(input);
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
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            try {
                teaType = TeaType.fromAbbreviation(input);
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid tea (B, G, O, T, W). Please try again.");
            }
        }

        return teaType;
    }

    private ArrayList<TeaFlavor> getTeaFlavors() {
        ArrayList<TeaFlavor> teaFlavors = new ArrayList<>();
        boolean valid = false;

        UserInterface.printTeaFlavorOptions();

        while (!valid) {
            teaFlavors.clear(); // reset arraylist

            System.out.print("> Enter flavor(s): ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            //return empty arraylist if skip
            if (input.isEmpty()) {
                System.out.println("No flavors added.");
                return teaFlavors;
            }

            //otherwise, continue with split
            String[] flavorNumbers = input.split(",");
            valid = true; //assume input is valid

            // error if user inputs more than max allowed
            if (flavorNumbers.length > 3) {
                System.out.println("You cannot have more than 3 flavors. Please try again.");
                valid = false;
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
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }
            else if (input.equalsIgnoreCase("I")) {
                valid = true;
            }
            else if (input.equalsIgnoreCase("H")) {
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
        ArrayList<CoffeeFlavor> coffeeFlavors = new ArrayList<>();
        boolean valid = false;

        UserInterface.printCoffeeFlavorOptions();


        while (!valid) {
            coffeeFlavors.clear(); // reset arraylist

            System.out.print("> Enter flavor(s): ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            //return empty arraylist if skip
            if (input.isEmpty()) {
                System.out.println("No flavors added.");
                return coffeeFlavors;
            }

            //otherwise, continue with split
            String[] flavorAbbrevs = input.split(",");
            valid = true; //assume input is valid

            if (flavorAbbrevs.length > 2) { // error if user inputs more than max allowed
                System.out.println("You cannot have more than 2 flavors. Please try again.");
                valid = false;
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
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            try {
                sweetener = SweetenerType.fromAbbreviation(input);
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid sweetener (C, S, H, CM). Please try again.");
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
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            try {
                sweetnessLevel = Double.parseDouble(input);

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
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            try {
                iceLevel = Double.parseDouble(input);

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
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            try {
                milkType = MilkType.fromAbbreviation(input);
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid milk (W, N, O, A). Please try again.");
            }
        }

        return milkType;
    }

    private ArrayList<Topping> getToppings() {
        ArrayList<Topping> toppings = new ArrayList<>();
        boolean valid = false;

        UserInterface.printToppingOptions();

        while (!valid) {
            toppings.clear(); // reset arraylist

            System.out.print("> Enter topping(s): ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            //return empty arraylist if skip
            if (input.isEmpty()) {
                System.out.println("No toppings added.");
                return toppings;
            }

            //otherwise, continue with split
            String[] toppingNumbers = input.split(",");
            valid = true; //assume input is valid

            if (toppingNumbers.length > 5) { // error if user inputs more than max allowed
                System.out.println("You cannot have more than 5 toppings. Please try again.");
                valid = false;
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
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }
            else if (input.equalsIgnoreCase("Y")) {
                valid = true;
            }
            else if (input.equalsIgnoreCase("N")) {
                hasPlushie = false;
                valid = true;
            }
            else {
                System.out.println("Must be Y or N. Please try again.");
            }
        }

        return hasPlushie;
    }

    // *** PRIVATE HELPERS FOR OPTIONAL ***
    private DrinkSize getOptionalSize(DrinkSize defaultVal) {
        DrinkSize size = null;
        boolean valid = false;

        UserInterface.printSizeOptions();

        while (!valid) {
            System.out.print("> Enter choice (or ENTER to keep " + defaultVal + "): ");
            String input = scnr.nextLine();

            // cancel drink
            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            // skip
            if (input.isEmpty()) {
                return defaultVal;
            }

            // customize
            try {
                size = DrinkSize.fromAbbreviation(input);
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid size (S, M, L). Please try again.");
            }
        }

        return size;
    }

    private TeaType getOptionalTeaType(TeaType defaultVal) {
        TeaType teaType = null;
        boolean valid = false;

        UserInterface.printTeaTypeOptions();

        while (!valid) {
            System.out.print("> Enter choice (or ENTER to keep " + defaultVal + "): ");
            String input = scnr.nextLine();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            // skip
            if (input.isEmpty()) {
                return defaultVal;
            }

            try {
                teaType = TeaType.fromAbbreviation(input);
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid tea (B, G, O, T, W). Please try again.");
            }
        }

        return teaType;
    }

    private boolean getOptionalIcedOrHot() {
        boolean isIced = true;
        boolean valid = false;

        while (!valid) {
            System.out.print("> Keep iced (Press ENTER), or change to Hot (H), or Cancel (R): ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }
            // skip
            else if (input.isEmpty()) {
                valid = true;
            }
            else if (input.equalsIgnoreCase("H")) {
                isIced = false;
                valid = true;
            }
            else {
                System.out.println("Must be I or H. Please try again.");
            }
        }

        return isIced;
    }

    private SweetenerType getOptionalSweetenerType(SweetenerType defaultVal) {
        SweetenerType sweetener = null;
        boolean valid = false;

        UserInterface.printSweetenerTypeOptions();

        while (!valid) {
            System.out.print("> Enter choice (or ENTER to keep " + defaultVal + "): ");
            String input = scnr.nextLine();

            // cancel
            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            // skip
            if (input.isEmpty()) {
                return defaultVal;
            }

            // customize
            try {
                sweetener = SweetenerType.fromAbbreviation(input);
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid sweetener (C, S, H, CM). Please try again.");
            }
        }

        return sweetener;
    }

    private double getOptionalSweetnessLevel(double defaultVal) {
        double sweetnessLevel = 1;
        boolean valid = false;

        UserInterface.printSweetnessLevelOptions();

        while (!valid) {
            System.out.print("> Enter choice (or ENTER to keep " + (int) (defaultVal * 100) + "): ");
            String input = scnr.nextLine().trim();

            // cancel
            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            // skip
            if (input.isEmpty()) {
                return defaultVal;
            }

            // customize
            try {
                sweetnessLevel = Double.parseDouble(input);

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

    private double getOptionalIceLevel(double defaultVal) {
        double iceLevel = 1;
        boolean valid = false;

        UserInterface.printIceLevelOptions();

        while (!valid) {
            System.out.print("> Enter choice (or ENTER to keep " + (int) (defaultVal * 100) + "): ");
            String input = scnr.nextLine().trim();

            // cancel
            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            // skip
            if (input.isEmpty()) {
                return defaultVal;
            }

            // customize
            try {
                iceLevel = Double.parseDouble(input);

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

    private MilkType getOptionalMilkType(MilkType defaultVal) {
        MilkType milkType = null;
        boolean valid = false;

        UserInterface.printMilkTypeOptions();

        while (!valid) {
            System.out.print("> Enter choice (or ENTER to keep " + defaultVal + "): ");
            String input = scnr.nextLine();

            // cancel
            if (input.equalsIgnoreCase("R")) {
                throw new RuntimeException();
            }

            // skip
            if (input.isEmpty()) {
                return defaultVal;
            }

            // customize
            try {
                milkType = MilkType.fromAbbreviation(input);
                valid = true;
            }
            catch (IllegalArgumentException e) {
                System.out.println("Not a valid milk (W, N, O, A). Please try again.");
            }
        }

        return milkType;
    }

    private ArrayList<Topping> getOptionalToppings(ArrayList<Topping> defaultVals) {
        ArrayList<Topping> toppings = new ArrayList<>(defaultVals);
        boolean validChoice = false;

        // *** REMOVE TOPPINGS ***
        while (!validChoice) {
            if (!toppings.isEmpty()) {
                System.out.println("\nCurrent toppings:");
                for (int i = 0; i < toppings.size(); i++) {
                    System.out.println((i + 1) + ". " + toppings.get(i).getName());
                }

                System.out.print("\nWould you like to remove any toppings? (Y/N): ");
                String removeChoice = scnr.nextLine().trim();

                if (removeChoice.equalsIgnoreCase("N")) {
                    validChoice = true;
                }
                else if (removeChoice.equalsIgnoreCase("Y")) {
                    boolean validRemove = false;

                    while (!validRemove) {
                        System.out.print("> Enter topping number(s) to remove (comma-separated), or (R) to Cancel: ");
                        String input = scnr.nextLine().trim();

                        // cancel
                        if (input.equalsIgnoreCase("R")) {
                            throw new RuntimeException();
                        }

                        String[] toppingNumbers = input.split(",");
                        validRemove = true;

                        if (toppingNumbers.length > toppings.size()) { // error if user inputs more than max allowed
                            System.out.println("You cannot remove more than default toppings. Please try again.");
                            validRemove = false;
                        } else {
                            List<Topping> toRemove = new ArrayList<>();
                            // iterate through each flavor
                            for (String num : toppingNumbers) {
                                try {
                                    int i = Integer.parseInt(num.trim()) - 1;
                                    if (i < 0 || i >= toppings.size()) {
                                        throw new IllegalArgumentException();
                                    }
                                    toRemove.add(toppings.get(i));
                                } catch (NumberFormatException e) { // non-integer input
                                    System.out.println("❌ Input must be an integer.");
                                    validRemove = false;
                                } catch (IllegalArgumentException e) { //integer out of bounds
                                    System.out.println("❌ Not a valid topping number. Please try again.");
                                    validRemove = false;
                                }
                            }

                            //only remove if all toppings were valid
                            if (toRemove.size() == toppingNumbers.length) {
                                toppings.removeAll(toRemove);
                            }

                            validChoice = true;
                        } // end else
                    } // end inner while
                }
                else {
                    System.out.println("❌ Invalid input. Must be Y or N.");
                } // end inner if
            } // end outer if
        } // end outer while

        // *** ADD TOPPINGS ***
        if (!toppings.isEmpty()) {
            System.out.println("\nCurrent toppings:");
            for (int i = 0; i < toppings.size(); i++) {
                System.out.println((i + 1) + ". " + toppings.get(i).getName());
            }
        }
        else {
            System.out.println("Drink currently has no toppings.");
        }

        validChoice = false;
        while (!validChoice) {
            System.out.print("\nWould you like to add toppings? (Y/N): ");
            String addChoice = scnr.nextLine().trim();

            if (addChoice.equalsIgnoreCase("N")) {
                validChoice = true;
            }
            else if (addChoice.equalsIgnoreCase("Y")) {
                boolean validAdd = false;

                while (!validAdd) {
                    UserInterface.printToppingOptions();
                    System.out.print("> Enter topping number(s) to add (comma-separated), or (R) to Cancel: ");
                    String input = scnr.nextLine().trim();

                    if (input.equalsIgnoreCase("R")) {
                        throw new RuntimeException();
                    }

                    if (!input.isEmpty()) {
                        String[] toppingNumbers = input.split(",");
                        validAdd = true;

                        if (toppingNumbers.length + toppings.size() > 5) { // error if user inputs more than max allowed
                            System.out.println("❌ You cannot have more than 5 toppings. Please try again.");
                            validAdd = false;
                        } else {
                            List<Topping> toAdd = new ArrayList<>();
                            // iterate through each flavor
                            for (String num : toppingNumbers) {
                                try {
                                    // add each flavor to arraylist if valid
                                    toAdd.add(Topping.fromNum(Integer.parseInt(num.trim())));
                                } catch (NumberFormatException e) { // non-integer input
                                    System.out.println("❌ Input must be an integer.");
                                    validAdd = false;
                                } catch (IllegalArgumentException e) { //integer out of bounds
                                    System.out.println("❌ Not a valid topping number (1-14). Please try again.");
                                    validAdd = false;
                                }
                            } // end for

                            //only add if all toppings were valid
                            if (toAdd.size() == toppingNumbers.length) {
                                toppings.addAll(toAdd);
                            }

                            validChoice = true;
                        } // end inner if
                    } // end outer if
                } // end inner while
            }
            else {
                System.out.println("❌ Invalid input. Must be Y or N.");
            }
        } // end outer while
        return toppings;
    }

    private boolean getOptionalHasPlushie() {
        boolean hasPlushie = false;
        boolean valid = false;

        UserInterface.printPlushieOptions();

        while (!valid) {
            System.out.print("> NO Plushie (press ENTER), or upgrade to PLUSHIE CUP (Y): ");
            String input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("R")) { //cancel
                throw new RuntimeException();
            }
            else if (input.isEmpty()) { //skip
                valid = true;
            }
            else if (input.equalsIgnoreCase("Y")) {
                hasPlushie = true;
                valid = true;
            }
            else if (input.equalsIgnoreCase("N")) {
                valid = true;
            }
            else {
                System.out.println("Must be Y or N. Please try again.");
            }
        }

        return hasPlushie;
    }
}
