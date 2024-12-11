package P2_Creational_Design_Patterns.P5_Prototype_Design_Pattern.Bad_Code;

public class Main {
    public static void main(String[] args) {
        Product laptop = new Product("Laptop", "device", 999.99);
        System.out.println(laptop);

        /*
         * creating a similar object by manually copying values from above object
         * instance 'laptop'
         */
        Product laptop1 = new Product(laptop);
        System.out.println(laptop1);

        Product apple = new Product("Apple", "grocery", 1.99);
        System.out.println(apple);

        /*
         * creating a similar object by manually copying values from above object
         * instance 'apple'
         */
        Product apple2 = new Product(apple);
        System.out.println(apple2);
    }
}
