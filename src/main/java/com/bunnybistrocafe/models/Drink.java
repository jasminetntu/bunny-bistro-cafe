package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Drink implements MenuItem {
    private DrinkSize size;
    private DrinkType type;
    private SweetenerType sweetener;
    private double sweetnessLevel;
    private boolean isIced;
    private double iceLevel;
    private ArrayList<Topping> toppings;
    private boolean hasPlushie;

    // *** CONSTRUCTORS ***

    public Drink(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
                 boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie) {
        this.size = size;
        this.type = type;
        this.sweetener = sweetener;
        this.sweetnessLevel = sweetnessLevel;
        this.isIced = isIced;
        this.iceLevel = iceLevel;
        this.toppings = toppings;
        this.hasPlushie = hasPlushie;
    }

    // *** GETTERS ***

    public DrinkSize getSize() {
        return size;
    }

    public DrinkType getType() {
        return type;
    }

    public SweetenerType getSweetener() {
        return sweetener;
    }

    public double getSweetnessLevel() {
        return sweetnessLevel;
    }

    public boolean isIced() {
        return isIced;
    }

    public double getIceLevel() {
        return iceLevel;
    }

    public List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    public int getNumToppings() {
        return toppings.size();
    }

    public boolean hasPlushie() {
        return hasPlushie;
    }

    public double getPlushiePrice() {
        return 2.99;
    }

    // *** SETTERS ***
    public void setSize(DrinkSize size) {
        this.size = size;
    }

    public void setType(DrinkType type) {
        this.type = type;
    }

    public void setSweetener(SweetenerType sweetener) {
        this.sweetener = sweetener;
    }

    public void setSweetnessLevel(double sweetnessLevel) {
        this.sweetnessLevel = sweetnessLevel;
    }

    public void setIced(boolean iced) {
        isIced = iced;
    }

    public void setIceLevel(double iceLevel) {
        this.iceLevel = iceLevel;
    }

    public boolean addTopping(Topping topping) {
        if (toppings.size() < 5) {
            return this.toppings.add(topping);
        }
        else { //when drink already has 5 toppings, can't add more
            return false;
        }
    }

    public boolean removeTopping(Topping topping) {
        return this.toppings.remove(topping);
    }

    public void setHasPlushie(boolean hasPlushie) {
        this.hasPlushie = hasPlushie;
    }

    // *** OTHER ***
    protected double calculateSharedPrice() {
        double sharedPrice = getSize().getPrice() + getType().getPrice() + getSweetener().getPrice();

        for (Topping t : getToppings()) {
            sharedPrice += t.getPrice();
        }

        if (hasPlushie()) {
            sharedPrice += getPlushiePrice();
        }

        return sharedPrice;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //size
        sb.append(size.getName());

        //iced or hot
        if (isIced) {
            sb.append(" Iced ");
        } else {
            sb.append(" Hot ");
        }

        //drink type & sweetness
        sb.append(type.getName())
                .append("\n").append((int) sweetnessLevel * 100)
                .append("% ").append(sweetener.getName()).append("\n");

        //ice level
        if (isIced) {
            sb.append((int) iceLevel * 100).append("% Ice");
        }

        //toppings
        sb.append("\nToppings: ");
        for (int i = 0; i < toppings.size(); ++i) {
            sb.append(toppings.get(i).getName());
            if (i != toppings.size() - 1) {
                sb.append(", ");
            }
        }

        //plushie
        if (hasPlushie) {
            sb.append("\nPlushie Cup Upgrade");
        }

        return sb.toString();
    }
}
