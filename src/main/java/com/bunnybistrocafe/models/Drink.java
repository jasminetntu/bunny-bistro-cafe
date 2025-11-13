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
    public Drink() {
        this.size = DrinkSize.MEDIUM;
        this.type = DrinkType.TEA;
        this.sweetener = SweetenerType.CANE_SUGAR;
        this.sweetnessLevel = 1;
        this.isIced = true;
        this.iceLevel = 1;
        this.toppings = new ArrayList<>();
        this.hasPlushie = false;
    }

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

    public double getToppingPrice() {
        double price = 0;
        for (Topping t : getToppings()) {
            price += t.getPrice();
        }
        return price;
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
        double sharedPrice = size.getPrice() + type.getPrice() + sweetener.getPrice();

        sharedPrice += getToppingPrice();

        if (hasPlushie()) {
            sharedPrice += getPlushiePrice();
        }

        return sharedPrice;
    }

    @Override
    public int getCategoryOrder() {
        return 0;
    }

    /**
     * String for receipt
     * @return
     */
    @Override
    public String toString() {
        final String spacing = "   ";

        StringBuilder sb = new StringBuilder();

        //size
        String firstLine = spacing + size.getAbbreviation();

        //iced or hot
        if (isIced) {
            firstLine = firstLine + " Iced " + type.getName();
        } else {
            firstLine = firstLine + " Hot " + type.getName();
        }

        //append firstLine (size, isIced, type) w/ spacing, then append price
        sb.append(String.format("%-39s$%.2f",
                firstLine, getPrice())
        );

        //sweetness level & sweetener
        sb.append(String.format("%n\t%s", spacing))
                .append((int) (sweetnessLevel * 100)).append("% ")
                .append(sweetener.getName());
        if (sweetener.getPrice() > 0) {
            sb.append(String.format(" ($%.2f)", sweetener.getPrice()));
        }

        //ice level
        if (isIced) {
            sb.append(String.format("%n\t%s", spacing))
                    .append((int) (iceLevel * 100)).append("% Ice");
        }

        //toppings
        if (!toppings.isEmpty()) {
            sb.append(String.format("%n\t%s", spacing));
            for (int i = 0; i < toppings.size(); ++i) {
                sb.append(toppings.get(i).getName());
                if (i != toppings.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append(String.format(" ($%.2f)", getToppingPrice()));
        }

        //plushie
        if (hasPlushie) {
            sb.append(String.format("%n\t%sPlushie Cup Upgrade ($%.2f)",
                    spacing, getPlushiePrice()));
        }

        return sb.toString();
    }

    public String toShortString() {
        StringBuilder sb = new StringBuilder();

        //size
        sb.append(size.getAbbreviation());

        //iced or hot
        if (isIced) {
            sb.append(" Iced ");
        } else {
            sb.append(" Hot ");
        }

        //type
        sb.append(type.getName());

        //sweetness level & sweetener
        sb.append(" | ")
                .append((int) (sweetnessLevel * 100)).append("% ")
                .append(sweetener.getName());

        //ice level
        if (isIced) {
            sb.append(" | ")
                    .append((int) (iceLevel * 100)).append("% Ice");
        }

        //toppings
        if (!toppings.isEmpty()) {
            sb.append(" | ");
            for (int i = 0; i < toppings.size(); ++i) {
                sb.append(toppings.get(i).getName());
                if (i != toppings.size() - 1) {
                    sb.append(", ");
                }
            }
        }

        //plushie
        if (hasPlushie) {
            sb.append(" | ").append("Plushie Upgrade");
        }

        return sb.toString();
    }
}
