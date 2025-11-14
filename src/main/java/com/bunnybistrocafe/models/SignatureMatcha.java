package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

/**
 * Represents a signature matcha drink with a unique name.
 */
public class SignatureMatcha extends Matcha {
    private final String signatureName;

    /**
     * Constructor for a signature matcha with default drink size, type, and other inherited attributes.
     *
     * @param sweetener the type of sweetener
     * @param toppings list of {@link Topping} for the matcha
     * @param signatureName the unique name of this signature matcha
     */
    public SignatureMatcha(SweetenerType sweetener, ArrayList<Topping> toppings, String signatureName) {
        super(sweetener, toppings);
        this.signatureName = signatureName;
    }

    /**
     * Full constructor for a signature matcha with all customizable drink attributes.
     *
     * @param size the size of the drink
     * @param type the drink type
     * @param sweetener the sweetener type
     * @param sweetnessLevel the sweetness level (0-1)
     * @param isIced whether the drink is iced
     * @param iceLevel the ice level (0-1)
     * @param toppings list of {@link Topping} objects
     * @param hasPlushie whether the drink includes a plushie
     * @param milk the type of milk
     * @param signatureName the unique name of this signature matcha
     */
    public SignatureMatcha(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                           double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, MilkType milk, String signatureName) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, milk);
        this.signatureName = signatureName;
    }

    /**
     * Returns the unique signature name of this matcha.
     *
     * @return the signature name
     */
    public String getSignatureName() {
        return signatureName;
    }

    /**
     * Returns the display name of this matcha.
     * Overrides the {@link Drink#getDisplayName()} method to return the signature name.
     *
     * @return the signature name as the display name
     */
    @Override
    public String getDisplayName() {
        return signatureName; // returns the special name
    }
}
