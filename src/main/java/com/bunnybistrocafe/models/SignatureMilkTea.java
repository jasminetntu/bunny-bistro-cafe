package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

public class SignatureMilkTea extends MilkTea {
    private final String signatureName;

    public SignatureMilkTea(ArrayList<Topping> toppings, TeaType teaType, ArrayList<TeaFlavor> flavors, String signatureName) {
        super(toppings, teaType, flavors);
        this.signatureName = signatureName;
    }

    public SignatureMilkTea(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                            double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, TeaType teaType, MilkType milk,
                            ArrayList<TeaFlavor> flavors, String signatureName) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie, teaType, milk, flavors);
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
