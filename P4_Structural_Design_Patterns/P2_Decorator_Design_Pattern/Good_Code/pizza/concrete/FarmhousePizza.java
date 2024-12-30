package P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.concrete;

import P4_Structural_Design_Patterns.P2_Decorator_Design_Pattern.Good_Code.pizza.Pizza;

public class FarmhousePizza extends Pizza {

    @Override
    public String getDescription() {
        return "Farmhouse Pizza";
    }

    @Override
    public double getCost() {
        return 300.00;
    }

}
