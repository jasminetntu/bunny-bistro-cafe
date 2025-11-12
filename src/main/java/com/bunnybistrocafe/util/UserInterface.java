package com.bunnybistrocafe.util;

public class UserInterface {
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
                   ∩_∩
                 („• •„)
                •··U U··················•·······················•
                                    Checkout 🧾
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
}
