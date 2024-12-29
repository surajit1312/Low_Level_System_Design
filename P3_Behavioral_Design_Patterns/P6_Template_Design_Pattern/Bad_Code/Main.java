package P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Bad_Code;

import P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Bad_Code.orders.ElectronicsOrder;
import P3_Behavioral_Design_Patterns.P6_Template_Design_Pattern.Bad_Code.orders.GroceryOrder;

public class Main {
    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder = new ElectronicsOrder();
        electronicsOrder.processOrder();

        GroceryOrder groceryOrder = new GroceryOrder();
        groceryOrder.processOrder();
    }
}
