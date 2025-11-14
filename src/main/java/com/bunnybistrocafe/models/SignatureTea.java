package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

/**
 * Represents a signature tea drink with a unique name.
 */
public class SignatureTea extends Tea {
    private final String signatureName;

    /**
     * Constructor for a signature tea with default drink size, type, and other inherited attributes.
     *
     * @param toppings list of {@link Topping} for the tea
     * @param teaType the type of tea used
     * @param flavors list of {@link TeaFlavor} objects
     * @param signatureName the unique name of this signature tea
     */
    public SignatureTea(ArrayList<Topping> toppings, TeaType teaType, ArrayList<TeaFlavor> flavors, String signatureName) {
        super(toppings, teaType, flavors);
        this.signatureName = signatureName;
    }

    /**
     * Full constructor for a signature tea with all customizable drink attributes.
     *
     * @param size the size of the drink
     * @param type the drink type
     * @param sweetener the type of sweetener
     * @param sweetnessLevel the sweetness level (0-1)
     * @param isIced whether the drink is iced
     * @param iceLevel the ice level (0-1)
     * @param toppings list of {@link Topping} objects
     * @param hasPlushie whether the drink includes a plushie
     * @param teaType the type of tea used
     * @param flavors list of {@link TeaFlavor} objects
     * @param signatureName the unique name of this signature tea
     */
    public SignatureTea(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                        double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, TeaType teaType,
                        ArrayList<TeaFlavor> flavors, String signatureName) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, teaType, flavors);
        this.signatureName = signatureName;
    }

    /**
     * Returns the unique signature name of this tea.
     *
     * @return the signature name
     */
    public String getSignatureName() {
        return signatureName;
    }

    /**
     * Returns the display name of this tea.
     * Overrides the {@link Drink#getDisplayName()} method to return the signature name.
     *
     * @return the signature name as the display name
     */
    @Override
    public String getDisplayName() {
        return signatureName; // returns the special name
    }
}
