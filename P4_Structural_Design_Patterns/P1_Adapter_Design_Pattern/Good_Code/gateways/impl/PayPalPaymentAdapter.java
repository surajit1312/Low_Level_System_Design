package P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.impl;

import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.PayPalPaymentGateway;
import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.IPaymentProcessor;

public class PayPalPaymentAdapter implements IPaymentProcessor {

    private PayPalPaymentGateway gateway;

    public PayPalPaymentAdapter(PayPalPaymentGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void makePayment(double amount) {
        gateway.makePayment(amount);
    }

}
