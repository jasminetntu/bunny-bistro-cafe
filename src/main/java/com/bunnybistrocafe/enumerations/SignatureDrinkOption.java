package com.bunnybistrocafe.enumerations;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;
import com.bunnybistrocafe.models.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum SignatureDrinkOption {
    // matcha
    MATCHA_LATTE(1, new SignatureMatcha(SweetenerType.CANE_SUGAR, new ArrayList<>(), "Matcha Latte")),
    HONEY_MATCHA_LATTE(2, new SignatureMatcha(SweetenerType.HONEY, new ArrayList<>(), "Honey Matcha Latte")),
    STRAWBERRY_MATCHA(3, new SignatureMatcha(SweetenerType.CANE_SUGAR, new ArrayList<>(List.of(Topping.STRAWBERRY_BITS)),
            "Strawberry Matcha Latte")),
    MANGO_MATCHA(4, new SignatureMatcha(SweetenerType.CANE_SUGAR, new ArrayList<>(List.of(Topping.MANGO_CHUNKS)),
            "Mango Matcha Latte")),
    MATCHA_CLOUD(5, new SignatureMatcha(SweetenerType.CANE_SUGAR, new ArrayList<>(List.of(Topping.CREAM_TOP)),
            "Matcha Cloud")),

    // coffee
    VIETNAMESE_COFFEE(6, new SignatureCoffee(new ArrayList<>(), new ArrayList<>(), "Vietnamese Coffee")),
    CAFFE_MOCHA(7, new SignatureCoffee(new ArrayList<>(), new ArrayList<>(List.of(CoffeeFlavor.MOCHA)),
            "Caffe Mocha")),
    CAFFE_CARAMEL(8, new SignatureCoffee(new ArrayList<>(), new ArrayList<>(List.of(CoffeeFlavor.CARAMEL)),
            "Caffe Caramel")),
    CAFFE_VANILLA(9, new SignatureCoffee(new ArrayList<>(), new ArrayList<>(List.of(CoffeeFlavor.VANILLA)),
            "Caffe Vanilla")),
    CAFFE_CLOUD(10, new SignatureCoffee(new ArrayList<>(List.of(Topping.CREAM_TOP)), new ArrayList<>(),
            "Caffe Cloud")),

    // milk tea
    CLASSIC_MT(11, new SignatureMilkTea(new ArrayList<>(), TeaType.BLACK, new ArrayList<>(),
            "Classic Milk Tea")),
    JASMINE_MT(12, new SignatureMilkTea(new ArrayList<>(), TeaType.GREEN, new ArrayList<>(),
            "Jasmine Milk Tea")),
    OOLONG_MT(13, new SignatureMilkTea(new ArrayList<>(), TeaType.OOLONG, new ArrayList<>(),
            "Oolong Milk Tea")),
    THAI_MT(14, new SignatureMilkTea(new ArrayList<>(), TeaType.THAI,
            new ArrayList<>(), "Thai Milk Tea")),
    WINTERMELON_MT(15, new SignatureMilkTea(new ArrayList<>(), TeaType.BLACK,
            new ArrayList<>(List.of(TeaFlavor.WINTERMELON)), "Wintermelon Milk Tea")),
    PEACH_OOLONG_MT(16, new SignatureMilkTea(new ArrayList<>(), TeaType.OOLONG,
            new ArrayList<>(List.of(TeaFlavor.PEACH)), "Peach Oolong Milk Tea")),
    STRAWBERRY_MT(17, new SignatureMilkTea(new ArrayList<>(), TeaType.GREEN,
            new ArrayList<>(List.of(TeaFlavor.STRAWBERRY)), "Strawberry Milk Tea")),
    MANGO_MT(18, new SignatureMilkTea(new ArrayList<>(), TeaType.WHITE,
            new ArrayList<>(List.of(TeaFlavor.MANGO)), "Mango Milk Tea")),

    // fruit tea
    BERRY_BURROW(19, new SignatureTea(new ArrayList<>(List.of(Topping.STRAWBERRY_BITS)),
            TeaType.BLACK, new ArrayList<>(List.of(TeaFlavor.STRAWBERRY)), "Berry Burrow")),
    MANGO_HEAVEN(20, new SignatureTea(new ArrayList<>(List.of(Topping.MANGO_CHUNKS)),
            TeaType.GREEN, new ArrayList<>(List.of(TeaFlavor.MANGO)), "Mango Heaven")),
    WATERMELON_LYCHEE_BLISS(21, new SignatureTea(new ArrayList<>(Arrays.asList(Topping.WATERMELON_CHUNKS, Topping.LYCHEE_BITS)),
            TeaType.GREEN, new ArrayList<>(Arrays.asList(TeaFlavor.WATERMELON, TeaFlavor.LYCHEE)), "Watermelon Lychee Bliss")),
    PEACH_PARADISE(22, new SignatureTea(new ArrayList<>(List.of(Topping.PEACH_BITS)), TeaType.BLACK,
            new ArrayList<>(List.of(TeaFlavor.PEACH)), "Peach Paradise")),
    FRUIT_OVERLOAD(23, new SignatureTea(new ArrayList<>(Arrays.asList(Topping.WATERMELON_CHUNKS, Topping.MANGO_CHUNKS, Topping.STRAWBERRY_BITS)),
            TeaType.GREEN, new ArrayList<>(Arrays.asList(TeaFlavor.WATERMELON, TeaFlavor.STRAWBERRY, TeaFlavor.MANGO)), "Fruit Overload")),
    SUNRISE_ORCHARD(24, new SignatureTea(new ArrayList<>(List.of(Topping.LYCHEE_JELLY)), TeaType.GREEN,
            new ArrayList<>(Arrays.asList(TeaFlavor.MANGO, TeaFlavor.PASSIONFRUIT)), "Sunrise Orchard")),
    PASSIONFRUIT_BURST(25, new SignatureTea(new ArrayList<>(List.of(Topping.ALOE_VERA)), TeaType.GREEN,
            new ArrayList<>(List.of(TeaFlavor.PASSIONFRUIT)), "Passionfruit Burst")),
    DREAMY_LYCHEE(26, new SignatureTea(new ArrayList<>(List.of(Topping.LYCHEE_BITS)), TeaType.BLACK,
            new ArrayList<>(List.of(TeaFlavor.LYCHEE)), "Dreamy Lychee"));

    private final int num;
    private final Drink drink;

    SignatureDrinkOption(int num, Drink drink) {
        this.num = num;
        this.drink = drink;
    }

    public int getNum() {
        return num;
    }

    public Drink getDrink() {
        return drink;
    }

    public static SignatureDrinkOption fromNum(int num) {
        // iterate through all enum values
        for (SignatureDrinkOption option : SignatureDrinkOption.values()) {
            // check if input letter matches associated letter
            if (option.num == num) {
                return option;
            }
        }

        // if no match is found, throw exception
        throw new IllegalArgumentException();
    }
}
