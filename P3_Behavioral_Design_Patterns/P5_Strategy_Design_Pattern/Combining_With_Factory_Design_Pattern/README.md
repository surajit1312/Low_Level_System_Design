# Factory and Strategy Design Pattern Combined Example

This example demonstrates the **Strategy Design Pattern** combined with the **Factory Design Pattern** to build a flexible and extensible payment system.

---

## Problem Statement

A payment service needs to support multiple payment methods, such as **Credit Card**, **PayPal**, and **Google Pay**. The client code should be able to:

1. Dynamically switch between payment strategies at runtime (Strategy Pattern).
2. Decouple the creation logic for different payment strategies (Factory Pattern).

---

## Solution

By combining the **Factory** and **Strategy Design Patterns**:

- **Factory Pattern**: Handles the creation of `PaymentStrategy` objects, simplifying the client's responsibility.
- **Strategy Pattern**: Enables the client to select and execute different payment strategies dynamically.

---

## Code Implementation

### 1. PaymentStrategy Interface

```java
interface PaymentStrategy {
    void pay();
}
```

### 2. Concrete Payment Strategies

```java
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing payment via Credit Card...");
    }
}

class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing payment via PayPal...");
    }
}

class GooglePayPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing payment via Google Pay...");
    }
}
```

### 3. PaymentStrategyFactory (New Class)

The factory class is responsible for creating **PaymentStrategy** objects based on the payment type.

```java

class PaymentStrategyFactory {
    public static PaymentStrategy getPaymentStrategy(String paymentType) {
        if (paymentType == null || paymentType.isEmpty()) {
            throw new IllegalArgumentException("Payment type cannot be null or empty");
        }

        switch (paymentType) {
            case "CreditCard":
                return new CreditCardPayment();
            case "PayPal":
                return new PayPalPayment();
            case "GooglePay":
                return new GooglePayPayment();
            default:
                throw new IllegalArgumentException("Invalid payment type: " + paymentType);
        }
    }
}

```

### 4. Updated PaymentService

The PaymentService uses the factory to get the appropriate **PaymentStrategy** instance.

```java

class PaymentService {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(String paymentType) {
        this.paymentStrategy = PaymentStrategyFactory.getPaymentStrategy(paymentType);
    }

    public void processPayment() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy is not set.");
        }
        paymentStrategy.pay();
    }
}

```

### 5. Client Code

The client interacts with the **PaymentService** and provides the payment type.

```java

public class FactoryWithStrategyPattern {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // Pay using Credit Card
        paymentService.setPaymentStrategy("CreditCard");
        paymentService.processPayment();

        // Pay using PayPal
        paymentService.setPaymentStrategy("PayPal");
        paymentService.processPayment();

        // Pay using Google Pay
        paymentService.setPaymentStrategy("GooglePay");
        paymentService.processPayment();
    }
}

```

### Output

```

Processing payment via Credit Card...
Processing payment via PayPal...
Processing payment via Google Pay...

```

---

## Key Benefits of Combining Factory with Strategy

1. **Separation of Concerns**: The client is no longer responsible for creating PaymentStrategy objects.

2. **Encapsulation**: The logic for creating strategies is encapsulated in the factory class.

3. **Open/Closed Principle**: New strategies can be added by simply updating the factory without affecting the client code.

4. **Flexibility**: The Strategy Pattern continues to provide runtime flexibility, while the Factory Pattern simplifies the instantiation process.

---

## UML Diagram for Combined Factory and Strategy Pattern

Here’s how the UML looks when combining both patterns:

1. **Factory Class**: Responsible for creating and returning PaymentStrategy objects.

2. **Strategy Interface**: Defines the behavior contract.

3. **Concrete Strategies**: Implement the specific payment behaviors.

4. **Context (PaymentService)**: Uses the factory to dynamically get and execute strategies
