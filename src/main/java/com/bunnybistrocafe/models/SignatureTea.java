package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.TeaFlavor;
import com.bunnybistrocafe.enumerations.drinkcustomizations.TeaType;
import com.bunnybistrocafe.enumerations.drinkcustomizations.Topping;

import java.util.ArrayList;

public class SignatureTea extends Tea {
    private final String signatureName;

    public SignatureTea(ArrayList<Topping> toppings, TeaType teaType, ArrayList<TeaFlavor> flavors, String signatureName) {
        super(toppings, teaType, flavors);
        this.signatureName = signatureName;
    }

    public String getSignatureName() {
        return signatureName;
    }
}
