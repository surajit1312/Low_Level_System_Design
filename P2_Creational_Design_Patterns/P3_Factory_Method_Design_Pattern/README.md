# Factory Method Design Pattern

**The Factory Method Design Pattern** defines an interface for creating objects but lets subclasses decide which class to instantiate. It is ideal when the object creation process varies but should still be encapsulated.

## Example: Payment Processing System

### Scenario:
A payment system supports multiple payment methods (e.g., CreditCard, PayPal, UPI). You need a flexible design that can support new payment methods without changing existing code.

## Without Factory Method Design Pattern
The client directly creates specific payment objects, leading to tightly coupled and inflexible code.

### Code Example: 

    // Payment Interface
    interface Payment {
        void processPayment();
    }

    // Concrete Payment Classes
    class CreditCardPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing Credit Card Payment.");
        }
    }

    class PayPalPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing PayPal Payment.");
        }
    }

    class UPIPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing UPI Payment.");
        }
    }

    // Client Code
    public class PaymentSystemWithoutFactory {
        public static void main(String[] args) {
            // Client creates payment objects directly
            Payment payment1 = new CreditCardPayment();
            payment1.processPayment();

            Payment payment2 = new PayPalPayment();
            payment2.processPayment();

            Payment payment3 = new UPIPayment();
            payment3.processPayment();
        }
    }

### Problems Without Factory Method:

- **Tight Coupling:**
  
  The client directly depends on specific payment classes.

- **Lack of Flexibility:**
  
  Adding a new payment type requires changes in every part of the code that creates payment objects.

- **Violates Open/Closed Principle:**

  The system is not closed to modification when adding new payment methods.


## With Factory Method Design Pattern

The client uses a factory method to create payment objects, adhering to the Open/Closed Principle and reducing coupling.

### Code Example:

    // Payment Interface
    interface Payment {
        void processPayment();
    }

    // Concrete Payment Classes
    class CreditCardPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing Credit Card Payment.");
        }
    }

    class PayPalPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing PayPal Payment.");
        }
    }

    class UPIPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing UPI Payment.");
        }
    }

    // Abstract Creator
    abstract class PaymentFactory {
        // Factory Method
        abstract Payment createPayment();
    }

    // Concrete Creators
    class CreditCardPaymentFactory extends PaymentFactory {
        @Override
        Payment createPayment() {
            return new CreditCardPayment();
        }
    }

    class PayPalPaymentFactory extends PaymentFactory {
        @Override
        Payment createPayment() {
            return new PayPalPayment();
        }
    }

    class UPIPaymentFactory extends PaymentFactory {
        @Override
        Payment createPayment() {
            return new UPIPayment();
        }
    }

    // Client Code
    public class PaymentSystemWithFactoryMethod {
        public static void main(String[] args) {
            // Use factories to create payment objects
            PaymentFactory creditCardFactory = new CreditCardPaymentFactory();
            Payment creditCardPayment = creditCardFactory.createPayment();
            creditCardPayment.processPayment();

            PaymentFactory payPalFactory = new PayPalPaymentFactory();
            Payment payPalPayment = payPalFactory.createPayment();
            payPalPayment.processPayment();

            PaymentFactory upiFactory = new UPIPaymentFactory();
            Payment upiPayment = upiFactory.createPayment();
            upiPayment.processPayment();
        }
    }

### Advantages of Factory Method Design Pattern

**Encapsulation:**

  Object creation logic is encapsulated within the factory classes.

**Open/Closed Principle:**

  Adding a new payment method (e.g., CryptoPayment) only requires creating a new factory and class without modifying existing code.

**Loose Coupling:**

  The client depends only on the factory and abstract product, not on concrete classes.


### Adding a New Payment Method

To add CryptoPayment:

- Create a CryptoPayment class implementing the Payment interface.

- Create a CryptoPaymentFactory class extending PaymentFactory.

- Use the new factory in the client code.

### New Classes

    class CryptoPayment implements Payment {
        @Override
        public void processPayment() {
            System.out.println("Processing Crypto Payment.");
        }
    }

    class CryptoPaymentFactory extends PaymentFactory {
        @Override
        Payment createPayment() {
            return new CryptoPayment();
        }
    }

### Client Code Usage

    PaymentFactory cryptoFactory = new CryptoPaymentFactory();
    Payment cryptoPayment = cryptoFactory.createPayment();
    cryptoPayment.processPayment();

## When to Use Factory Method Design Pattern

- When a class can't anticipate the type of objects it needs to create.

- When creating objects directly in the client code would result in too much coupling.

- When you want to delegate responsibility for instantiation to subclasses.

This pattern is particularly useful in frameworks where the framework itself instantiates user-defined objects.

