package P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.impl;

import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.IPaymentProcessor;
import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.StripePaymentGateway;

public class StripePaymentAdapter implements IPaymentProcessor {
    private StripePaymentGateway gateway;

    public StripePaymentAdapter(StripePaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void makePayment(double amount) {
        gateway.pay(amount);
    }

}
