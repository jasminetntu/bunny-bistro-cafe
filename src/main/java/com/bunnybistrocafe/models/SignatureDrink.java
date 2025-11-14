package com.bunnybistrocafe.models;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum SignatureDrink {
    // matcha
    MATCHA_LATTE(1, new Matcha(SweetenerType.CANE_SUGAR, new ArrayList<>(), "Matcha Latte")),
    HONEY_MATCHA_LATTE(2, new Matcha(SweetenerType.HONEY, new ArrayList<>(), "Honey Matcha Latte")),
    STRAWBERRY_MATCHA(3, new Matcha(SweetenerType.CANE_SUGAR, new ArrayList<>(List.of(Topping.STRAWBERRY_BITS)), 
            "Strawberry Matcha Latte")),
    MANGO_MATCHA(4, new Matcha(SweetenerType.CANE_SUGAR, new ArrayList<>(List.of(Topping.MANGO_CHUNKS)), 
            "Mango Matcha Latte")),
    MATCHA_CLOUD(5, new Matcha(SweetenerType.CANE_SUGAR, new ArrayList<>(List.of(Topping.CREAM_TOP)), 
            "Matcha Cloud")),

    // coffee
    VIETNAMESE_COFFEE(6, new Coffee(new ArrayList<>(), "Vietnamese Coffee", new ArrayList<>())),
    CAFFE_MOCHA(7, new Coffee(new ArrayList<>(), "Caffe Mocha", 
            new ArrayList<>(List.of(CoffeeFlavor.MOCHA)))),
    CAFFE_CARAMEL(8, new Coffee(new ArrayList<>(), "Caffe Caramel", 
            new ArrayList<>(List.of(CoffeeFlavor.CARAMEL)))),
    CAFFE_VANILLA(9, new Coffee(new ArrayList<>(), "Caffe Vanilla", 
            new ArrayList<>(List.of(CoffeeFlavor.VANILLA)))),
    CAFFE_CLOUD(10, new Coffee(new ArrayList<>(List.of(Topping.CREAM_TOP)), "Caffe Cloud", 
            new ArrayList<>())),

    // milk tea
    CLASSIC_MT(11, new MilkTea(new ArrayList<>(), "Classic Milk Tea", TeaType.BLACK, 
            new ArrayList<>())),
    JASMINE_MT(12, new MilkTea(new ArrayList<>(), "Jasmine Milk Tea", TeaType.GREEN, 
            new ArrayList<>())),
    OOLONG_MT(13, new MilkTea(new ArrayList<>(), "Oolong Milk Tea", TeaType.OOLONG, 
            new ArrayList<>())),
    THAI_MT(14, new MilkTea(new ArrayList<>(), "Thai Milk Tea", TeaType.THAI, 
            new ArrayList<>())),
    WINTERMELON_MT(15, new MilkTea(new ArrayList<>(), "Wintermelon Milk Tea", TeaType.BLACK, 
            new ArrayList<>(List.of(TeaFlavor.WINTERMELON)))),
    PEACH_OOLONG_MT(16, new MilkTea(new ArrayList<>(), "Peach Oolong Milk Tea", TeaType.OOLONG,
            new ArrayList<>(List.of(TeaFlavor.PEACH)))),
    STRAWBERRY_MT(17, new MilkTea(new ArrayList<>(), "Strawberry Milk Tea", TeaType.GREEN,
            new ArrayList<>(List.of(TeaFlavor.STRAWBERRY)))),
    MANGO_MT(18, new MilkTea(new ArrayList<>(), "Mango Milk Tea", TeaType.WHITE,
            new ArrayList<>(List.of(TeaFlavor.MANGO)))),

    // fruit tea
    BERRY_BURROW(19, new Tea(new ArrayList<>(List.of(Topping.STRAWBERRY_BITS)), "Berry Burrow",
            TeaType.BLACK, new ArrayList<>(List.of(TeaFlavor.STRAWBERRY)))),
    MANGO_HEAVEN(20, new Tea(new ArrayList<>(List.of(Topping.MANGO_CHUNKS)), "Mango Heaven",
            TeaType.GREEN, new ArrayList<>(List.of(TeaFlavor.MANGO)))),
    WATERMELON_LYCHEE_BLISS(21, new Tea(new ArrayList<>(Arrays.asList(Topping.WATERMELON_CHUNKS, Topping.LYCHEE_BITS)),
            "Watermelon Lychee Bliss", TeaType.GREEN, new ArrayList<>(Arrays.asList(TeaFlavor.WATERMELON, TeaFlavor.LYCHEE)))),
    PEACH_PARADISE(22, new Tea(new ArrayList<>(List.of(Topping.PEACH_BITS)), "Peach Paradise",
            TeaType.BLACK, new ArrayList<>(List.of(TeaFlavor.PEACH)))),
    FRUIT_OVERLOAD(23, new Tea(new ArrayList<>(Arrays.asList(Topping.WATERMELON_CHUNKS, Topping.MANGO_CHUNKS, Topping.STRAWBERRY_BITS)),
            "Fruit Overload", TeaType.GREEN, new ArrayList<>(Arrays.asList(TeaFlavor.WATERMELON, TeaFlavor.STRAWBERRY, TeaFlavor.MANGO)))),
    SUNRISE_ORCHARD(24, new Tea(new ArrayList<>(List.of(Topping.LYCHEE_JELLY)),
            "Sunrise Orchard", TeaType.GREEN, new ArrayList<>(Arrays.asList(TeaFlavor.MANGO, TeaFlavor.PASSIONFRUIT)))),
    PASSIONFRUIT_BURST(25, new Tea(new ArrayList<>(List.of(Topping.ALOE_VERA)), "Passionfruit Burst",
            TeaType.GREEN, new ArrayList<>(List.of(TeaFlavor.PASSIONFRUIT)))),
    DREAMY_LYCHEE(26, new Tea(new ArrayList<>(List.of(Topping.LYCHEE_BITS)), "Dreamy Lychee",
            TeaType.BLACK, new ArrayList<>(List.of(TeaFlavor.LYCHEE))));

    private final int num;
    private final Drink drink;

    SignatureDrink(int num, Drink drink) {
        this.num = num;
        this.drink = drink;
    }

    public int getNum() {
        return num;
    }

    public Drink getDrink() {
        return drink;
    }

    public static SignatureDrink fromNum(int num) {
        // iterate through all enum values
        for (SignatureDrink option : SignatureDrink.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}
