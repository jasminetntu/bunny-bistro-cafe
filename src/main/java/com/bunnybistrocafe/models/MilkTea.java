package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MilkTea extends Drink {
    private TeaType teaType;
    private MilkType milk;
    private final ArrayList<TeaFlavor> flavors; //max 3

    // *** CONSTRUCTORS ***

    /**
     * Creates a medium iced milk tea with standard base settings + black tea, whole milk, no flavors.
     */
    public MilkTea() {
        super();
        this.teaType = TeaType.BLACK;
        this.milk = MilkType.WHOLE;
        this.flavors = new ArrayList<>();
    }

    /**
     * Full constructor for MilkTea.
     *
     * @param size the size of the drink
     * @param type the drink type
     * @param sweetener the type of sweetener
     * @param sweetnessLevel the sweetness level (0-1)
     * @param isIced whether the drink is iced
     * @param iceLevel the ice level (0-1)
     * @param toppings list of toppings
     * @param hasPlushie whether the drink comes with a plushie
     * @param teaType the type of tea
     * @param milk the type of milk
     * @param flavors list of flavors (max 3)
     */
    public MilkTea(DrinkSize size, DrinkType type, SweetenerType sweetener, double sweetnessLevel,
                   boolean isIced, double iceLevel, ArrayList<Topping> toppings, boolean hasPlushie,
                   TeaType teaType, MilkType milk, ArrayList<TeaFlavor> flavors) {
        super(size, type, sweetener, sweetnessLevel, isIced, iceLevel, toppings, hasPlushie);
        this.teaType = teaType;
        this.milk = milk;
        this.flavors = flavors;
    }

    /**
     * Constructor with only toppings, tea type, and flavors.
     * Uses default values for other attributes.
     *
     * @param toppings list of toppings
     * @param teaType the type of tea
     * @param flavors list of flavors (max 3)
     */
    public MilkTea(ArrayList<Topping> toppings, TeaType teaType, ArrayList<TeaFlavor> flavors) {
        super(DrinkSize.MEDIUM, DrinkType.MILK_TEA, SweetenerType.CANE_SUGAR, 1, true, 1, toppings, false);
        this.teaType = teaType;
        this.milk = MilkType.WHOLE;
        this.flavors = flavors;
    }

    // *** GETTERS ***

    /**
     * Returns the type of tea used in this milk tea.
     *
     * @return the tea type
     */
    public TeaType getTeaType() {
        return teaType;
    }

    /**
     * Returns the type of milk used in this milk tea.
     *
     * @return the milk type
     */
    public MilkType getMilk() {
        return milk;
    }

    /**
     * Returns an unmodifiable list of flavors added to this milk tea.
     *
     * @return list of flavors
     */
    public List<TeaFlavor> getFlavors() {
        return Collections.unmodifiableList(flavors);
    }

    /**
     * Calculates total price of all flavors in this milk tea.
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
     * Calculates the total price of this milk tea, including shared drink price, milk, and flavors.
     *
     * @return total price of the milk tea
     */
    @Override
    public double getPrice() {
        return calculateSharedPrice() + milk.getPrice() + getFlavorPrice();
    }

    // *** SETTERS ***

    /**
     * Sets the type of tea for this milk tea.
     *
     * @param teaType the tea type to set
     */
    public void setTeaType(TeaType teaType) {
        this.teaType = teaType;
    }

    /**
     * Sets the type of milk for this milk tea.
     *
     * @param milk the milk type to set
     */
    public void setMilk(MilkType milk) {
        this.milk = milk;
    }

    /**
     * Adds a flavor to the milk tea.
     * Maximum of 3 flavors allowed.
     *
     * @param flavor the flavor to add
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
     * Removes a flavor from the milk tea.
     *
     * @param flavor the flavor to remove
     * @return true if the flavor was removed, false if it was not found
     */
    public boolean removeFlavor(TeaFlavor flavor) {
        return flavors.remove(flavor);
    }

    // *** OTHER ***

    /**
     * Returns a Receipt string representation of the milk tea with price.
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

        //milk
        sb.append(String.format("%n\t%s", spacing))
                .append(milk.getName());
        if (milk.getPrice() > 0) {
            sb.append(String.format(" ($%.2f)", milk.getPrice()));
        }

        return sb.toString();
    }

    /**
     * Returns a short, single-line string representation of the milk tea for order summary.
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

        //milk
        sb.append(" | ").append(milk.getName());

        return sb.toString();
    }
}
