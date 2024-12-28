package P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Bad_Code;

public class SwiggyOrderProcessor {
    private boolean paymentDone;

    public SwiggyOrderProcessor(boolean paymentDone) {
        this.paymentDone = paymentDone;
    }

    public void processOrder(String order) {
        System.out.println("Processing Order for : " + order);
        // Validate order
        if (validateOrder(order)) {
            System.out.println("Order validated for : " + order);
        } else {
            System.out.println("Order validation failed for : " + order);
            return;
        }
        // Process Payment
        if (isPaymentProcessed()) {
            System.out.println("Payment is processed for : " + order);
        } else {
            System.out.println("Payment process is failed for : " + order);
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
        return !order.isEmpty();
    }

    private boolean isPaymentProcessed() {
        return paymentDone;
    }

    private boolean assignDelivery(String order) {
        return order.toLowerCase().contains("delivery");
    }
}
