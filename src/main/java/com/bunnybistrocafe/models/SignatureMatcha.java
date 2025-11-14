package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

public class SignatureMatcha extends Matcha {
    private final String signatureName;

    public SignatureMatcha(SweetenerType sweetener, ArrayList<Topping> toppings, String signatureName) {
        super(sweetener, toppings);
        this.signatureName = signatureName;
    }

    public SignatureMatcha(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                           double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, MilkType milk, String signatureName) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, milk);
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
