package P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Bad_Code;

import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Bad_Code.gateways.PayPalPaymentGateway;
import P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Bad_Code.gateways.StripePaymentGateway;

public class Main {
    public static void main(String[] args) {
        // payment via PayPal Payment Gateway (Legacy provider)
        PayPalPaymentGateway payPalPaymentGateway = new PayPalPaymentGateway();
        payPalPaymentGateway.makePayment(100.0);

        // payment via Stripe Payment Gateway (Latest provider)
        StripePaymentGateway stripePaymentGateway = new StripePaymentGateway();
        stripePaymentGateway.pay(200.0);
    }
}
