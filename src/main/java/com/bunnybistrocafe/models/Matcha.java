package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

public class Matcha extends Drink {
    private MilkType milk;

    // *** CONSTRUCTORS ***

    public Matcha(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                  double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, MilkType milk) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.milk = milk;
    }

    // *** GETTERS ***
    public MilkType getMilk() {
        return milk;
    }

    @Override
    public double getPrice() {
        double totalPrice = getSize().getPrice() + getType().getPrice() + getSweetener().getPrice() + milk.getPrice();

        for (Topping t : getToppings()) {
            totalPrice += t.getPrice();
        }

        if (hasPlushie()) {
            totalPrice += getPlushiePrice();
        }

        return totalPrice;
    }

    // *** SETTERS ***
    public void setMilk(MilkType milk) {
        this.milk = milk;
    }
}
