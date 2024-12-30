package P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code;

import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.IPaymentProcessor;
import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.PayPalPaymentGateway;
import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.StripePaymentGateway;
import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.impl.PayPalPaymentAdapter;
import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways.impl.StripePaymentAdapter;

public class Main {
    public static void main(String[] args) {
        IPaymentProcessor payPalAdapter = new PayPalPaymentAdapter(new PayPalPaymentGateway());
        payPalAdapter.makePayment(100);

        IPaymentProcessor stripeAdapter = new StripePaymentAdapter(new StripePaymentGateway());
        stripeAdapter.makePayment(200);
    }
}
