package P3_Behavioral_Design_Patterns.P3_Chain_Of_Responsibility_Design_Pattern.Bad_Code;

public class Main {
    public static void main(String[] args) {
        SwiggyOrderProcessor processor = new SwiggyOrderProcessor(true);
        processor.processOrder("Order123 with Delivery");
    }
}
