package P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Good_Code;

import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Good_Code.context.PaymentProcessor;
import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Good_Code.strategies.impl.CreditCardPaymentStrategy;
import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Good_Code.strategies.impl.GooglePayPaymentStrategy;
import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Good_Code.strategies.impl.PayPalPaymentStrategy;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor paymentProcessor = new PaymentProcessor();

        paymentProcessor.setPaymentStrategy(new CreditCardPaymentStrategy());
        paymentProcessor.processPayment(1000);

        paymentProcessor.setPaymentStrategy(new PayPalPaymentStrategy());
        paymentProcessor.processPayment(500);

        paymentProcessor.setPaymentStrategy(new GooglePayPaymentStrategy());
        paymentProcessor.processPayment(1999);

        paymentProcessor.finalize();
    }
}
