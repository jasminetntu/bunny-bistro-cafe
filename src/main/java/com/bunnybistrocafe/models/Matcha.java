package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

public class Matcha extends Drink {
    private MilkType milk;

    // *** CONSTRUCTORS ***

    /**
     * Creates a medium iced Matcha drink with standard base settings and whole milk.
     * Basic defaults come from the {@link Drink} no-argument constructor.
     */
    public Matcha() {
        super();
        this.milk = MilkType.WHOLE;
    }

    /**
     * Constructs a fully customized Matcha drink with all drink parameters and milk selection specified.
     *
     * @param size            the drink size
     * @param type            the drink type (should be {@link DrinkType#MATCHA})
     * @param sweetener       the sweetener used
     * @param sweetnessLevel  sweetness level (0–1)
     * @param isIced          whether the drink is iced
     * @param iceLevel        the level of ice (0–1)
     * @param toppings        list of added toppings
     * @param hasPlushie      whether the drink includes a plushie add-on
     * @param milk            the milk type selected for the drink
     */
    public Matcha(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                  double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, MilkType milk) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.milk = milk;
    }

    /**
     * Creates a medium iced Matcha with default base settings but custom toppings and sweetener.
     *
     * @param sweetener the sweetener used
     * @param toppings  list of toppings added to the drink
     */
    public Matcha(SweetenerType sweetener, ArrayList<Topping> toppings) {
        super(DrinkSize.MEDIUM, DrinkType.MATCHA, sweetener, 1, true, 1, toppings, false);
        this.milk = MilkType.WHOLE;
    }

    // *** GETTERS ***

    /**
     * Returns the milk type used in this Matcha drink.
     *
     * @return the selected {@link MilkType}
     */
    public MilkType getMilk() {
        return milk;
    }

    /**
     * Calculates and returns the total price of the Matcha drink.
     * Price includes: base price from shared components, milk price.
     *
     * @return the total calculated drink price
     */
    @Override
    public double getPrice() {
        double totalPrice = calculateSharedPrice();
        totalPrice += milk.getPrice();

        return totalPrice;
    }

    // *** SETTERS ***

    /**
     * Sets the milk type for this Matcha drink.
     *
     * @param milk the new {@link MilkType}
     */
    public void setMilk(MilkType milk) {
        this.milk = milk;
    }

    // *** OTHER ***

    /**
     * Returns a Receipt string representation of the Matcha drink with price.
     *
     * @return formatted multi-line drink description
     */
    @Override
    public String toString() {
        final String spacing = "   ";
        StringBuilder sb = new StringBuilder(super.toString());

        //milk
        sb.append(String.format("%n\t%s", spacing))
                .append(milk.getName());
        if (milk.getPrice() > 0) {
            sb.append(String.format(" ($%.2f)", milk.getPrice()));
        }

        return sb.toString();
    }

    /**
     * Returns a shortened, single-line summary of the Matcha drink.
     *
     * @return a brief string
     */
    @Override
    public String toShortString() {
        return super.toShortString() + " | " + milk.getName();
    }
}
