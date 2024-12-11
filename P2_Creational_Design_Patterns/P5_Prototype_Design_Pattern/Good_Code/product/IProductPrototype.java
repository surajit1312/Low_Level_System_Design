package P2_Creational_Design_Patterns.P5_Prototype_Design_Pattern.Good_Code.product;

public interface IProductPrototype {
    public abstract IProductPrototype clone();

    public abstract void displayProduct();
}
