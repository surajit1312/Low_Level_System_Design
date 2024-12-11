
# Prototype Design Pattern Example: Product Delivery System

This repository demonstrates the use of the **Prototype Design Pattern** in Java by simulating the process of cloning `Product` objects in a delivery system.

---

## **Scenario**

In a Product Delivery System, products like Electronics, Groceries, or Clothing often need to be recreated with similar configurations. Instead of manually copying properties or initializing new objects repeatedly, the **Prototype Pattern** allows us to clone existing objects.

---

## **Without Prototype Design Pattern**

Here, we manually copy product details to create new objects.

### Code Example

```java
// Product Class
class Product {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Copy constructor to manually copy the product
    public Product(Product product) {
        this.name = product.name;
        this.price = product.price;
        this.category = product.category;
    }

    @Override
    public String toString() {
        return "Product [Name=" + name + ", Price=" + price + ", Category=" + category + "]";
    }
}

// Client Code
public class WithoutPrototypePattern {
    public static void main(String[] args) {
        Product electronics = new Product("Laptop", 1200.99, "Electronics");

        // Manually copying the product
        Product anotherElectronics = new Product(electronics);

        Product grocery = new Product("Apple", 1.49, "Groceries");
        Product anotherGrocery = new Product(grocery);

        System.out.println(electronics);
        System.out.println(anotherElectronics);
        System.out.println(grocery);
        System.out.println(anotherGrocery);
    }
}
```

---

## **With Prototype Design Pattern**

The Prototype Pattern provides a `clone` method in the base class, allowing efficient object copying.

### Code Example

```java
// Prototype Interface
interface Prototype {
    Prototype clone();
}

// Product Class
class Product implements Prototype {
    private String name;
    private double price;
    private String category;

    public Product(String name, double price, String category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    // Clone method implementation
    @Override
    public Product clone() {
        return new Product(name, price, category);
    }

    @Override
    public String toString() {
        return "Product [Name=" + name + ", Price=" + price + ", Category=" + category + "]";
    }
}

// Client Code
public class WithPrototypePattern {
    public static void main(String[] args) {
        Product electronics = new Product("Laptop", 1200.99, "Electronics");

        // Cloning the product
        Product anotherElectronics = electronics.clone();

        Product grocery = new Product("Apple", 1.49, "Groceries");
        Product anotherGrocery = grocery.clone();

        System.out.println(electronics);
        System.out.println(anotherElectronics);
        System.out.println(grocery);
        System.out.println(anotherGrocery);
    }
}
```

---

## **Advantages of Prototype Design Pattern**

1. **Efficient Object Creation**: Avoids repetitive initialization logic.
2. **Flexibility**: Works seamlessly with subclass objects.
3. **Open/Closed Principle**: Adding new fields doesn’t require changing cloning logic in client code.

---

## **Real-Life Application**

In a delivery system, you may have various pre-configured products that are frequently ordered. Instead of creating them repeatedly, you can clone the existing product objects and modify details as needed (e.g., adding a discount or changing delivery times).

---

## **Conclusion**

The Prototype Design Pattern simplifies object creation, improves efficiency, and ensures that your code remains flexible and maintainable. It’s particularly useful in scenarios where object initialization is complex or expensive.
