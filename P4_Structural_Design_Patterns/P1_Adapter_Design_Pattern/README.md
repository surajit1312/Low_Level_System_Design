# Adapter Design Pattern Example

This example demonstrates the **Adapter Design Pattern** by integrating a legacy payment system (`PayPal`) with a modern payment gateway (`Stripe`).

---

## Problem Statement

In an e-commerce application, you need to integrate a new payment gateway (`Stripe`) into your system. However, your system was originally designed to work with an older payment gateway (`PayPal`). Since the interface of the new gateway is different from the existing one, we need to create an **Adapter** to bridge the two interfaces.

---

## Without Applying the Adapter Pattern

Without the adapter pattern, the client has to handle both payment gateways differently, leading to duplicated code and tightly coupled logic.

### Code

#### Legacy Payment Gateway: `PayPal`

```java
// Legacy payment gateway
class PayPal {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made using PayPal.");
    }
}
```

#### New Payment Gateway: `Stripe`

```java
// New payment gateway
class Stripe {
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " made using Stripe.");
    }
}
```

#### Client Code

```java
public class PaymentWithoutAdapter {
    public static void main(String[] args) {
        // Using PayPal
        PayPal paypal = new PayPal();
        paypal.makePayment(100.00);

        // Using Stripe
        Stripe stripe = new Stripe();
        stripe.pay(200.00);
    }
}
```

### Issues
1. The client needs to know the specific details of both `PayPal` and `Stripe`.
2. Adding another payment gateway will require changes in the client code, violating the **Open/Closed Principle**.

---

## With Applying the Adapter Pattern

Using the adapter pattern, we create a unified interface (`PaymentProcessor`) that both `PayPal` and `Stripe` gateways can adhere to. The client works with this interface, making the system extensible and decoupled.

---

### Code

#### PaymentProcessor Interface

```java
// Unified interface for payment gateways
interface PaymentProcessor {
    void processPayment(double amount);
}
```

#### Legacy Payment Gateway: `PayPal`

```java
// Legacy payment gateway
class PayPal {
    public void makePayment(double amount) {
        System.out.println("Payment of $" + amount + " made using PayPal.");
    }
}
```

#### New Payment Gateway: `Stripe`

```java
// New payment gateway
class Stripe {
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " made using Stripe.");
    }
}
```

#### Adapter for PayPal

```java
// Adapter for PayPal
class PayPalAdapter implements PaymentProcessor {
    private PayPal paypal;

    public PayPalAdapter(PayPal paypal) {
        this.paypal = paypal;
    }

    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}
```

#### Adapter for Stripe

```java
// Adapter for Stripe
class StripeAdapter implements PaymentProcessor {
    private Stripe stripe;

    public StripeAdapter(Stripe stripe) {
        this.stripe = stripe;
    }

    @Override
    public void processPayment(double amount) {
        stripe.pay(amount);
    }
}
```

#### Client Code

```java
public class PaymentWithAdapter {
    public static void main(String[] args) {
        // Using PayPal through Adapter
        PaymentProcessor paypalProcessor = new PayPalAdapter(new PayPal());
        paypalProcessor.processPayment(100.00);

        // Using Stripe through Adapter
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        stripeProcessor.processPayment(200.00);
    }
}
```

---

## Output

### Without Applying Adapter
```
Payment of $100.0 made using PayPal.
Payment of $200.0 made using Stripe.
```

### With Applying Adapter
```
Payment of $100.0 made using PayPal.
Payment of $200.0 made using Stripe.
```

---

## Key Benefits of Adapter Pattern

1. **Loose Coupling:** The client code doesn’t need to know the specifics of `PayPal` or `Stripe`.
2. **Extensibility:** Adding a new payment gateway (e.g., `RazorPay`) only requires a new adapter without modifying the client code.
3. **Single Responsibility Principle:** Each adapter is responsible for bridging a specific gateway to the unified interface.

---

## How to Run

1. Copy the respective code into your Java IDE.
2. Run the `PaymentWithoutAdapter` class to see the issues with direct integration.
3. Run the `PaymentWithAdapter` class to observe the benefits of the Adapter Design Pattern.

---
