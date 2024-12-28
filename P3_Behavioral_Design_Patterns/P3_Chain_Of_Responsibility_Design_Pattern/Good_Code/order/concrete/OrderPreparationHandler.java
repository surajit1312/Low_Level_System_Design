package P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete;

import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.OrderHandler;

public class OrderPreparationHandler extends OrderHandler {

    public OrderPreparationHandler(OrderHandler nextHandler) {
        super(nextHandler);
    }

    @Override
    public void processOrder(String order) {
        System.out.println("Preparing order: " + order);
        // Perform order preparation logic here

        // If preparation is complete, pass it to the next handler
        if (nextHandler != null) {
            nextHandler.processOrder(order);
        }
    }

}
