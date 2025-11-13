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
                "S",      // size
                "M",      // drink type (Matcha)
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