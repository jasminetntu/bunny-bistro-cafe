package com.bunnybistrocafe.controllers;

import com.bunnybistrocafe.enumerations.drinkcustomizations.*;
import com.bunnybistrocafe.enumerations.drinkcustomizations.SweetenerType;
import com.bunnybistrocafe.models.*;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DrinkCustomizerTest {
    @Test
    public void customizeDrink_smallBasicMatcha() {
        // arrange
        // create simulated user input & feed into scanner
        String simulatedInput = String.join("\n",
                "S",      // size -> small
                "M",      // drink type -> matcha
                "I",      // iced
                "C",      // sweetener type -> cane
                "100",    // sweetness -> 100%, 1
                "100",    // ice -> 100%, 1
                "W",      // milk type -> whole
                "",       // topping -> none
                "N"       // plushie -> no
        ) + "\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scnr = new Scanner(inputStream);
        DrinkCustomizer dc = new DrinkCustomizer(scnr);
        double expectedPrice = 6.45;

        // act
        Drink drink = dc.customizeDrink();

        // assert
        assertEquals(DrinkSize.SMALL, drink.getSize());
        assertInstanceOf(Matcha.class, drink);
        assertTrue(drink.isIced());
        assertEquals(SweetenerType.CANE_SUGAR, drink.getSweetener());
        assertEquals(1.0, drink.getSweetnessLevel());
        assertEquals(1.0, drink.getIceLevel());
        assertEquals(MilkType.WHOLE, ((Matcha) drink).getMilk());
        assertEquals(0, drink.getToppings().size());
        assertFalse(drink.hasPlushie());
        assertEquals(expectedPrice, drink.getPrice());
    }

    @Test
    public void customizeDrink_smallBasicHotCoffee() {
        // arrange
        // create simulated user input & feed into scanner
        String simulatedInput = String.join("\n",
                "S",      // size -> small
                "C",      // drink type -> coffee
                "H",      // hot
                "",       // flavors -> none
                "C",      // sweetener type -> cane
                "100",    // sweetness -> 100%, 1
                "100",    // ice -> 100%, 1
                "W",      // milk type -> whole
                "",       // topping -> none
                "N"       // plushie -> no
        ) + "\n";

        ByteArrayInputStream inputStream = new ByteArrayInputStream(simulatedInput.getBytes());
        Scanner scnr = new Scanner(inputStream);
        DrinkCustomizer dc = new DrinkCustomizer(scnr);
        double expectedPrice = 5.95;

        // act
        Drink drink = dc.customizeDrink();

        // assert
        assertEquals(DrinkSize.SMALL, drink.getSize());
        assertInstanceOf(Coffee.class, drink);
        assertFalse(drink.isIced());
        assertEquals(0, ((Coffee) drink).getFlavors().size());
        assertEquals(SweetenerType.CANE_SUGAR, drink.getSweetener());
        assertEquals(1.0, drink.getSweetnessLevel());
        assertEquals(1.0, drink.getIceLevel());
        assertEquals(MilkType.WHOLE, ((Coffee) drink).getMilk());
        assertEquals(0, drink.getToppings().size());
        assertFalse(drink.hasPlushie());
        assertEquals(expectedPrice, drink.getPrice());
    }



//    @Test
//    public void template() {
//        // arrange
//
//
//        // act
//
//
//        // assert
//    }
}