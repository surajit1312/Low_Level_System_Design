package P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Bad_Code;

import java.util.ArrayList;
import java.util.List;

public class AmazonInventory {
    private List<String> items;

    public AmazonInventory() {
        items = new ArrayList<String>();
    }

    public void addItems(String item) {
        items.add(item);
    }

    public List<String> getItems() {
        return items;
    }
}
