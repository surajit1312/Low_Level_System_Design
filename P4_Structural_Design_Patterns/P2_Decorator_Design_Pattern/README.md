# Decorator Design Pattern: Pizza Customization Example

This example demonstrates the **Decorator Design Pattern** by simulating a pizza ordering system where customers can dynamically add toppings (e.g., Cheese, Olives, Pepperoni) to their pizzas.

---

## Problem Statement

In a pizza ordering system, customers can customize their pizzas with various toppings. Without using the decorator pattern, you would need to create multiple subclasses for every possible combination of pizzas and toppings. This approach leads to class explosion and rigid design. The decorator pattern provides a flexible solution to this problem.

---

## Without Applying the Decorator Pattern

In this approach, every combination of pizza and toppings is represented by a separate subclass. This leads to:

1. **Class Explosion:** For every new combination, a new subclass must be created.
2. **Rigid Design:** Adding a new topping requires modifying existing subclasses, violating the **Open/Closed Principle**.

### Code

#### Base Pizza Class

```java
// Base Pizza class
abstract class Pizza {
    public abstract String getDescription();
    public abstract double getCost();
}
```

#### Concrete Pizza Classes

```java
// Margherita Pizza
class Margherita extends Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.00;
    }
}

// Farmhouse Pizza
class Farmhouse extends Pizza {
    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

    @Override
    public double getCost() {
        return 300.00;
    }
}
```

#### Toppings as Subclasses

```java
// Margherita with Cheese
class MargheritaWithCheese extends Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza with Cheese";
    }

    @Override
    public double getCost() {
        return 250.00;
    }
}

// Farmhouse with Cheese and Olives
class FarmhouseWithCheeseAndOlives extends Pizza {
    @Override
    public String getDescription() {
        return "Farmhouse Pizza with Cheese and Olives";
    }

    @Override
    public double getCost() {
        return 350.00;
    }
}
```

#### Client Code

```java
public class PizzaWithoutDecorator {
    public static void main(String[] args) {
        // Margherita Pizza with Cheese
        Pizza pizza1 = new MargheritaWithCheese();
        System.out.println(pizza1.getDescription() + " - Cost: $" + pizza1.getCost());

        // Farmhouse Pizza with Cheese and Olives
        Pizza pizza2 = new FarmhouseWithCheeseAndOlives();
        System.out.println(pizza2.getDescription() + " - Cost: $" + pizza2.getCost());
    }
}
```

---

## With Applying the Decorator Pattern

The **Decorator Pattern** dynamically adds toppings to the pizza objects at runtime. It uses composition instead of inheritance to achieve flexibility and avoid class explosion.

### Code

#### Base Pizza Class

```java
// Base Pizza class
abstract class Pizza {
    public abstract String getDescription();
    public abstract double getCost();
}
```

#### Concrete Pizza Classes

```java
// Margherita Pizza
class Margherita extends Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.00;
    }
}

// Farmhouse Pizza
class Farmhouse extends Pizza {
    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

    @Override
    public double getCost() {
        return 300.00;
    }
}
```

#### Topping Decorator

```java
// Abstract Topping Decorator
abstract class ToppingDecorator extends Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public abstract String getDescription();
}
```

#### Concrete Toppings

```java
// Cheese Topping
class Cheese extends ToppingDecorator {
    public Cheese(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Cheese";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50.00;
    }
}

// Olives Topping
class Olives extends ToppingDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Olives";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30.00;
    }
}

// Pepperoni Topping
class Pepperoni extends ToppingDecorator {
    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + " with Pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 70.00;
    }
}
```

#### Client Code

```java
public class PizzaWithDecorator {
    public static void main(String[] args) {
        // Create a Margherita Pizza
        Pizza margherita = new Margherita();
        System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());

        // Add Cheese to Margherita
        margherita = new Cheese(margherita);
        System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());

        // Add Olives to Margherita with Cheese
        margherita = new Olives(margherita);
        System.out.println(margherita.getDescription() + " - Cost: $" + margherita.getCost());

        // Create a Farmhouse Pizza with Pepperoni and Cheese
        Pizza farmhouse = new Farmhouse();
        farmhouse = new Pepperoni(farmhouse);
        farmhouse = new Cheese(farmhouse);
        System.out.println(farmhouse.getDescription() + " - Cost: $" + farmhouse.getCost());
    }
}
```

---

## Output

### Without Applying Decorator
```
Margherita Pizza with Cheese - Cost: $250.0
Farmhouse Pizza with Cheese and Olives - Cost: $350.0
```

### With Applying Decorator
```
Margherita Pizza - Cost: $200.0
Margherita Pizza with Cheese - Cost: $250.0
Margherita Pizza with Cheese with Olives - Cost: $280.0
Farmhouse Pizza with Pepperoni with Cheese - Cost: $420.0
```

---

## Benefits of Decorator Pattern

1. **Flexibility:** Dynamically add or remove toppings without modifying the existing code.
2. **Extensibility:** Adding a new topping doesn’t require changes to existing pizza or topping classes.
3. **Open/Closed Principle:** Classes are open for extension but closed for modification.
4. **Avoid Class Explosion:** Eliminates the need to create a class for every possible topping combination.

---

## How to Run

1. Copy the code into your Java IDE.
2. Run `PizzaWithoutDecorator` to see the issues with hardcoded combinations.
3. Run `PizzaWithDecorator` to observe the flexibility of the Decorator Pattern.

---
