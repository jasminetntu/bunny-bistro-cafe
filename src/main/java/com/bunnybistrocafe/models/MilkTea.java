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

    public MilkTea(ArrayList<Topping> toppings, String specialName, TeaType teaType, ArrayList<TeaFlavor> flavors) {
        super(DrinkSize.MEDIUM, DrinkType.MILK_TEA, SweetenerType.CANE_SUGAR, 1, true, 1, toppings, false, specialName);
        this.teaType = teaType;
        this.milk = MilkType.WHOLE;
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

    public double getFlavorPrice() {
        double price = 0;
        if (!flavors.isEmpty()) { //add constant flavor price
            price += flavors.size() * flavors.get(0).getPrice();
        }
        return price;
    }

    @Override
    public double getPrice() {
        return calculateSharedPrice() + milk.getPrice() + getFlavorPrice();
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

        //milk
        sb.append(" | ").append(milk.getName());

        return sb.toString();
    }
}
