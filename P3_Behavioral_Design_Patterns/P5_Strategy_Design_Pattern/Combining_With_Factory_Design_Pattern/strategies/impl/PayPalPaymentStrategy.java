package P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.strategies.impl;

import P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Combining_With_Factory_Design_Pattern.strategies.IPaymentStrategy;

public class PayPalPaymentStrategy implements IPaymentStrategy {

    @Override
    public void pay(double amount) {
        System.out.println("Processing PayPal Payment of $" + amount);
    }

}
