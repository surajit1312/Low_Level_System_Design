package P2_Creational_Design_Patterns.P5_Prototype_Design_Pattern.Good_Code;

import P2_Creational_Design_Patterns.P5_Prototype_Design_Pattern.Good_Code.product.IProductPrototype;
import P2_Creational_Design_Patterns.P5_Prototype_Design_Pattern.Good_Code.product.impl.Product;

public class Main {
    public static void main(String[] args) {
        IProductPrototype laptop = new Product("Laptop", "device", 999.99);
        laptop.displayProduct();

        /*
         * creating a similar object by manually copying values from above object
         * instance 'laptop'
         */
        IProductPrototype laptop1 = laptop.clone();
        laptop1.displayProduct();

        IProductPrototype apple = new Product("Apple", "grocery", 1.99);
        apple.displayProduct();

        /*
         * creating a similar object by manually copying values from above object
         * instance 'apple'
         */
        IProductPrototype apple2 = apple.clone();
        apple2.displayProduct();
    }
}
