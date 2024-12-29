# What is the Template Design Pattern?

The **Template Design Pattern** is a behavioral design pattern that defines the skeleton of an algorithm in a base class, allowing subclasses to provide specific implementations for one or more steps without changing the algorithm’s structure.

---

## When to Use the Template Pattern?

- When multiple classes share the same algorithm but have variations in specific steps.
- When you want to enforce a fixed sequence of execution for certain operations.

---

## Example: Online Order Process
Let’s consider an Online Order System where orders for different types of products (like electronics and groceries) follow the same workflow:

1. **Select Product**
2. **Add Payment Details**
3. **Deliver Product**

The steps "Select Product" and "Add Payment Details" may vary based on the product type, but the general sequence remains the same.

---

** Without Applying Template Design Pattern

Without using the Template Pattern, we may duplicate the logic of the workflow in multiple classes, leading to redundant code.

```java

// Class for processing Electronics Orders
class ElectronicsOrder {
    public void processOrder() {
        System.out.println("Step 1: Selecting electronics product...");
        System.out.println("Step 2: Adding payment details for electronics...");
        System.out.println("Step 3: Delivering electronics product...");
    }
}

// Class for processing Grocery Orders
class GroceryOrder {
    public void processOrder() {
        System.out.println("Step 1: Selecting grocery product...");
        System.out.println("Step 2: Adding payment details for groceries...");
        System.out.println("Step 3: Delivering grocery product...");
    }
}

// Client Code
public class OnlineOrderWithoutTemplate {
    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder = new ElectronicsOrder();
        electronicsOrder.processOrder();

        GroceryOrder groceryOrder = new GroceryOrder();
        groceryOrder.processOrder();
    }
}

```

---

## With Template Design Pattern

With the Template Pattern, we extract the common workflow into an abstract class and allow subclasses to define their specific steps.

**Code Implementation**

```java

// Abstract class representing the Template
abstract class OrderProcessTemplate {
    // Template method defining the skeleton of the algorithm
    public final void processOrder() {
        selectProduct();
        addPaymentDetails();
        deliverProduct();
    }

    // Steps with common implementations
    protected void deliverProduct() {
        System.out.println("Delivering product...");
    }

    // Abstract methods for steps that vary between subclasses
    protected abstract void selectProduct();
    protected abstract void addPaymentDetails();
}

// Concrete class for Electronics Order
class ElectronicsOrder extends OrderProcessTemplate {
    @Override
    protected void selectProduct() {
        System.out.println("Selecting an electronics product...");
    }

    @Override
    protected void addPaymentDetails() {
        System.out.println("Adding payment details for electronics...");
    }
}

// Concrete class for Grocery Order
class GroceryOrder extends OrderProcessTemplate {
    @Override
    protected void selectProduct() {
        System.out.println("Selecting a grocery product...");
    }

    @Override
    protected void addPaymentDetails() {
        System.out.println("Adding payment details for groceries...");
    }
}

// Client Code
public class OnlineOrderWithTemplate {
    public static void main(String[] args) {
        // Process Electronics Order
        OrderProcessTemplate electronicsOrder = new ElectronicsOrder();
        electronicsOrder.processOrder();

        System.out.println();

        // Process Grocery Order
        OrderProcessTemplate groceryOrder = new GroceryOrder();
        groceryOrder.processOrder();
    }
}

```

## Output

```css
Selecting an electronics product...
Adding payment details for electronics...
Delivering product...

Selecting a grocery product...
Adding payment details for groceries...
Delivering product...
```

---

## Key Advantages of the Template Pattern

1. **Code Reusability**: Common steps are implemented in the base class, reducing duplication.
2. **Flexibility**: Specific steps can vary, but the overall algorithm remains consistent.
3. **Single Responsibility Principle**: The base class defines the structure, while subclasses define specific behavior.

---

## How to Extend

To add a new order type (e.g., Clothing Order), simply create a new subclass of OrderProcessTemplate and implement the specific steps.

```java
class ClothingOrder extends OrderProcessTemplate {
    @Override
    protected void selectProduct() {
        System.out.println("Selecting a clothing product...");
    }

    @Override
    protected void addPaymentDetails() {
        System.out.println("Adding payment details for clothing...");
    }
}
```

This allows seamless extension without modifying existing code.
