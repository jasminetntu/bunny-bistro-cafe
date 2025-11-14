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


// PART 2 - Line 72 in OrderScreen.java

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

### 🧋 Future Features
Possible future enhancements include:
- **Quality of Life:**
  - Remove items from order.
  - Display signature drink details before asking if they want to customize.
  - Ask confirm/cancel for signature drink.
  - Add colored headers & unique logo.
- **User Accounts + Login System:** Save user profiles or allow guests.
- **Rewards Program:** Earn points, redeem discounts, and view order history.
- **Extended Menu Items:** Seasonal rotations, custom pastry options, and more.
- **Order History:** Store previous orders in a user's profile.
- **Character sets:** Ensure emojis are viewable on all systems/devices.

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

## 📸 Screenshots

### .☘︎ ݁˖ Home Screen
<img width="405" height="239" alt="image" src="https://github.com/user-attachments/assets/cdd4c5c2-9c54-469e-ae61-05d23f260832" />

### .☘︎ ݁˖ Order Screen
<img width="405" height="414" alt="image" src="https://github.com/user-attachments/assets/69064b6f-d6ea-46d1-9d85-2b96e12d2520" />

### .☘︎ ݁˖ Drink Screen
<img width="405" height="338" alt="image" src="https://github.com/user-attachments/assets/9df2413f-92bc-411b-9a9c-09655b27cfe1" />

### .☘︎ ݁˖ Signature Drink Screen
<img width="650" height="507" alt="image" src="https://github.com/user-attachments/assets/1c4eb105-7277-4ec6-bda4-8029caa55eef" />

### .☘︎ ݁˖ Drink Customization Example (Toppings)
<img width="650" height="487" alt="image" src="https://github.com/user-attachments/assets/7f91fcfc-d69a-43ff-ae73-a9b06681bbe4" />

### .☘︎ ݁˖ Pastry Screen
<img width="401" height="487" alt="image" src="https://github.com/user-attachments/assets/06e90352-9489-413d-b3b6-e75ef2be9202" />

### .☘︎ ݁˖ Entree Screen
<img width="401" height="387" alt="image" src="https://github.com/user-attachments/assets/c2442f2c-557f-4981-b2ba-490195001b60" />

### .☘︎ ݁˖ View Order Example
<img width="754" height="312" alt="image" src="https://github.com/user-attachments/assets/5c282279-6a96-4dab-b636-f6dd7d864d89" />

### .☘︎ ݁˖ Checkout Screen & Receipt
<img width="402" height="707" alt="image" src="https://github.com/user-attachments/assets/5d3ec6cc-3a12-4024-8598-cc554953911e" />

### .☘︎ ݁˖ .txt File
<img width="465" height="630" alt="image" src="https://github.com/user-attachments/assets/024666fa-6734-4551-afd5-845c0799b869" />



