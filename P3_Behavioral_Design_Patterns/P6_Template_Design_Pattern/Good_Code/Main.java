package P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Good_Code;

import P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Good_Code.orders.OrderProcessTemplate;
import P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Good_Code.orders.concrete.ElectronicsOrder;
import P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Good_Code.orders.concrete.GroceryOrder;

public class Main {
    public static void main(String[] args) {
        // Process electronics order
        OrderProcessTemplate electronicsOrder = new ElectronicsOrder();
        electronicsOrder.processOrder();

        // Process electronics order
        OrderProcessTemplate groceryOrder = new GroceryOrder();
        groceryOrder.processOrder();
    }
}
