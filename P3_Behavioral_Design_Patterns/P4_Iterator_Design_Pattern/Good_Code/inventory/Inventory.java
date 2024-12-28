package P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.inventory;

import P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.iterator.InventoryIterator;

public interface Inventory {
    public InventoryIterator createIterator();
}
