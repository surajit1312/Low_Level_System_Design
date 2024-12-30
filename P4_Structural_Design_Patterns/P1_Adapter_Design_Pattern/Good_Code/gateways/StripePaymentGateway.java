package P4_Structural_Design_Patterns.P1_Adapter_Design_Pattern.Good_Code.gateways;

public class StripePaymentGateway {
    public void pay(double amount) {
        System.out.println("Payment of $" + amount + " made using Stripe.");
    }
}
