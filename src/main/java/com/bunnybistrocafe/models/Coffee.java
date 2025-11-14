package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coffee extends Drink {
    private MilkType milk;
    private ArrayList<CoffeeFlavor> flavors; //max 2

    // *** CONSTRUCTORS ***
    public Coffee() {
        super();
        this.milk = MilkType.WHOLE;
        this.flavors = new ArrayList<>();
    }

    public Coffee(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
                  boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie,
                  MilkType milk, ArrayList<CoffeeFlavor> flavors) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.milk = milk;
        this.flavors = flavors;
    }

    public Coffee(ArrayList<Topping> toppings, String specialName, ArrayList<CoffeeFlavor> flavors) {
        super(DrinkSize.MEDIUM, DrinkType.COFFEE, SweetenerType.CONDENSED_MILK, 1, true, 1, toppings, false, specialName);
        this.milk = MilkType.WHOLE;
        this.flavors = flavors;
    }

    // *** GETTERS ***
    public MilkType getMilk() {
        return milk;
    }

    public List<CoffeeFlavor> getFlavors() {
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

        //milk
        sb.append(" | ") .append(milk.getName());

        return sb.toString();
    }

}
