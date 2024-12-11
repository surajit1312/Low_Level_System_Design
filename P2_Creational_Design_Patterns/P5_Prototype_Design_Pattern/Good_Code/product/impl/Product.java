package P2_Creational_Design_Patterns.P5_Prototype_Design_Pattern.Good_Code.product.impl;

import P2_Creational_Design_Patterns.P5_Prototype_Design_Pattern.Good_Code.product.IProductPrototype;

public class Product implements IProductPrototype {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    @Override
    public IProductPrototype clone() {
        return new Product(name, category, price);
    }

    @Override
    public void displayProduct() {
        System.out.println("Product [name=" + name + ", category=" + category + ", price=" + price + "]");
    }
}
