# Bridge Design Pattern with Uber Example

The **Bridge Design Pattern** is a structural design pattern that decouples an abstraction from its implementation, so the two can vary independently. Let’s use an **Uber-like ride-hailing system** as an example to understand this pattern.

---

## Problem Statement
Uber provides different types of rides (e.g., Economy, Premium, Shared). These ride types can be paired with multiple platforms (e.g., Android App, iOS App). Without applying the Bridge Pattern, you'll need to create multiple combinations of ride types and platforms, leading to a rigid and inflexible system.

---

## Without Applying the Bridge Design Pattern
Without the Bridge Pattern, the abstraction (ride type) is tightly coupled with its implementation (platform), leading to class explosion when adding new ride types or platforms.

### **Code**

#### Ride Interface and Implementations

```java
// Ride Interface
interface Ride {
    void bookRide();
}

// Economy Ride
class EconomyRide implements Ride {
    @Override
    public void bookRide() {
        System.out.println("Economy ride booked.");
    }
}

// Premium Ride
class PremiumRide implements Ride {
    @Override
    public void bookRide() {
        System.out.println("Premium ride booked.");
    }
}
```

#### Platform-Specific Ride Implementations

```java
// Android Economy Ride
class AndroidEconomyRide extends EconomyRide {
    @Override
    public void bookRide() {
        System.out.println("Economy ride booked via Android.");
    }
}

// iOS Premium Ride
class iOSPremiumRide extends PremiumRide {
    @Override
    public void bookRide() {
        System.out.println("Premium ride booked via iOS.");
    }
}
```

#### Client Code

```java
public class UberWithoutBridge {
    public static void main(String[] args) {
        Ride ride1 = new AndroidEconomyRide();
        ride1.bookRide();

        Ride ride2 = new iOSPremiumRide();
        ride2.bookRide();
    }
}
```

---

### **Issues**
1. **Class Explosion:** Adding a new ride type (e.g., Shared Ride) or platform (e.g., Web) requires creating many new classes.
2. **Rigid Design:** Changes in ride types or platforms require modifying existing classes.

---

## With Applying the Bridge Design Pattern
The Bridge Pattern decouples the ride types (abstraction) from the platforms (implementation). This results in a flexible and extensible design.

### **Code**

#### Ride Abstraction

```java
// Abstraction: Ride
abstract class Ride {
    protected Platform platform;

    public Ride(Platform platform) {
        this.platform = platform;
    }

    public abstract void bookRide();
}
```

#### Refined Abstraction: Ride Types

```java
// Economy Ride
class EconomyRide extends Ride {
    public EconomyRide(Platform platform) {
        super(platform);
    }

    @Override
    public void bookRide() {
        System.out.print("Economy ");
        platform.processBooking();
    }
}

// Premium Ride
class PremiumRide extends Ride {
    public PremiumRide(Platform platform) {
        super(platform);
    }

    @Override
    public void bookRide() {
        System.out.print("Premium ");
        platform.processBooking();
    }
}
```

#### Implementor Interface and Concrete Implementations

```java
// Implementor: Platform
interface Platform {
    void processBooking();
}

// Concrete Implementor: Android
class AndroidPlatform implements Platform {
    @Override
    public void processBooking() {
        System.out.println("ride booked via Android.");
    }
}

// Concrete Implementor: iOS
class iOSPlatform implements Platform {
    @Override
    public void processBooking() {
        System.out.println("ride booked via iOS.");
    }
}
```

#### Client Code

```java
public class UberWithBridge {
    public static void main(String[] args) {
        // Economy ride on Android
        Ride economyRide = new EconomyRide(new AndroidPlatform());
        economyRide.bookRide();

        // Premium ride on iOS
        Ride premiumRide = new PremiumRide(new iOSPlatform());
        premiumRide.bookRide();
    }
}
```

---

### **Output**

#### Without Applying the Bridge Pattern
```
Economy ride booked via Android.
Premium ride booked via iOS.
```

#### With Applying the Bridge Pattern
```
Economy ride booked via Android.
Premium ride booked via iOS.
```

---

### **Benefits of the Bridge Design Pattern**
1. **Flexibility:** Abstraction and implementation can evolve independently.
2. **Avoids Class Explosion:** Adding a new ride type or platform requires only one new class.
3. **Extensibility:** Easy to add new ride types or platforms without modifying existing code.
4. **Single Responsibility Principle:** Separates the concerns of ride types and platforms.

---

### **How to Run**
1. Copy the code into your Java IDE.
2. Run `UberWithoutBridge` to see the rigid design without the Bridge Pattern.
3. Run `UberWithBridge` to observe the flexibility introduced by the Bridge Pattern.
