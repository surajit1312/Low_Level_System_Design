# Single Responsibility Principle (SRP)
The Single Responsibility Principle (SRP) is one of the five SOLID principles of object-oriented design. It states:

"A class should have only one reason to change."

This means that every class, module, or function should have a single responsibility, and that responsibility should be entirely encapsulated by the class.

## Why SRP Matters

- Maintainability
    - Classes with a single responsibility are easier to understand, test, and modify.

- Reduced Coupling
    - By adhering to SRP, each class depends on fewer other parts of the system, making the system more modular.

- Ease of Debugging
    - Isolating responsibilities makes debugging simpler because the source of an issue is more localized.

## Example of Violating SRP

    import java.util.List;

    class Order {
        private int orderId;
        private List<Item> items;

        public Order(int orderId, List<Item> items) {
            this.orderId = orderId;
            this.items = items;
        }

        public double calculateTotal() {
            return items.stream().mapToDouble(Item::getPrice).sum();
        }

        public void printInvoice() {
            System.out.println("Invoice for Order: " + orderId);
            items.forEach(item -> 
                System.out.println("- " + item.getName() + ": $" + item.getPrice())
            );
            System.out.println("Total: $" + calculateTotal());
        }

        public void saveToDatabase() {
            System.out.println("Saving order to the database...");
            // Database logic
        }
    }

    class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }


## Problems with the Above Code:

- Multiple Responsibilities:
    - Order handles business logic (calculateTotal).
    - It deals with presentation (printInvoice).
    - It handles persistence (saveToDatabase).

- Harder to Test:
    - Each responsibility is tightly coupled, making it difficult to test or modify one without impacting the others.

## Applying SRP

To refactor the code, we separate responsibilities into different classes:

    import java.util.List;

    // Business logic
    class Order {
        private int orderId;
        private List<Item> items;

        public Order(int orderId, List<Item> items) {
            this.orderId = orderId;
            this.items = items;
        }

        public int getOrderId() {
            return orderId;
        }

        public List<Item> getItems() {
            return items;
        }

        public double calculateTotal() {
            return items.stream().mapToDouble(Item::getPrice).sum();
        }
    }

    // Presentation logic
    class InvoicePrinter {
        public void print(Order order) {
            System.out.println("Invoice for Order: " + order.getOrderId());
            order.getItems().forEach(item -> 
                System.out.println("- " + item.getName() + ": $" + item.getPrice())
            );
            System.out.println("Total: $" + order.calculateTotal());
        }
    }

    // Persistence logic
    class OrderRepository {
        public void save(Order order) {
            System.out.println("Saving order to the database...");
            // Database logic
        }
    }

    // Model
    class Item {
        private String name;
        private double price;

        public Item(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public double getPrice() {
            return price;
        }
    }

    // Main
    public class SRPExample {
        public static void main(String[] args) {
            List<Item> items = List.of(
                new Item("Laptop", 1000.00),
                new Item("Mouse", 50.00)
            );

            Order order = new Order(1, items);
            InvoicePrinter printer = new InvoicePrinter();
            OrderRepository repository = new OrderRepository();

            printer.print(order);
            repository.save(order);
        }
    }


### Benefits of the Refactor:

- Separation of Concerns:
    - Each class has a single responsibility:
    - Order handles the business logic.
    - InvoicePrinter deals with printing invoices.
    - OrderRepository manages persistence.

- Improved Testability:
    - Each class can be tested independently.

- Scalability:
    - Adding new features (e.g., exporting invoices) doesn’t require modifying the core Order class.

## Best Practices for SRP

- Identify Responsibilities
    - Analyze what responsibilities a class currently handles.

- Decompose Classes
    - If a class has more than one responsibility, decompose it into smaller classes.

- Name Reflects Responsibility
    - The name of the class should clearly state its single responsibility.

## Resources for Further Reading

- SOLID Principles Overview

    https://en.wikipedia.org/wiki/SOLID

- Clean Code: A Handbook of Agile Software Craftsmanship by Robert C. Martin

## Conclusion

By following SRP, we create code that is easier to maintain, debug, and scale. Embrace SRP for better software design!
