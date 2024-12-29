# Strategy Design Pattern

## Introduction
The **Strategy Design Pattern** allows a family of algorithms to be defined and encapsulated in their own classes, making them interchangeable. The client can choose the behavior (algorithm) dynamically at runtime without modifying the client code.

In this example, we demonstrate the Strategy Design Pattern using an **E-commerce Payment System**, where customers can choose different payment methods such as Credit Card, PayPal, and Google Pay.

---

## Without Applying the Strategy Pattern

### Problem
Without the Strategy Pattern, the logic for handling payment methods is tightly coupled with the main service class. This makes the system rigid and violates the **Open/Closed Principle**.

### Code Example
```java
class PaymentService {
    public void processPayment(String paymentMethod) {
        if (paymentMethod.equals("CreditCard")) {
            System.out.println("Processing payment via Credit Card...");
        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing payment via PayPal...");
        } else if (paymentMethod.equals("GooglePay")) {
            System.out.println("Processing payment via Google Pay...");
        } else {
            System.out.println("Invalid payment method selected.");
        }
    }
}

public class WithoutStrategyPattern {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        paymentService.processPayment("CreditCard");
        paymentService.processPayment("PayPal");
        paymentService.processPayment("GooglePay");
    }
}
```

### Output
```
Processing payment via Credit Card...
Processing payment via PayPal...
Processing payment via Google Pay...
```

### Problems
1. **Violation of Open/Closed Principle**: Adding a new payment method requires modifying the `processPayment` method.
2. **Hardcoded Logic**: The logic for each payment method is hardcoded into the class.
3. **No Reusability**: Payment algorithms cannot be reused independently of the `PaymentService` class.

---

## With Applying the Strategy Pattern

### Solution
By applying the Strategy Pattern, we encapsulate each payment algorithm into its own class and make them interchangeable. The client can dynamically choose the required payment method.

### Code Example
```java
// Strategy Interface
interface PaymentStrategy {
    void pay();
}

// Concrete Strategy: Credit Card Payment
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing payment via Credit Card...");
    }
}

// Concrete Strategy: PayPal Payment
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing payment via PayPal...");
    }
}

// Concrete Strategy: Google Pay Payment
class GooglePayPayment implements PaymentStrategy {
    @Override
    public void pay() {
        System.out.println("Processing payment via Google Pay...");
    }
}

// Context Class
class PaymentService {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment() {
        if (paymentStrategy == null) {
            throw new IllegalStateException("Payment strategy is not set.");
        }
        paymentStrategy.pay();
    }
}

// Client
public class WithStrategyPattern {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        // Pay using Credit Card
        paymentService.setPaymentStrategy(new CreditCardPayment());
        paymentService.processPayment();

        // Pay using PayPal
        paymentService.setPaymentStrategy(new PayPalPayment());
        paymentService.processPayment();

        // Pay using Google Pay
        paymentService.setPaymentStrategy(new GooglePayPayment());
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

## Advantages of Applying the Strategy Pattern
1. **Adheres to Open/Closed Principle**: New payment strategies can be added without modifying existing code.
2. **Encapsulation**: Each payment algorithm is encapsulated in its own class.
3. **Reusability**: Payment algorithms can be reused independently of the `PaymentService` class.
4. **Flexibility**: The behavior of the `PaymentService` class can be changed at runtime by setting a different strategy.

---

## Key Differences

| Without Strategy Pattern                      | With Strategy Pattern                      |
|-----------------------------------------------|--------------------------------------------|
| Hardcoded logic for all payment methods in one class. | Each payment method is encapsulated in its own class. |
| Adding a new payment method requires modifying existing code. | New payment methods can be added without modifying existing code. |
| No reusability of payment algorithms.         | Payment algorithms are reusable and interchangeable. |

---

## Conclusion
The **Strategy Design Pattern** makes it easy to define and use multiple interchangeable behaviors (algorithms). It improves code flexibility and reusability while adhering to the **Open/Closed Principle**.

This example demonstrates how different payment methods in an e-commerce platform can be implemented using the Strategy Pattern. By encapsulating each payment method into a separate class, we ensure that our code is flexible, reusable, and easy to maintain.
