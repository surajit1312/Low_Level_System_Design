package P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.context;

import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.factories.PaymentFactory;
import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.strategies.IPaymentStrategy;

public class PaymentProcessor {
    private IPaymentStrategy paymentStrategy = null;

    public void setPaymentStrategy(IPaymentStrategy strategy) {
        if (paymentStrategy != null) {
            paymentStrategy = null;
        }
        paymentStrategy = strategy;
    }

    public void processPayment(String paymentType, double amount) {
        if (paymentStrategy != null) {
            paymentStrategy = null;
        }
        paymentStrategy = PaymentFactory.createPaymentStrategy(paymentType);
        paymentStrategy.pay(amount);
    }

    public void finalize() {
        // used for cleanup strategy instance when not needed
        if (paymentStrategy != null) {
            paymentStrategy = null;
        }
        System.out.println("Payment Strategy has been cleaned-up");
    }
}
