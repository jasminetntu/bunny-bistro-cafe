package com.bunnybistrocafe.util;

import com.bunnybistrocafe.controllers.DrinkCustomizer;
import com.bunnybistrocafe.enumerations.drinkcustomizations.*;
import com.bunnybistrocafe.models.Drink;
import com.bunnybistrocafe.models.Order;
import com.bunnybistrocafe.models.Tea;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class ReceiptWriterTest {
    @Test
    public void getReceipt_oneSmallBasicMatcha() {
        // arrange
        // create small basic matcha
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
        Drink drink = dc.customizeDrink();

        //add to order
        Order order = new Order();
        order.addItem(drink);

        // act
        ReceiptWriter rw = new ReceiptWriter();
        String receipt = rw.getReceipt(order);

        // assert
        assertEquals("""
                   ∩_∩
                 („• •„) Bunny Bistro Cafe 🍵ིྀ༘₊˚⊹
                •··U U··················•·······················•
                ·                    Receipt 🧾                 ·
                •·······················•·······················•
                   S Iced Matcha Latte                 $6.45
                	   100% Cane Sugar
                	   100% Ice
                •·······················•·······················•
                                              Subtotal: $6.45
                                              Tax (9%): $0.58
                                                 Total: $7.03
                •·······················•·······················•""", receipt);
    }

    @Test
    public void writeToTxtFile_() {
        // arrange
        Tea mangoPassionGT = new Tea(DrinkSize.MEDIUM, DrinkType.TEA, SweetenerType.CANE_SUGAR, 0.75,
        true, 0.50, new ArrayList<>(Arrays.asList(Topping.MANGO_CHUNKS, Topping.ALOE_VERA)), true,
        TeaType.GREEN, new ArrayList<>(Arrays.asList(TeaFlavor.MANGO, TeaFlavor.PASSIONFRUIT)));

        Order order = new Order();
        order.addItem(mangoPassionGT);

        // act
        ReceiptWriter rw = new ReceiptWriter();
        try {
            rw.writeToTxtFile(order);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // assert

    }
}