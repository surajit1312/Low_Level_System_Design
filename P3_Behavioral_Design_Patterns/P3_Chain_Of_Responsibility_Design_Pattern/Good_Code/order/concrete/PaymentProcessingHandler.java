package P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete;

import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.OrderHandler;

public class PaymentProcessingHandler extends OrderHandler {

    public PaymentProcessingHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Processing payment for order: " + order);
        // Perform payment processing logic here
        // If payment is successful, pass it to the next handler
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }

}
