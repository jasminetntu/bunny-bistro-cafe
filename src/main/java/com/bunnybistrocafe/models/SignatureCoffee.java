package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

public class SignatureCoffee extends Coffee {
    private final String signatureName;

    public SignatureCoffee(ArrayList<Topping> toppings, ArrayList<CoffeeFlavor> flavors, String signatureName) {
        super(toppings, flavors);
        this.signatureName = signatureName;
    }

    public SignatureCoffee(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                           double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, MilkType milk,
                           ArrayList<CoffeeFlavor> coffeeFlavors, String signatureName) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, milk, coffeeFlavors);
        this.signatureName = signatureName;
    }

    public String getSignatureName() {
        return signatureName;
    }

    @Override
    public String getDisplayName() {
        return signatureName; // returns the special name
    }
}
