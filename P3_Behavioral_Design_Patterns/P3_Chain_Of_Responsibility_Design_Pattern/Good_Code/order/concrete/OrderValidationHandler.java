package P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete;

import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.OrderHandler;

public class OrderValidationHandler extends OrderHandler {

    public OrderValidationHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Validating order for : " + order);
        // Perform order validation logic here
        if (!order.isEmpty()) {
            // If the order is valid, pass it to the next handler
            if (nextHandler != null) {
                nextHandler.processOrder(order);
            }
        }
    }

}
