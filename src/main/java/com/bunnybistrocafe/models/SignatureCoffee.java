package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.CoffeeFlavor;
import com.bunnybistrocafe.enumerations.drinkcustomizations.Topping;

import java.util.ArrayList;

public class SignatureCoffee extends Coffee {
    private final String signatureName;

    public SignatureCoffee(ArrayList<Topping> toppings, ArrayList<CoffeeFlavor> flavors, String signatureName) {
        super(toppings, flavors);
        this.signatureName = signatureName;
    }

    public String getSignatureName() {
        return signatureName;
    }
}
