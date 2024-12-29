package P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Bad_Code;

public class PaymentService {
    public void processPayment(String paymentMethod) {
        if (paymentMethod.equals("Credit Card")) {
            System.out.println("Processing payment via Credit Card...");
        } else if (paymentMethod.equals("PayPal")) {
            System.out.println("Processing payment via PayPal...");
        } else if (paymentMethod.equals("GooglePay")) {
            System.out.println("Processing payment via Google Pay...");
        } else {
            System.out.println("Invalid payment method selected.");
        }
    }
}
