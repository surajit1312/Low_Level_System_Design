package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.concrete;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Bad_Code.pizza.Pizza;

// Margherita Pizza
public class MargheritaPizza extends Pizza {

    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }

    @Override
    public double getCost() {
        return 200.00;
    }

}
