package P3_Behavioral_Design_Patterns.P4_Iterator_Design_Pattern.Bad_Code;

public class Main {
    public static void main(String[] args) {
        AmazonInventory inventory = new AmazonInventory();
        inventory.addItems("Laptop");
        inventory.addItems("Smartphone");
        inventory.addItems("Headphone");

        for (String item : inventory.getItems()) {
            System.out.println("Processing item : " + item);
        }
    }
}
