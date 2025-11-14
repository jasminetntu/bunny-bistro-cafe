package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.SweetenerType;
import com.bunnybistrocafe.enumerations.drinkcustomizations.Topping;

import java.util.ArrayList;

public class SignatureMatcha extends Matcha {
    private final String signatureName;

    public SignatureMatcha(SweetenerType sweetener, ArrayList<Topping> toppings, String signatureName) {
        super(sweetener, toppings);
        this.signatureName = signatureName;
    }

    public String getSignatureName() {
        return signatureName;
    }
}
