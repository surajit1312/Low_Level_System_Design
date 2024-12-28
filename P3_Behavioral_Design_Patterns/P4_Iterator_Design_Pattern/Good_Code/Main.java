package P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code;

import P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.inventory.impl.AmazonInventory;
import P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.iterator.InventoryIterator;

public class Main {
    public static void main(String[] args) {
        AmazonInventory inventory = new AmazonInventory();
        inventory.addItems("Laptop");
        inventory.addItems("Smartphone");
        inventory.addItems("Headphone");

        // Use the iterator to process inventory items
        InventoryIterator iterator = inventory.createIterator();
        while (iterator.hasNext()) {
            System.out.println("Processing item : " + iterator.next());
        }
    }
}
