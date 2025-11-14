package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;


/**
 * Represents a signature coffee drink with a unique name.
 */
public class SignatureCoffee extends Coffee {
    private final String signatureName;

    /**
     * Constructor for a signature coffee with default drink size, type, and other inherited attributes.
     *
     * @param toppings list of toppings for the coffee
     * @param flavors list of {@link CoffeeFlavor} for the coffee
     * @param signatureName the unique name of this signature coffee
     */
    public SignatureCoffee(ArrayList<Topping> toppings, ArrayList<CoffeeFlavor> flavors, String signatureName) {
        super(toppings, flavors);
        this.signatureName = signatureName;
    }

    /**
     * Full constructor for a signature coffee with all customizable drink attributes.
     *
     * @param size the size of the coffee
     * @param type the drink type
     * @param sweetener the sweetener type
     * @param sweetnessLevel the sweetness level (0-1)
     * @param isIced whether the coffee is iced
     * @param iceLevel the ice level (0-1)
     * @param toppings list of toppings
     * @param hasPlushie whether the drink includes a plushie
     * @param milk the type of milk
     * @param coffeeFlavors list of {@link CoffeeFlavor} objects
     * @param signatureName the unique name of this signature coffee
     */
    public SignatureCoffee(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                           double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, MilkType milk,
                           ArrayList<CoffeeFlavor> coffeeFlavors, String signatureName) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, milk, coffeeFlavors);
        this.signatureName = signatureName;
    }

    /**
     * Returns the unique signature name of this coffee.
     *
     * @return the signature name
     */
    public String getSignatureName() {
        return signatureName;
    }

    /**
     * Returns the display name of this coffee.
     * Overrides the {@link Drink#getDisplayName()} method to return the signature name.
     *
     * @return the signature name as the display name
     */
    @Override
    public String getDisplayName() {
        return signatureName; // returns the special name
    }
}
