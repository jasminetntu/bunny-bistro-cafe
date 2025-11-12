package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coffee extends Drink {
    private MilkType milk;
    private ArrayList<CoffeeFlavor> flavors; //max 2

    // *** CONSTRUCTORS ***
    public Coffee(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
                  boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie,
                  MilkType milk, ArrayList<CoffeeFlavor> flavors) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.milk = milk;
        this.flavors = flavors;
    }

    // *** GETTERS ***
    public MilkType getMilk() {
        return milk;
    }

    public List<CoffeeFlavor> getFlavors() {
        return Collections.unmodifiableList(flavors);
    }

    @Override
    public double getPrice() {
        double totalPrice = calculateSharedPrice();
        totalPrice += milk.getPrice();

        if (!flavors.isEmpty()) { //add constant flavor price
            totalPrice += flavors.size() * flavors.get(0).getPrice();
        }

        return totalPrice;
    }

    // *** SETTERS ***
    public void setMilk(MilkType milk) {
        this.milk = milk;
    }

    public boolean addFlavor(CoffeeFlavor flavor) {
        if (flavors.size() < 2) {
            return flavors.add(flavor);
        }
        else { //when coffee already has 2 flavors, can't add more
            return false;
        }
    }

    public boolean removeFlavor(CoffeeFlavor flavor) {
        return flavors.remove(flavor);
    }

}
