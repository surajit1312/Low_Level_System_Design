package P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.factories;

import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.strategies.IPaymentStrategy;
import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.strategies.impl.CreditCardPaymentStrategy;
import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.strategies.impl.GooglePayPaymentStrategy;
import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.strategies.impl.PayPalPaymentStrategy;

public class PaymentFactory {
    public static IPaymentStrategy createPaymentStrategy(String paymentType) {
        if (paymentType.equals("Credit Card")) {
            return new CreditCardPaymentStrategy();
        } else if (paymentType.equals("PayPal")) {
            return new PayPalPaymentStrategy();
        } else {
            return new GooglePayPaymentStrategy();
        }
    }
}
