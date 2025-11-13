package com.bunnybistrocafe.util;

import java.util.Scanner;

public class UserInterface {
    // *** TOOLS ***
    /**
     * Waits for user to press enter for better menu flow.
     *
     * @param scnr Scanner object
     */
    public static void waitForKey(Scanner scnr) {
        System.out.print("\n> Press ENTER to continue...");
        scnr.nextLine();
    }

    /**
     * Prints a 1000 ms (1.0 s) loading bar.
     * @param loadingMessage the message to print before loading bar
     * @throws InterruptedException if sleep is interrupted
     */
    public static void loadingBar(String loadingMessage) throws InterruptedException {
        System.out.println("\n⊹ ࣪ ˖ " + loadingMessage);

        for (int i = 0; i < 10; ++i) {
            Thread.sleep(100);
            System.out.print("▒▒▒");
        }
        System.out.println();
        Thread.sleep(200);
    }

    // *** MENUS ***
    public static void printHomeMenu() {
        System.out.print("""
                
                   ∩_∩
                 („• •„)
                •··U U··················•·······················•
                           Welcome to Bunny Bistro! 🍵ིྀ༘₊˚⊹
                •·······················•·······················•
                What would you like to do?
                    (N) 🔖 New order
                    (X) 👋 Exit
                
                > Enter choice (N, X):\s""");
    }

    public static void printOrderMenu() {
        System.out.print("""
                
                   ∩_∩
                 („• •„)
                •··U U··················•·······················•
                                 Current Order 🔖
                •·······················•·······················•
                What would you like to do?
                    (1) 🍵 Add drink
                    (2) 🍰 Add pastry
                    (3) 🥗 Add entree
                    (4) 💭 View order summary
                    (5) 🧾 Checkout
                
                    (R) Return to home (cancel order)
                
                > Enter choice (1-5, R):\s""");
    }

    public static void printDrinkMenu() {
        System.out.print("""
                
                   ∩_∩
                 („• •„)
                •··U U··················•·······················•
                                 Add a drink 🍵
                •·······················•·······················•
                View...
                    (1) 🧋 Signature Drinks (TBA)
                    (2) 🍃 Seasonal Drinks (TBA)
                    (3) 📝 Custom Drink
                
                    (R) Return to order
                
                > Enter choice (1-3, R):\s""");
    }

    public static void printPastryMenu() {
        System.out.print("""
                
                   ∩_∩
                 („• •„)
                •··U U··················•·······················•
                                   Add pastry 🍰
                •·······················•·······················•
                Add...
                    (1) 🥐 Plain croissant           $2.50
                    (2) 🍓 Strawberry croissant      $6.00
                    (3) 🥭 Mango croissant           $6.00
                    (4) 🍌 Banana bread              $4.00
                    (5) ☕️ Coffee cake               $4.00
                    (6) 🍪 Chocolate-chip cookie     $2.00
                    (7) 🫐 Fruit tart                $5.00
                    (8) 🍩 Glazed donut              $2.00
                    (9) 🍰 Strawberry sando          $8.00
                
                    (R) Return to order
                
                > Enter choice (1-9, R):\s""");
    }

    public static void printEntreeMenu() {
        System.out.print("""
                
                   ∩_∩
                 („• •„)
                •··U U··················•·······················•
                                  Add entree 🥗
                •·······················•·······················•
                Add...
                    (1) 🍳 Egg Sando                 $7.00
                    (2) 🥗 House Salad               $10.00
                    (3) 🍗 Chicken Katsu Sando       $12.50
                    (4) 🥞 Savory Crepe              $15.00
                
                    (R) Return to order
                
                > Enter choice (1-4, R):\s""");
    }

    public static void printCheckoutMenu() {
        System.out.print("""
                                    Checkout 🛍️
                •·······················•·······················•
                    (Y) ✅ Confirm order
                    (N) ❌ Cancel order
                
                    (R) Return to order
                > Enter choice (Y, N, R):\s""");
    }

    public static void printSignatureDrinkMenu() {
        System.out.print("""
                Signature drinks TBA.""");
    }

    // *** DRINK CUSTOMIZATION OPTIONS ***
    public static void printSizeOptions() {
        System.out.println("""
                
                •···················•···················•
                ·             Choose Size 🧋            ·
                •···················•···················•
                ·   (S) Small                   $4.95   ·
                ·   (M) Medium (default)        $5.95   ·
                ·   (L) Large                   $6.95   ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                •···················•···················•
                """);
    }

    public static void printDrinkTypeOptions() {
        System.out.print("""
                
                •···················•···················•
                ·             Choose Drink 🥤           ·
                •···················•···················•
                ·   (M)  🍵 Matcha Latte       +$1.50   ·
                ·   (C)  ☕️ Caffe Latte        +$1.00   ·
                ·   (MT) 🧋 Milk Tea                    ·
                ·   (T)  🫖 Tea                         ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                •···················•···················•
                """);
    }

    public static void printTeaTypeOptions() {
        System.out.print("""
                
                •···················•···················•
                ·              Choose Tea 🫖            ·
                •···················•···················•
                ·   (B) ⚫️ Black Tea                    ·
                ·   (G) 🟢 Green Tea                    ·
                ·   (O) 🟤 Oolong Tea                   ·
                ·   (T) 🟠 Thai Tea                     ·
                ·   (W) ⚪️ White Tea                    ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                •···················•···················•
                """);
    }

