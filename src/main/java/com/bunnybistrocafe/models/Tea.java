package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tea extends Drink {
    private TeaType teaType;
    private final ArrayList<TeaFlavor> flavors; //max 3

    // *** CONSTRUCTORS ***
    public Tea() {
        super();
        this.teaType = TeaType.BLACK;
        this.flavors = new ArrayList<>();
    }

    public Tea(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
               boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie,
               TeaType teaType, ArrayList<TeaFlavor> flavors) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.teaType = teaType;
        this.flavors = flavors;
    }

    public Tea(ArrayList<Topping> toppings, TeaType teaType, ArrayList<TeaFlavor> flavors) {
        super(DrinkSize.MEDIUM, DrinkType.TEA, SweetenerType.CANE_SUGAR, 1, true, 1, toppings, false);
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

    public double getFlavorPrice() {
        double price = 0;
        if (!flavors.isEmpty()) { //add constant flavor price
            price += flavors.size() * flavors.get(0).getPrice();
        }
        return price;
    }

    @Override
    public double getPrice() {
        return calculateSharedPrice() + getFlavorPrice();
    }

    // *** SETTERS ***
    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
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

    // *** OTHER ***
    @Override
    public String toString() {
        final String spacing = "   ";
        StringBuilder sb = new StringBuilder(super.toString());

        //flavors
        if (!flavors.isEmpty()) {
            sb.append(String.format("%n\t%s", spacing));
            for (int i = 0; i < flavors.size(); ++i) {
                sb.append(flavors.get(i).getName());
                if (i != flavors.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(String.format(" ($%.2f)", getFlavorPrice()));
        }

        //tea type
        sb.append(String.format("%n\t%s", spacing))
                .append(teaType.getName());

        return sb.toString();
    }

    @Override
    public String toShortString() {
        StringBuilder sb = new StringBuilder(super.toShortString());

        //flavors
        if (!flavors.isEmpty()) {
            sb.append(" | ");
            for (int i = 0; i < flavors.size(); ++i) {
                sb.append(flavors.get(i).getName());
                if (i != flavors.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        //tea type
        sb.append(" | ").append(teaType.getName());

        return sb.toString();
    }
}
