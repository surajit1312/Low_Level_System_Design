
# Liskov Substitution Principle (LSP)

The **Liskov Substitution Principle (LSP)** is the third principle in the **SOLID** design principles. It states:  

> **"Objects of a superclass should be replaceable with objects of its subclasses without altering the correctness of the program."**

This means that subclasses should behave in a way that does not violate the expectations set by their parent class.

---

## Why LSP Matters

1. **Ensures Reliability:**  
   Subclasses must not break the functionality of the base class.  

2. **Improves Extensibility:**  
   Subclasses should extend the base class’s behavior, not alter it.  

3. **Supports Polymorphism:**  
   By adhering to LSP, you can replace parent objects with their child objects seamlessly.

---

## Example of Violating LSP

```java
class Rectangle {
    protected double width;
    protected double height;

    public void setWidth(double width) {
        this.width = width;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getArea() {
        return width * height;
    }
}

class Square extends Rectangle {
    @Override
    public void setWidth(double width) {
        this.width = width;
        this.height = width; // Ensuring both sides are equal
    }

    @Override
    public void setHeight(double height) {
        this.height = height;
        this.width = height; // Ensuring both sides are equal
    }
}
```

### Problem:

The `Square` class violates LSP because:  
1. **Unpredictable Behavior:**  
   A `Square` alters the `Rectangle`'s behavior by making `width` and `height` interdependent.  

2. **Incorrect Results:**  
   Any code relying on the `Rectangle`'s behavior might break when using a `Square`.

---

## Refactoring to Follow LSP

Instead of using inheritance, we can redesign the code to use a shared interface or base class with distinct implementations.

### Refactored Code

```java
// Interface for Shape
interface Shape {
    double getArea();
}

// Rectangle Class
class Rectangle implements Shape {
    private double width;
    private double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

// Square Class
class Square implements Shape {
    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    @Override
    public double getArea() {
        return side * side;
    }
}

// Main
public class LSPExample {
    public static void main(String[] args) {
        Shape rectangle = new Rectangle(5, 10);
        Shape square = new Square(7);

        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Square Area: " + square.getArea());
    }
}
```

---

### Benefits of the Refactor:

1. **Adherence to LSP:**  
   The behavior of both `Rectangle` and `Square` is consistent and predictable.  

2. **Extensibility:**  
   New shapes (e.g., `Circle`) can be added without altering existing code.  

3. **Avoids Misuse of Inheritance:**  
   By using interfaces, we eliminate the need for improper subclassing.  

---

### Output of Refactored Code:

```
Rectangle Area: 50.0
Square Area: 49.0
```

---

## Best Practices for LSP

1. **Favor Composition Over Inheritance:**  
   Use interfaces or composition to share behavior instead of forcing subclassing.  

2. **Test Substitutions:**  
   Ensure subclasses pass all tests that the parent class satisfies.  

3. **Avoid Overriding Methods Improperly:**  
   Subclasses should only override methods to extend behavior, not alter it.  

---

## Resources for Further Reading

- [SOLID Principles Overview](https://en.wikipedia.org/wiki/SOLID)
- [Clean Architecture: A Craftsman's Guide to Software Structure and Design](https://www.goodreads.com/book/show/18043011-clean-architecture) by Robert C. Martin  

---

By adhering to the **Liskov Substitution Principle**, your code remains flexible, maintainable, and predictable when extending functionality.
