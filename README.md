# Bunny Bistro Cafe 🍵₊˚⊹
> **Capstone 2: Custom Food Shop Application**
>
> Year Up United (Bay Bytes) - _Technical Academy Fall 2025_
---

## 🐰 Description
A custom food shop application interactable through the console, designed for a fictional cafe named "Bunny Bistro." This tool helps the cafe's customers easily order items, similar to a kiosk in the cafe or an online ordering app. Users can browse the café menu, customize items, build orders, and generate receipts.

Built entirely in Java to practice application development, specifically to gain familiarity with project structure, OOP principles (inheritance, encapsulation, polymorphism, abstraction), and unit testing.

### 🗝️ Key Features
- **Order Management:** Add multiple entrees, pastries, and drinks to your order.  
- **Signature & Custom Drinks:**  
  - Choose from a curated list of **26 signature drinks**, OR  
  - Build your own custom drink by selecting base type, toppings, flavors, sweetness, ice, and more.
  - Customize existing signature drinks.  
- **Receipt Generation:** Automatically prints a formatted receipt to a `.txt` file when order is confirmed.
- **Cancel Options:** Cancel your order anytime.

---

### ☕️ UML Diagram
See **[UML_Diagram.md](UML_Diagram.md)** for the full class structure and relationships.

---

### 💭 Interesting Piece of Code
``` java
// PART 1 - Line 74 in Drink.java

  public List<Topping> getToppings() {
        return Collections.unmodifiableList(toppings);
    }


// PASRT 2 - Line 72 in OrderScreen.java

  CheckoutScreen cs = new CheckoutScreen(scnr, orderManager);
  cs.displayScreen();
  
  if (cs.isBackToHome()) {
      UserInterface.loadingBar("⮐ Confirming choice & returning to home...");
      isRunning = false;
  }
```

🌟 These 2 code snippets are interesting to me because the first exemplifies the importance of encapsulation, and the 2nd was a neat get-around for screen navigation.

(1) I didn't want programmers to be able to access the ArrayList of Toppings directly because that would introduce errors! I wanted them to only be able to add toppings through the specified `addTopping()` and `removeTopping()` methods. However, I still wanted to be able to access the toppings for viewing. I took advantage of Collections and returned an unmodifiable list, fulfilling both objectives.

(2) I wanted to include a `Return to order` option in case the users wanted to add anything else after they viewed their receipt. However, it kept returning to the home screen because I had the `isRunning = false` line for all options. However, I didn't want to create another HomeScreen instance because that would introduce an infinite nest of stack calls/screen navigation. 

There wasn't an easy way to know whether or not the user wanted to Confirm/Cancel their order (back to home) or return to order. To bypass this, I introduced a private boolean attribute in the `CheckoutScreen.java` class. This allowed me to access whether or not the user wanted to return to home and deal with it accordingly.

---

## 📁 File Structure
```
src/
├── main/
│   ├── java/
│   │   ├── com.bunnybistrocafe/
│   │   │   ├── Main.java                               // entry point
│   │   │   │
│   │   │   ├── controllers/                            // controllers
│   │   │   │   ├── DrinkCustomizer.java
│   │   │   │   └── OrderManager.java
│   │   │   │
│   │   │   ├── enumerations/                           // enums
│   │   │   │   ├── drinkcustomizations/
│   │   │   │   │   ├── CoffeeFlavor.java
│   │   │   │   │   ├── DrinkSize.java
│   │   │   │   │   ├── DrinkType.java
│   │   │   │   │   ├── MilkType.java
│   │   │   │   │   ├── SweetenerType.java
│   │   │   │   │   ├── TeaFlavor.java
│   │   │   │   │   ├── TeaType.java
│   │   │   │   │   └── Topping.java
│   │   │   │   │
│   │   │   │   ├── ActionOption.java
│   │   │   │   ├── DrinkOption.java
│   │   │   │   ├── HomeOption.java
│   │   │   │   ├── OrderOption.java
│   │   │   │   └── SignatureDrinkOption.java
│   │   │   │
│   │   │   ├── models/                                 // model classes
│   │   │   │   ├── Coffee.java
│   │   │   │   ├── Drink.java
│   │   │   │   ├── Entree.java
│   │   │   │   ├── Matcha.java
│   │   │   │   ├── MenuItem.java
│   │   │   │   ├── MilkTea.java
│   │   │   │   ├── Order.java
│   │   │   │   ├── Pastry.java
│   │   │   │   ├── SignatureCoffee.java
│   │   │   │   ├── SignatureMatcha.java
│   │   │   │   ├── SignatureMilkTea.java
│   │   │   │   ├── SignatureTea.java
│   │   │   │   └── Tea.java
│   │   │   │
│   │   │   ├── ui/                                     // screen/menu classes
│   │   │   │   ├── CheckoutScreen.java
│   │   │   │   ├── DrinkScreen.java
│   │   │   │   ├── EntreeScreen.java
│   │   │   │   ├── HomeScreen.java
│   │   │   │   ├── OrderScreen.java
│   │   │   │   ├── PastryScreen.java
│   │   │   │   └── Screen.java
│   │   │   │
│   │   │   ├── util/                                   // utility classes
│   │   │   │   ├── ReceiptWriter.java
│   │   │   │   └── UserInterface.java
│   │   │
│   └── resources/
│
├── test/                                               // unit tests
│
├── target/                                             // build output
│
├── receipts/                                           // generated receipt files
│
├── pom.xml                                             // Maven configuration
├── README.md
└── UML_Diagram.md
```

---

### 🧋 Future Features
Future enhancements include:
- **Item removal:** Remove items from order.
- **User Accounts + Login System:** Save user profiles or allow guests.
- **Rewards Program:** Earn points, redeem discounts, and view order history.
- **Extended Menu Items:** Seasonal rotations, custom pastry options, and more.
- **Order History:** Store previous orders in a user's profile.

---

## 📸 Screenshots

### .☘︎ ݁˖ Home Screen


### .☘︎ ݁˖ Order Screen


### .☘︎ ݁˖ Drink Screen


### .☘︎ ݁˖ Signature Drink Screen


### .☘︎ ݁˖ Drink Customization Example (Toppings)


### .☘︎ ݁˖ Pastry Screen


### .☘︎ ݁˖ Entree Screen


### .☘︎ ݁˖ View Order Example


### .☘︎ ݁˖ Checkout Screen



