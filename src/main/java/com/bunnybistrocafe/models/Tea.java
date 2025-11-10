package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tea extends Drink {
    private TeaType teaType;
    private ArrayList<TeaFlavor> flavors; //max 3

    // *** CONSTRUCTORS ***
    public Tea(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
               boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie,
               TeaType teaType, ArrayList<TeaFlavor> flavors) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.teaType = teaType;
        this.flavors = flavors;
    }

    // *** GETTERS ***
    public TeaType getTeaType() {
        return teaType;
    }

    public List<TeaFlavor> getFlavors() {
        return Collections.unmodifiableList(flavors);
    }

    @Override
    public double getPrice() {
        double totalPrice = calculateSharedPrice();

        if (!flavors.isEmpty()) { //add constant flavor price
            totalPrice += flavors.size() * flavors.get(0).getPrice();
        }

        return totalPrice;
    }

    // *** SETTERS ***
    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    public void addFlavor(TeaFlavor flavor) {
        flavors.add(flavor);
    }

    public void removeFlavor(TeaFlavor flavor) {
        flavors.remove(flavor);
    }
}
