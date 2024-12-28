# Iterator Design Pattern

## Introduction
The **Iterator Design Pattern** provides a way to access the elements of a collection sequentially without exposing its underlying representation. It decouples the logic of iteration from the collection, enabling different ways to traverse the collection.

In this example, we'll demonstrate the Iterator Design Pattern using an **Amazon Inventory System**.

---

## Without Applying the Iterator Pattern

### Problem
Without the Iterator Pattern, the client directly accesses the internal structure of the collection and performs iteration. This tightly couples the client with the collection's implementation.

### Code Example
```java
import java.util.ArrayList;
import java.util.List;

class AmazonInventory {
    private List<String> items;

    public AmazonInventory() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items; // Exposes the internal structure
    }
}

public class WithoutIteratorPattern {
    public static void main(String[] args) {
        AmazonInventory inventory = new AmazonInventory();
        inventory.addItem("Laptop");
        inventory.addItem("Smartphone");
        inventory.addItem("Headphones");

        // Directly access and iterate through the internal structure
        for (String item : inventory.getItems()) {
            System.out.println("Processing item: " + item);
        }
    }
}
```

### Output
```
Processing item: Laptop
Processing item: Smartphone
Processing item: Headphones
```

### Problems
1. **Tight Coupling**: The client directly accesses the internal structure of `AmazonInventory` (`List<String>`), making it hard to change the underlying collection type.
2. **Violation of Encapsulation**: Internal implementation details are exposed to the client.
3. **No Custom Iteration Logic**: Cannot easily add custom iteration behavior (e.g., iterate only items starting with "S").

---

## With Applying the Iterator Pattern

### Solution
By applying the **Iterator Pattern**, the collection hides its internal structure and provides an iterator to traverse its elements. This decouples the iteration logic from the collection.

### Code Example
```java
import java.util.ArrayList;
import java.util.List;

// Iterator Interface
interface InventoryIterator {
    boolean hasNext();
    String next();
}

// Concrete Iterator
class AmazonInventoryIterator implements InventoryIterator {
    private List<String> items;
    private int position = 0;

    public AmazonInventoryIterator(List<String> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more items in the inventory");
        }
        return items.get(position++);
    }
}

// Collection Interface
interface Inventory {
    InventoryIterator createIterator();
}

// Concrete Collection
class AmazonInventory implements Inventory {
    private List<String> items;

    public AmazonInventory() {
        items = new ArrayList<>();
    }

    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public InventoryIterator createIterator() {
        return new AmazonInventoryIterator(items);
    }
}

// Client
public class WithIteratorPattern {
    public static void main(String[] args) {
        AmazonInventory inventory = new AmazonInventory();
        inventory.addItem("Laptop");
        inventory.addItem("Smartphone");
        inventory.addItem("Headphones");

        // Use the iterator to process inventory items
        InventoryIterator iterator = inventory.createIterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            System.out.println("Processing item: " + item);
        }
    }
}
```

### Output
```
Processing item: Laptop
Processing item: Smartphone
Processing item: Headphones
```

---

## Advantages of Applying the Iterator Pattern
1. **Encapsulation**: The client does not need to know the internal representation of the collection.
2. **Flexibility**: Different kinds of iterators (e.g., reverse iteration, filtered iteration) can be implemented.
3. **Decoupling**: The iteration logic is decoupled from the collection.
4. **Custom Iteration Logic**: Allows custom iteration behavior without modifying the collection.

---

## Key Differences

| Without Iterator Pattern                      | With Iterator Pattern                      |
|-----------------------------------------------|--------------------------------------------|
| Exposes the internal structure of the collection. | Encapsulates the iteration logic.           |
| Client tightly coupled to the collection.     | Client is decoupled from the collection.   |
| Cannot add custom iteration logic.            | Allows custom iteration logic via iterators.|

---

## Conclusion
The **Iterator Design Pattern** simplifies traversal through collections by encapsulating the iteration logic within an iterator class. This makes the system more flexible, extensible, and adherent to the **Single Responsibility Principle**.
