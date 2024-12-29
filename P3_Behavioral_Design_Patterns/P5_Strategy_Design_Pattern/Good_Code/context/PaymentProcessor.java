package P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Good_Code.context;

import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Good_Code.strategies.IPaymentStrategy;

public class PaymentProcessor {
    private IPaymentStrategy paymentStrategy;

    public PaymentProcessor() {
        paymentStrategy = null;
    }

    public void setPaymentStrategy(IPaymentStrategy strategy) {
        if (paymentStrategy != null) {
            paymentStrategy = null;
        }
        paymentStrategy = strategy;
    }

    public void processPayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            throw new IllegalStateException("Payment Strategy is not set!");
        }
    }

    public void finalize() {
        // used for cleanup strategy instance when not needed
        if (paymentStrategy != null) {
            paymentStrategy = null;
        }
        System.out.println("Payment Strategy has been cleaned-up");
    }
}
