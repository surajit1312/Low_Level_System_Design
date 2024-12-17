
# Observer Design Pattern Example: Stock Price Notification System

This repository demonstrates the Observer Design Pattern with and without applying it using a **Stock Price Notification System** in Java.

---

## **Without Applying Observer Design Pattern**

### Problem Statement

In this approach, the Subject (StockExchange) directly updates its dependent classes (MobileApp, WebApp). This leads to tight coupling, poor scalability, and violation of the Open/Closed Principle.

### Code Example

```java
// Dependent classes are directly updated by the Subject
class StockPrice {
    private String stockName;
    private double price;

    public StockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getStockName() {
        return stockName;
    }

    public double getPrice() {
        return price;
    }
}

// Clients that need updates
class MobileApp {
    public void update(String stockName, double price) {
        System.out.println("MobileApp: " + stockName + " price updated to " + price);
    }
}

class WebApp {
    public void update(String stockName, double price) {
        System.out.println("WebApp: " + stockName + " price updated to " + price);
    }
}

// Subject class
class StockExchange {
    private StockPrice stockPrice;
    private MobileApp mobileApp;
    private WebApp webApp;

    public StockExchange(StockPrice stockPrice, MobileApp mobileApp, WebApp webApp) {
        this.stockPrice = stockPrice;
        this.mobileApp = mobileApp;
        this.webApp = webApp;
    }

    public void updatePrice(double newPrice) {
        stockPrice.setPrice(newPrice);
        notifyApps();
    }

    private void notifyApps() {
        mobileApp.update(stockPrice.getStockName(), stockPrice.getPrice());
        webApp.update(stockPrice.getStockName(), stockPrice.getPrice());
    }
}

// Main class
public class WithoutObserverPattern {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice("AAPL", 150.0);
        MobileApp mobileApp = new MobileApp();
        WebApp webApp = new WebApp();

        StockExchange stockExchange = new StockExchange(stockPrice, mobileApp, webApp);
        stockExchange.updatePrice(155.0);
        stockExchange.updatePrice(160.0);
    }
}
```

---

## **With Applying Observer Design Pattern**

### Solution

Using the Observer Design Pattern decouples the Subject from its Observers. Observers register themselves with the Subject, and the Subject notifies them when its state changes.

### Code Example

```java
import java.util.ArrayList;
import java.util.List;

// Observer Interface
interface Observer {
    void update(String stockName, double price);
}

// Subject Class
class StockPrice implements Subject {
    private String stockName;
    private double price;
    private List<Observer> observers;

    public StockPrice(String stockName, double price) {
        this.stockName = stockName;
        this.price = price;
        this.observers = new ArrayList<>();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(stockName, price);
        }
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        notifyObservers();
    }
}

// Subject Interface
interface Subject {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

// Concrete Observers
class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("MobileApp: " + stockName + " price updated to " + price);
    }
}

class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("WebApp: " + stockName + " price updated to " + price);
    }
}

// Main Class
public class WithObserverPattern {
    public static void main(String[] args) {
        // Subject
        StockPrice stockPrice = new StockPrice("AAPL", 150.0);

        // Observers
        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        // Register Observers
        stockPrice.addObserver(mobileApp);
        stockPrice.addObserver(webApp);

        // State Changes
        stockPrice.setPrice(155.0);
        stockPrice.setPrice(160.0);

        // Remove an Observer
        stockPrice.removeObserver(webApp);
        stockPrice.setPrice(165.0);
    }
}
```

---

### **Advantages of Observer Pattern**

1. **Loose Coupling**:
   - The `StockPrice` (Subject) doesn't know the specifics of its Observers.
2. **Scalability**:
   - Adding or removing Observers doesn't affect the Subject.
3. **Adherence to Open/Closed Principle**:
   - Adding new Observer types doesn't require changes to the Subject.

---

## **When to Use Observer Design Pattern?**

- When changes in one object require updates in multiple others.
- When the list of observers can change dynamically.

---

## **Output (With Observer Pattern)**

```
MobileApp: AAPL price updated to 155.0
WebApp: AAPL price updated to 155.0
MobileApp: AAPL price updated to 160.0
WebApp: AAPL price updated to 160.0
MobileApp: AAPL price updated to 165.0
```

---

## **Conclusion**

The Observer Design Pattern creates a flexible, scalable, and maintainable system by decoupling the Subject from its Observers.
