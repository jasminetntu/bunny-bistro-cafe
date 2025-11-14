package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coffee extends Drink {
    private MilkType milk;
    private ArrayList<CoffeeFlavor> flavors; //max 2

    // *** CONSTRUCTORS ***
    /**
     * Creates a default Coffee with whole milk and no added flavors.
     * Inherits default values from the {@link Drink} base class.
     */
    public Coffee() {
        super();
        this.milk = MilkType.WHOLE;
        this.flavors = new ArrayList<>();
    }

    /**
     * Creates a fully customized Coffee with all drink attributes specified.
     *
     * @param size           the drink size
     * @param type           the drink type
     * @param sweetener      the sweetener type
     * @param sweetnessLevel the sweetness percentage (0–1)
     * @param isIced         whether the drink is iced
     * @param iceLevel       the ice level (0–1)
     * @param toppings       a list of toppings
     * @param hasPlushie     whether a plushie add-on is included
     * @param milk           the milk type
     * @param flavors        the list of flavor shots (max 2)
     */
    public Coffee(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
                  boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie,
                  MilkType milk, ArrayList<CoffeeFlavor> flavors) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.milk = milk;
        this.flavors = flavors;
    }

    /**
     * Creates a medium iced Coffee with default base settings but custom toppings and flavors.
     *
     * @param toppings the list of toppings
     * @param flavors  the list of flavor shots (max 2)
     */
    public Coffee(ArrayList<Topping> toppings, ArrayList<CoffeeFlavor> flavors) {
        super(DrinkSize.MEDIUM, DrinkType.COFFEE, SweetenerType.CONDENSED_MILK, 1, true, 1, toppings, false);
        this.milk = MilkType.WHOLE;
        this.flavors = flavors;
    }

    // *** GETTERS ***

    /**
     * Returns the milk type used in the coffee.
     *
     * @return the milk type
     */
    public MilkType getMilk() {
        return milk;
    }

    /**
     * Returns an unmodifiable list of flavors added to the coffee.
     *
     * @return an unmodifiable list containing 0–2 flavors
     */
    public List<CoffeeFlavor> getFlavors() {
        return Collections.unmodifiableList(flavors);
    }

    /**
     * Calculates the total price of all flavor shots.
     * Each flavor has the same flat price.
     *
     * @return the total flavor surcharge
     */
    public double getFlavorPrice() {
        double price = 0;
        if (!flavors.isEmpty()) { //add constant flavor price
            price += flavors.size() * flavors.get(0).getPrice();
        }
        return price;
    }

    /**
     * Computes the total price of the coffee, including:
     * base drink price, milk surcharge, flavor surcharges
     *
     * @return the full price of the coffee
     */
    @Override
    public double getPrice() {
        return calculateSharedPrice() + milk.getPrice() + getFlavorPrice();
    }

    // *** SETTERS ***

    /**
     * Sets the milk type for the coffee.
     *
     * @param milk the new milk type
     */
    public void setMilk(MilkType milk) {
        this.milk = milk;
    }

    /**
     * Adds a flavor to the coffee if fewer than 2 flavors are currently selected.
     *
     * @param flavor the flavor to add
     * @return true if the flavor was added, false if the limit was reached
     */
    public boolean addFlavor(CoffeeFlavor flavor) {
        if (flavors.size() < 2) {
            return flavors.add(flavor);
        }
        else { //when coffee already has 2 flavors, can't add more
            return false;
        }
    }

    /**
     * Removes the specified flavor from the coffee.
     *
     * @param flavor the flavor to remove
     * @return true if the flavor was removed, false if it was not present
     */
    public boolean removeFlavor(CoffeeFlavor flavor) {
        return flavors.remove(flavor);
    }

    // *** OTHER ***

    /**
     * Returns the detailed Receipt string representation of the coffee with pricing.
     *
     * @return a descriptive string representation of the coffee
     */
    @Override
    public String toString() {
        final String spacing = "   ";
        StringBuilder sb = new StringBuilder(super.toString());

        //flavors
        if (!flavors.isEmpty()) {
            sb.append(String.format("%n\t%s", spacing));
            for (int i = 0; i < flavors.size(); ++i) {
                sb.append(flavors.get(i).getName());
                if (i != flavors.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(String.format(" ($%.2f)", getFlavorPrice()));
        }

        //milk
        sb.append(String.format("%n\t%s", spacing))
                .append(milk.getName());
        if (milk.getPrice() > 0) {
            sb.append(String.format(" ($%.2f)", milk.getPrice()));
        }

        return sb.toString();
    }

    /**
     * Returns a shorter, single-line representation of the coffee suitable
     * for order summaries.
     *
     * @return a condensed description of the coffee
     */
    @Override
    public String toShortString() {
        StringBuilder sb = new StringBuilder(super.toShortString());

        //flavors
        if (!flavors.isEmpty()) {
            sb.append(" | ");
            for (int i = 0; i < flavors.size(); ++i) {
                sb.append(flavors.get(i).getName());
                if (i != flavors.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        //milk
        sb.append(" | ") .append(milk.getName());

        return sb.toString();
    }

}
