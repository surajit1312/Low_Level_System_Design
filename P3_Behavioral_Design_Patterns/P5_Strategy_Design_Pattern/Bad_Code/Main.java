package P3_Behavioral_Design_Patterns.P5_Strategy_Design_Pattern.Bad_Code;

public class Main {
    public static void main(String[] args) {
        PaymentService paymentService = new PaymentService();

        paymentService.processPayment("Credit Card");
        paymentService.processPayment("PayPal");
        paymentService.processPayment("GooglePay");
    }
}
