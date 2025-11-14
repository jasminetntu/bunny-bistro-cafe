package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Tea extends Drink {
    private TeaType teaType;
    private final ArrayList<TeaFlavor> flavors; //max 3

    // *** CONSTRUCTORS ***

    /**
     * Creates a medium iced tea with default drink values, black tea, no flavors.
     */
    public Tea() {
        super();
        this.teaType = TeaType.BLACK;
        this.flavors = new ArrayList<>();
    }

    /**
     * Full constructor for a tea with all customizable drink attributes.
     *
     * @param size the size of the drink
     * @param type the drink type
     * @param sweetener the type of sweetener
     * @param sweetnessLevel the sweetness level (0-1)
     * @param isIced whether the drink is iced
     * @param iceLevel the ice level (0-1)
     * @param toppings list of {@link Topping} objects
     * @param hasPlushie whether the drink includes a plushie
     * @param teaType the type of tea
     * @param flavors list of {@link TeaFlavor} objects (max 3)
     */
    public Tea(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
               boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie,
               TeaType teaType, ArrayList<TeaFlavor> flavors) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.teaType = teaType;
        this.flavors = flavors;
    }

    /**
     * Constructor with only toppings, tea type, and flavors.
     * Uses default values for size (medium), type (tea), sweetener (cane sugar).
     *
     * @param toppings list of {@link Topping} objects
     * @param teaType the type of tea
     * @param flavors list of {@link TeaFlavor} objects (max 3)
     */
    public Tea(ArrayList<Topping> toppings, TeaType teaType, ArrayList<TeaFlavor> flavors) {
        super(DrinkSize.MEDIUM, DrinkType.TEA, SweetenerType.CANE_SUGAR, 1, true, 1, toppings, false);
        this.teaType = teaType;
        this.flavors = flavors;
    }

    // *** GETTERS ***

    /**
     * Returns the type of tea used in this drink.
     *
     * @return the tea type
     */
    public TeaType getTeaType() {
        return teaType;
    }

    /**
     * Returns an unmodifiable list of flavors added to this tea.
     *
     * @return list of {@link TeaFlavor} objects
     */
    public List<TeaFlavor> getFlavors() {
        return Collections.unmodifiableList(flavors);
    }

    /**
     * Calculates the total price of all flavors in this tea.
     *
     * @return total flavor price
     */
    public double getFlavorPrice() {
        double price = 0;
        if (!flavors.isEmpty()) { //add constant flavor price
            price += flavors.size() * flavors.get(0).getPrice();
        }
        return price;
    }

    /**
     * Calculates the total price of this tea, including shared drink price and flavors.
     *
     * @return total price of the tea
     */
    @Override
    public double getPrice() {
        return calculateSharedPrice() + getFlavorPrice();
    }

    // *** SETTERS ***

    /**
     * Sets the type of tea for this drink.
     *
     * @param teaType the tea type to set
     */
    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    /**
     * Adds a flavor to the tea. Maximum of 3 flavors allowed.
     *
     * @param flavor the {@link TeaFlavor} to add
     * @return true if the flavor was added, false if maximum reached
     */
    public boolean addFlavor(TeaFlavor flavor) {
        if (flavors.size() < 3) {
            return flavors.add(flavor);
        }
        else { //when milk tea already has 3 flavors, can't add more
            return false;
        }
    }

    /**
     * Removes a flavor from the tea.
     *
     * @param flavor the {@link TeaFlavor} to remove
     * @return true if the flavor was removed, false if it was not found
     */
    public boolean removeFlavor(TeaFlavor flavor) {
        return flavors.remove(flavor);
    }

    // *** OTHER ***

    /**
     * Returns a Receipt string representation of the tea with price.
     *
     * @return detailed string representation
     */
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

    /**
     * Returns a short, single-line string representation of the tea for compact display.
     *
     * @return short string representation
     */
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
