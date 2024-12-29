package P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern;

import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.context.PaymentProcessor;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.processPayment("Credit Card", 1000.00);
        paymentProcessor.processPayment("PayPal", 699.00);
        paymentProcessor.processPayment("Google Pay", 999.00);

        paymentProcessor.finalize();
    }
}
