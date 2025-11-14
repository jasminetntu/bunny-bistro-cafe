package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;

public class Matcha extends Drink {
    private MilkType milk;

    // *** CONSTRUCTORS ***
    public Matcha() {
        super();
        this.milk = MilkType.WHOLE;
    }

    public Matcha(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel, boolean isIced,
                  double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie, MilkType milk) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.milk = milk;
    }

    public Matcha(SweetenerType sweetener, ArrayList<Topping> toppings) {
        super(DrinkSize.MEDIUM, DrinkType.MATCHA, sweetener, 1, true, 1, toppings, false);
        this.milk = MilkType.WHOLE;
    }

    // *** GETTERS ***
    public MilkType getMilk() {
        return milk;
    }

    @Override
    public double getPrice() {
        double totalPrice = calculateSharedPrice();
        totalPrice += milk.getPrice();

        return totalPrice;
    }

    // *** SETTERS ***
    public void setMilk(MilkType milk) {
        this.milk = milk;
    }

    // *** OTHER ***
    @Override
    public String toString() {
        final String spacing = "   ";
        StringBuilder sb = new StringBuilder(super.toString());

        //milk
        sb.append(String.format("%n\t%s", spacing))
                .append(milk.getName());
        if (milk.getPrice() > 0) {
            sb.append(String.format(" ($%.2f)", milk.getPrice()));
        }

        return sb.toString();
    }

    @Override
    public String toShortString() {
        StringBuilder sb = new StringBuilder(super.toShortString());

        //milk
        sb.append(" | ").append(milk.getName());

        return sb.toString();
    }
}
