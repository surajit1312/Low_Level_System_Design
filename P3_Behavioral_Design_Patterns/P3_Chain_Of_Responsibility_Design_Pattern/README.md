# Chain of Responsibility Design Pattern

## Introduction
The **Chain of Responsibility Design Pattern** allows a request to pass through a chain of handlers until it is processed by an appropriate handler. Each handler decides whether to process the request or pass it to the next handler in the chain. This pattern decouples the sender and receiver of a request.

In this example, we'll use the **Swiggy Order Processing System** to demonstrate the pattern.

---

## Without Applying Chain of Responsibility
In this implementation, all stages of order processing (validation, payment, and delivery assignment) are handled in a single class, resulting in tightly coupled logic.

### Code Example
```java
class SwiggyOrderProcessor {
    public void processOrder(String order) {
        System.out.println("Processing Order: " + order);

        // Validate Order
        if (validateOrder(order)) {
            System.out.println("Order Validated");
        } else {
            System.out.println("Order Validation Failed");
            return;
        }

        // Process Payment
        if (processPayment(order)) {
            System.out.println("Payment Processed");
        } else {
            System.out.println("Payment Failed");
            return;
        }

        // Assign Delivery
        if (assignDelivery(order)) {
            System.out.println("Delivery Assigned");
        } else {
            System.out.println("Delivery Assignment Failed");
        }
    }

    private boolean validateOrder(String order) {
        // Validation logic
        return !order.isEmpty();
    }

    private boolean processPayment(String order) {
        // Payment processing logic
        return order.length() > 5; // Mock logic
    }

    private boolean assignDelivery(String order) {
        // Delivery assignment logic
        return order.contains("Delivery"); // Mock logic
    }
}

public class WithoutChainOfResponsibility {
    public static void main(String[] args) {
        SwiggyOrderProcessor processor = new SwiggyOrderProcessor();
        processor.processOrder("Order123 with Delivery");
    }
}
```

### Output
```
Processing Order: Order123 with Delivery
Order Validated
Payment Processed
Delivery Assigned
```

### Problems
1. **Tightly Coupled Logic**: All stages are hardcoded in the `SwiggyOrderProcessor` class.
2. **Difficult to Extend**: Adding a new stage (e.g., notifications) requires modifying the entire class.
3. **Reduced Flexibility**: Cannot easily rearrange or dynamically configure stages.

---

## With Applying Chain of Responsibility
Here, each stage of order processing is encapsulated into its own handler class. Handlers are chained together dynamically, and each handler decides whether to process the request or pass it along the chain.

### Code Example
```java
// Abstract Handler
abstract class OrderHandler {
    protected OrderHandler nextHandler;

    public void setNextHandler(OrderHandler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void handleOrder(String order) {
        if (process(order) && nextHandler != null) {
            nextHandler.handleOrder(order);
        }
    }

    protected abstract boolean process(String order);
}

// Concrete Handlers
class ValidationHandler extends OrderHandler {
    @Override
    protected boolean process(String order) {
        System.out.println("Validating Order: " + order);
        boolean isValid = !order.isEmpty(); // Validation logic
        if (!isValid) {
            System.out.println("Order Validation Failed");
        }
        return isValid;
    }
}

class PaymentHandler extends OrderHandler {
    @Override
    protected boolean process(String order) {
        System.out.println("Processing Payment for Order: " + order);
        boolean isPaid = order.length() > 5; // Mock payment logic
        if (!isPaid) {
            System.out.println("Payment Failed");
        }
        return isPaid;
    }
}

class DeliveryAssignmentHandler extends OrderHandler {
    @Override
    protected boolean process(String order) {
        System.out.println("Assigning Delivery for Order: " + order);
        boolean isAssigned = order.contains("Delivery"); // Mock delivery assignment logic
        if (!isAssigned) {
            System.out.println("Delivery Assignment Failed");
        }
        return isAssigned;
    }
}

// Client
public class WithChainOfResponsibility {
    public static void main(String[] args) {
        // Create handlers
        OrderHandler validationHandler = new ValidationHandler();
        OrderHandler paymentHandler = new PaymentHandler();
        OrderHandler deliveryHandler = new DeliveryAssignmentHandler();

        // Chain handlers
        validationHandler.setNextHandler(paymentHandler);
        paymentHandler.setNextHandler(deliveryHandler);

        // Process order
        String order = "Order123 with Delivery";
        validationHandler.handleOrder(order);
    }
}
```

### Output
```
Validating Order: Order123 with Delivery
Processing Payment for Order: Order123 with Delivery
Assigning Delivery for Order: Order123 with Delivery
```

---

## Advantages of Applying Chain of Responsibility
1. **Decoupling**: Each stage (e.g., validation, payment, delivery) is a separate class and independent.
2. **Flexible Configuration**: Handlers can be dynamically added, removed, or rearranged.
3. **Extensible**: Adding a new handler (e.g., notifications) does not require modifying existing classes.
4. **Single Responsibility Principle**: Each class handles only one stage of the process.

---

## Key Differences

| Without Chain of Responsibility          | With Chain of Responsibility          |
|------------------------------------------|----------------------------------------|
| All stages handled in a single class     | Each stage is handled in a separate class |
| Tightly coupled logic                    | Loosely coupled handlers                |
| Difficult to add/remove/modify stages    | Easy to extend or rearrange stages      |

---
