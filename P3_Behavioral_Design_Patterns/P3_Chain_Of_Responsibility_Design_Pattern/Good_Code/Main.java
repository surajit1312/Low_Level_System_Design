package P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code;

import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.OrderHandler;
import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete.DeliveryAssignmentHandler;
import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete.OrderPreparationHandler;
import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete.OrderTrackingHandler;
import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete.OrderValidationHandler;
import P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Good_Code.order.concrete.PaymentProcessingHandler;

public class Main {
    public static void main(String[] args) {
        // Create a chain of responsibility for order processing
        OrderHandler orderProcessingChainHandler = new OrderValidationHandler(
                new PaymentProcessingHandler(
                        new OrderPreparationHandler(
                                new DeliveryAssignmentHandler(
                                        new OrderTrackingHandler(null)))));
        String order = "pizza";
        orderProcessingChainHandler.processOrder(order);
    }
}
