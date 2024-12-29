package P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Good_Code.orders.concrete;

import P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Good_Code.orders.OrderProcessTemplate;

public class GroceryOrder extends OrderProcessTemplate {

    @Override
    public void selectProduct() {
        System.out.println("Selecting a grocery product...");
    }

    @Override
    public void processPayment() {
        System.out.println("Adding payment details for groceries...");
    }

}
