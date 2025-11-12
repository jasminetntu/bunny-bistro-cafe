package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MilkTea extends Drink {
    private TeaType teaType;
    private MilkType milk;
    private ArrayList<TeaFlavor> flavors; //max 3

    // *** CONSTRUCTORS ***
    public MilkTea() {
        super();
        this.teaType = TeaType.BLACK;
        this.milk = MilkType.WHOLE;
        this.flavors = new ArrayList<>();
    }

    public MilkTea(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
                   boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie,
                   TeaType teaType, MilkType milk, ArrayList<TeaFlavor> flavors) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.teaType = teaType;
        this.milk = milk;
        this.flavors = flavors;
    }

    // *** GETTERS ***
    public TeaType getTeaType() {
        return teaType;
    }

    public MilkType getMilk() {
        return milk;
    }

    public List<TeaFlavor> getFlavors() {
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
    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    public void setMilk(MilkType milk) {
        this.milk = milk;
    }

    public boolean addFlavor(TeaFlavor flavor) {
        if (flavors.size() < 3) {
            return flavors.add(flavor);
        }
        else { //when milk tea already has 3 flavors, can't add more
            return false;
        }
    }

    public boolean removeFlavor(TeaFlavor flavor) {
        return flavors.remove(flavor);
    }
}