    public static void printTeaFlavorOptions() {
        System.out.print("""
                
                •···················•···················•
                ·            Choose Flavor(s) 🫖        ·
                ·        +$0.25 per flavor (3 max)      ·
                •···················•···················•
                ·   (1) 🍓 Strawberry                   ·
                ·   (2) 🥭 Mango                        ·
                ·   (3) 🏵️️ Passionfruit                 ·
                ·   (4) 🍑 Peach                        ·
                ·   (5) 🌴 Lychee                       ·
                ·   (6) 🍉 Watermelon                   ·
                ·   (7) 🍈 Wintermelon                  ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                ·                                       ·
                · *Separate flavor numbers w/ comma.    ·
                · *Leave blank & enter to skip.         ·
                •···················•···················•
                """);
    }

    public static void printIcedOrHotOptions() {
        System.out.print("""
                
                •···················•···················•
                ·           Iced 🧊 or Hot 🔥?          ·
                •···················•···················•
                ·   (I) 🧊 Iced (default)               ·
                ·   (H) 🔥 Hot                          ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                •···················•···················•
                """);
    }

    public static void printCoffeeFlavorOptions() {
        System.out.print("""
                
                •···················•···················•
                ·           Choose Flavor(s) ☕️         ·
                ·       +$0.25 per flavor (2 max)       ·
                •···················•···················•
                ·   (M) 🍫 Mocha                        ·
                ·   (C) 🍮 Caramel                      ·
                ·   (V) 🍦 Vanilla                      ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                ·                                       ·
                · *Separate flavor numbers w/ comma.    ·
                · *Leave blank & enter to skip.         ·
                •···················•···················•
                """);
    }

    public static void printSweetenerTypeOptions() {
        System.out.print("""
                
                •···················•···················•
                ·           Choose Sweetener 🍭         ·
                •···················•···················•
                ·   (C) 🎋 Cane Sugar (default)         ·
                ·   (S) 🌱 Stevia                       ·
                ·   (H) 🍯 Honey               +$0.50   ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                •···················•···················•
                """);
    }

    public static void printSweetnessLevelOptions() {
        System.out.print("""
                
                •···················•···················•
                ·       Choose Sweetness Level 🍭       ·
                •···················•···················•
                ·   > 125%                              ·
                ·   > 100% (default)                    ·
                ·   > 75%                               ·
                ·   > 50%                               ·
                ·   > 25%                               ·
                ·   > 0%                                ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                ·                                       ·
                · *Don't include '%' in choice.         ·
                •···················•···················•
                """);
    }

    public static void printIceLevelOptions() {
        System.out.print("""
                
                •···················•···················•
                ·           Choose Ice Level 🧊         ·
                •···················•···················•
                ·   > 125%                              ·
                ·   > 100% (default)                    ·
                ·   > 75%                               ·
                ·   > 50%                               ·
                ·   > 25%                               ·
                ·   > 0%                                ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                ·                                       ·
                · *Don't include '%' in choice.         ·
                •···················•···················•
                """);
    }

    public static void printMilkTypeOptions() {
        System.out.print("""
                
                •···················•···················•
                ·             Choose Milk 🥛            ·
                •···················•···················•
                ·   (W) Whole Milk (default)            ·
                ·   (N) Non-dairy Creamer               ·
                ·   (O) Oat Milk               +$0.50   ·
                ·   (A) Almond Milk            +$0.50   ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                •···················•···················•
                """);
    }

    public static void printToppingOptions() {
        System.out.print("""
                
                •···················•···················•···················•···················•
                ·                              Choose Topping(s) 🍬                             ·
                ·                                    (5 max)                                    ·
                •···················•···················•···················•···················•
                · 🌸 Regular Toppings (+$0.75 each)     · 🌟 Premium Toppings (+$1.00 each)     ·
                ·   (1)  Boba/Tapioca Pearls            ·       11) Cream Top                   ·
                ·   (2)  Crystal Boba                   ·       12) Taro Chunks                 ·
                ·   (3)  Aloe Vera                      ·       13) Red Bean Chunks             ·
                ·   (4)  Grass Jelly                    ·       14) Creme Brulee                ·
                ·   (5)  Lychee Jelly                   ·                                       ·
                ·   (6)  Strawberry Bits                ·                                       ·
                ·   (7)  Mango Chunks                   ·                                       ·
                ·   (8)  Lychee Bits                    ·                                       ·
                ·   (9)  Peach Bits                     ·                                       ·
                ·   (10) Watermelon Chunks              ·                                       ·
                •···················•···················•···················•···················•
                ·   (R) Return to order (cancel drink)                                          ·
                ·                                                                               ·
                · *Separate topping numbers w/ comma.    *You can have duplicate toppings.      ·
                · *Leave blank & enter to skip.                                                 ·
                •···················•···················•···················•···················•
                """);
    }

    public static void printPlushieOptions() {
        System.out.print("""
                
                •···················•···················•
                ·      Upgrade to a plushie cup? 🧸     ·
                •···················•···················•
                ·   (Y) 👍 Yes                          ·
                ·   (N) 👎 No                           ·
                ·                                       ·
                ·   (R) Return to order (cancel drink)  ·
                •···················•···················•
                """);
    }

}