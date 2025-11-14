package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

public class SignatureTea extends Tea {
    private final String signatureName;

    public SignatureTea(ArrayList<Topping> toppings, TeaType teaType, ArrayList<TeaFlavor> flavors, String signatureName) {
        super(toppings, teaType, flavors);
        this.signatureName = signatureName;
    }

    public SignatureTea(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                        double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, TeaType teaType,
                        ArrayList<TeaFlavor> flavors, String signatureName) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, teaType, flavors);
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
