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

    /**
     * Creates a Drink with default settings:
     * Medium size, Tea, Cane sugar, 100% sweetness, 100% ice,
     * No toppings, No plushie upgrade
     */
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

    /**
     * Creates a Drink with all key properties specified.
     *
     * @param size           the drink size
     * @param type           the drink type
     * @param sweetener      the sweetener type
     * @param sweetnessLevel the sweetness level (0–1)
     * @param isIced         whether the drink is iced
     * @param iceLevel       the ice level (0–1)
     * @param toppings       list of toppings
     * @param hasPlushie     whether the plushie cup upgrade is included
     */
    public Drink(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
                 boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie) {
        this();
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

    /**
     * Returns the size of the drink.
     *
     * @return the drink size
     */
    public DrinkSize getSize() {
        return size;
    }

    /**
     * Returns the drink type.
     *
     * @return the drink type
     */
    public DrinkType getType() {
        return type;
    }

    /**
     * Returns the display name of the drink.
     * Subclasses may override this for signature drinks.
     *
     * @return the drink's display name
     */
    public String getDisplayName() {
        return type.getName(); // default: normal drink
    }

    /**
     * Returns the sweetener used in the drink.
     *
     * @return the sweetener type
     */
    public SweetenerType getSweetener() {
        return sweetener;
    }

    /**
     * Returns the sweetness level from 0 to 1.25.
     *
     * @return the sweetness level
     */
    public double getSweetnessLevel() {
        return sweetnessLevel;
    }

    /**
     * Returns whether the drink is served iced.
     *
     * @return true if iced, false if hot
     */
    public boolean isIced() {
        return isIced;
    }

    /**
     * Returns the ice level from 0 to 1.25.
     *
     * @return the ice level percentage
     */
    public double getIceLevel() {
        return iceLevel;
    }

    /**
     * Returns an unmodifiable list of toppings.
     *
     * @return a list of toppings
     */
    public List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }

    /**
     * Returns the number of toppings added to the drink.
     *
     * @return topping count
     */
    public int getNumToppings() {
        return toppings.size();
    }

    /**
     * Calculates the total surcharge from toppings.
     *
     * @return the total topping cost
     */
    public double getToppingPrice() {
        double price = 0;
        for (Topping t : getToppings()) {
            price += t.getPrice();
        }
        return price;
    }

    /**
     * Returns whether the drink includes the plushie cup upgrade.
     *
     * @return true if plushie upgrade is included
     */
    public boolean hasPlushie() {
        return hasPlushie;
    }

    /**
     * Returns the price of the plushie cup upgrade.
     *
     * @return the plushie price
     */
    public double getPlushiePrice() {
        return 2.99;
    }

    // *** SETTERS ***

    /**
     * Sets the drink size.
     *
     * @param size the new size
     */
    public void setSize(DrinkSize size) {
        this.size = size;
    }

    /**
     * Sets the drink type.
     *
     * @param type the new drink type
     */
    public void setType(DrinkType type) {
        this.type = type;
    }

    /**
     * Sets the sweetener type.
     *
     * @param sweetener the new sweetener
     */
    public void setSweetener(SweetenerType sweetener) {
        this.sweetener = sweetener;
    }

    /**
     * Sets the sweetness level.
     *
     * @param sweetnessLevel a value between 0 and 1.25
     */
    public void setSweetnessLevel(double sweetnessLevel) {
        this.sweetnessLevel = sweetnessLevel;
    }

    /**
     * Sets whether the drink is iced.
     *
     * @param iced true for iced, false for hot
     */
    public void setIced(boolean iced) {
        isIced = iced;
    }

    /**
     * Sets the drink's ice level.
     *
     * @param iceLevel a value between 0 and 1.25
     */
    public void setIceLevel(double iceLevel) {
        this.iceLevel = iceLevel;
    }

    /**
     * Attempts to add a topping to the drink.
     * Maximum allowed toppings: 5.
     *
     * @param topping the topping to add
     * @return true if added successfully, false if limit reached
     */
    public boolean addTopping(Topping topping) {
        if (toppings.size() < 5) {
            return this.toppings.add(topping);
        }
        else { //when drink already has 5 toppings, can't add more
            return false;
        }
    }

    /**
     * Removes the given topping from the drink.
     *
     * @param topping the topping to remove
     * @return true if removed, false if not found
     */
    public boolean removeTopping(Topping topping) {
        return this.toppings.remove(topping);
    }

    /**
     * Sets whether the drink has the plushie cup upgrade.
     *
     * @param hasPlushie whether the upgrade is included
     */
    public void setHasPlushie(boolean hasPlushie) {
        this.hasPlushie = hasPlushie;
    }

    // *** OTHER ***

    /**
     * Calculates the subtotal for properties shared by all drink types,
     * including: size, type, sweetener, toppings, plushie upgrade.
     * Allows child classes to use for less repetitive code.
     *
     * @return the shared drink price
     */
    protected double calculateSharedPrice() {
        double sharedPrice = size.getPrice() + type.getPrice() + sweetener.getPrice();

        sharedPrice += getToppingPrice();

        if (hasPlushie()) {
            sharedPrice += getPlushiePrice();
        }

        return sharedPrice;
    }

    /**
     * Returns the display category order used for sorting menu items.
     * Drinks are 0 (first).
     *
     * @return the category order index
     */
    @Override
    public int getCategoryOrder() {
        return 0;
    }

    /**
     * Returns a descriptive Receipt string representation of the drink,
     * including size, temperature, name, pricing, sweetness, ice, toppings,
     * and plushie upgrade details.
     *
     * @return formatted receipt string
     */
    @Override
    public String toString() {
        final String spacing = "   ";

        StringBuilder sb = new StringBuilder();

        //size
        String firstLine = spacing + size.getAbbreviation();

        //iced or hot
        if (isIced) {
            firstLine = firstLine + " Iced ";
        } else {
            firstLine = firstLine + " Hot ";
        }

        //custom or signature name
        firstLine = firstLine + getDisplayName();

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
                sb.append(toppings.get(i).getName())
                        .append(String.format(" ($%.2f)", toppings.get(i).getPrice()));
                if (i < toppings.size() - 1) {
                    sb.append("\n\t   ");
                }
            }
        }

        //plushie
        if (hasPlushie) {
            sb.append(String.format("%n\t%sPlushie Cup Upgrade ($%.2f)",
                    spacing, getPlushiePrice()));
        }

        return sb.toString();
    }

    /**
     * Returns a compact one-line string describing the drink,
     * used for order summaries.
     *
     * @return short-form drink description
     */
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

        //custom or signature name
        sb.append(getDisplayName());

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
