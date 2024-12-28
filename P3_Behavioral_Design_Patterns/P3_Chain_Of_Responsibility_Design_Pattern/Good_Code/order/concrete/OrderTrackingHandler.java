package P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete;

import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.OrderHandler;

public class OrderTrackingHandler extends OrderHandler {

    public OrderTrackingHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Tracking order: " + order);
        // Perform order tracking logic here
        // If the order is valid, pass it to the next handler
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }

}
