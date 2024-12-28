package P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.inventory.impl;

import java.util.ArrayList;
import java.util.List;

import P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.inventory.Inventory;
import P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.iterator.InventoryIterator;
import P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.iterator.impl.AmazonInventoryIterator;

public class AmazonInventory implements Inventory {

    List<String> items;

    public AmazonInventory() {
        this.items = new ArrayList<String>();
    }

    public void addItems(String item) {
        items.add(item);
    }

    @Override
    public InventoryIterator createIterator() {
        return new AmazonInventoryIterator(items);
    }

}
