package P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Good_Code.orders;

public abstract class OrderProcessTemplate {

    public final void processOrder() {
        selectProduct();
        processPayment();
        deliverProduct();
        System.out.println("");
    }

    public abstract void selectProduct();

    public abstract void processPayment();

    public void deliverProduct() {
        System.out.println("Delivering product...");
    }
}
