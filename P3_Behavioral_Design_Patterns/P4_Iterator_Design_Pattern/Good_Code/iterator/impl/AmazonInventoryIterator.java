package P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.iterator.impl;

import java.util.List;

import P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Good_Code.iterator.InventoryIterator;

public class AmazonInventoryIterator implements InventoryIterator {

    private int position = 0;
    private List<String> items;

    public AmazonInventoryIterator(List<String> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public String next() {
        if (!hasNext()) {
            throw new IllegalStateException("No more items left in the inventory!");
        }
        return items.get(position++);
    }

}
