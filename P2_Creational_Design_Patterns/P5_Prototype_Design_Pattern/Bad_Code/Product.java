package P2_Creational_Design_Patterns.P5_Prototype_Design_Pattern.Bad_Code;

public class Product {
    private String name;
    private String category;
    private double price;

    public Product(String name, String category, double price) {
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public Product(Product product) {
        this.name = product.name;
        this.category = product.category;
        this.price = product.price;
    }

    @Override
    public String toString() {
        return "Product [name=" + name + ", category=" + category + ", price=" + price + "]";
    }
}
